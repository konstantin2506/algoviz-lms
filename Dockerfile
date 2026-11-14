# ============ Stage 1: build ============
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# сначала копируем только файлы сборки — кешируем слой с зависимостями
COPY gradlew settings.gradle build.gradle ./
COPY gradle/ gradle/
RUN chmod +x gradlew

# кешируем скачивание зависимостей (не пересобирается при правке кода)
RUN ./gradlew dependencies --no-daemon || true

# теперь копируем исходники и собираем jar
COPY src/ src/
RUN ./gradlew bootJar --no-daemon -x test

# ============ Stage 2: runtime ============
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# непривилегированный пользователь
RUN addgroup -S app && adduser -S app -G app
USER app

# копируем только собранный jar
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

# health check — чтобы Docker/k8s знали, жив ли сервис
HEALTHCHECK --interval=30s --timeout=3s --start-period=20s --retries=3 \
  CMD wget -qO- http://localhost:8080/actuator/health 2>/dev/null || \
      wget -qO- http://localhost:8080/ 2>/dev/null || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]