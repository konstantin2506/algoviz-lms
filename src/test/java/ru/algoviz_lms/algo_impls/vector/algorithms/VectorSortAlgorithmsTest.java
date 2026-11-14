package ru.algoviz_lms.algo_impls.vector.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.algoviz_lms.algo_impls.vector.BasicVectorVisualizer;
import ru.algoviz_lms.algo_impls.vector.VectorAlgorithm;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class VectorSortAlgorithmsTest {

    /** Параметризация: каждый тест прогоняется на всех 5 алгоритмах */
    static Stream<Arguments> algorithms() {
        return Stream.of(
                Arguments.of("bubbleSort",    new BubbleSort()),
                Arguments.of("selectionSort", new SelectionSort()),
                Arguments.of("insertionSort", new InsertionSort()),
                Arguments.of("quickSort",     new QuickSort()),
                Arguments.of("mergeSort",     new MergeSort())
        );
    }

    // ---------- Базовый кейс ----------
    @ParameterizedTest(name = "{0} сортирует неотсортированный массив")
    @MethodSource("algorithms")
    void sortsUnsortedArray(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(5, 2, 9, 1, 8, 3, 6));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(1, 2, 3, 5, 6, 8, 9);
    }

    // ---------- Edge cases ----------
    @ParameterizedTest(name = "{0} обрабатывает пустой массив")
    @MethodSource("algorithms")
    void handlesEmptyArray(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of());
        algo.execute(viz);
        assertThat(viz.getVector()).isEmpty();
    }

    @ParameterizedTest(name = "{0} обрабатывает массив из одного элемента")
    @MethodSource("algorithms")
    void handlesSingleElement(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(42));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(42);
    }

    @ParameterizedTest(name = "{0} обрабатывает уже отсортированный массив")
    @MethodSource("algorithms")
    void handlesAlreadySorted(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(1, 2, 3, 4, 5));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(1, 2, 3, 4, 5);
    }

    @ParameterizedTest(name = "{0} сортирует массив в обратном порядке")
    @MethodSource("algorithms")
    void sortsReverseSorted(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(5, 4, 3, 2, 1));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(1, 2, 3, 4, 5);
    }

    @ParameterizedTest(name = "{0} обрабатывает два элемента (по возрастанию)")
    @MethodSource("algorithms")
    void handlesTwoElementsSorted(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(1, 2));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(1, 2);
    }

    @ParameterizedTest(name = "{0} обрабатывает два элемента (по убыванию)")
    @MethodSource("algorithms")
    void handlesTwoElementsUnsorted(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(2, 1));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(1, 2);
    }

    @ParameterizedTest(name = "{0} обрабатывает массив из одинаковых элементов")
    @MethodSource("algorithms")
    void handlesAllEqual(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(7, 7, 7, 7));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(7, 7, 7, 7);
    }

    @ParameterizedTest(name = "{0} обрабатывает дубликаты")
    @MethodSource("algorithms")
    void handlesDuplicates(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(3, 1, 3, 2, 1));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(1, 1, 2, 3, 3);
    }

    @ParameterizedTest(name = "{0} обрабатывает отрицательные числа")
    @MethodSource("algorithms")
    void handlesNegativeNumbers(String name, VectorAlgorithm algo) {
        var viz = new BasicVectorVisualizer(List.of(-3, 5, -1, 0, -7, 2));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(-7, -3, -1, 0, 2, 5);
    }

    @ParameterizedTest(name = "{0} не переполняется на Integer.MIN/MAX")
    @MethodSource("algorithms")
    void handlesExtremeIntValues(String name, VectorAlgorithm algo) {
        // этот тест ловит баг `vec.get(i) - vec.get(j)` в compare
        var viz = new BasicVectorVisualizer(
                List.of(Integer.MAX_VALUE, Integer.MIN_VALUE, 0));
        algo.execute(viz);
        assertThat(viz.getVector()).containsExactly(
                Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
    }

    @ParameterizedTest(name = "{0} возвращает корректное имя")
    @MethodSource("algorithms")
    void returnsCorrectName(String expectedName, VectorAlgorithm algo) {
        assertThat(algo.getName()).isEqualTo(expectedName);
    }
}