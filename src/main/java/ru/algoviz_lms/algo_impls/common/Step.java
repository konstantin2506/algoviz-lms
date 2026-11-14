package ru.algoviz_lms.algo_impls.common;

public interface Step {
    ClassValue<String> NAME_CACHE = new ClassValue<>() {
        @Override
        protected String computeValue(Class<?> type) {
            VizStep annotation = type.getAnnotation(VizStep.class);
            if (annotation != null && !annotation.value().isEmpty()) {
                return annotation.value();
            }
            // Если имя не задано явно, берем название самого record
            return type.getSimpleName();
        }
    };

    default String getName() {
        return NAME_CACHE.get(this.getClass());
    }

    default String asString(JsonMapper mapper){
        return mapper.convertToString(this);
    }
}
