package ru.algoviz_lms.algo_impls.vector.algorithms;

import org.springframework.stereotype.Component;
import ru.algoviz_lms.algo_impls.vector.VectorAlgorithm;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

import java.util.List;

@Component
public class BubbleSort implements VectorAlgorithm {

    @Override
    public String getName() {
        return "bubbleSort";
    }

    public void execute(VectorVisualizer viz) {
        int n = viz.size();
        if (n <= 1) {
            viz.log("Массив пуст или содержит один элемент — сортировать нечего");
            return;
        }
        viz.log("Начинаем пузырьковую сортировку, элементов: " + n);
        int completedPasses = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            viz.log("Проход " + (i + 1) + " из " + (n - 1));

            for (int j = 0; j < n - i - 1; j++) {
                List<Integer> pair = List.of(j, j + 1);
                viz.highlight(pair);
                viz.log("Сравниваем элементы с индексами " + j + " и " + (j + 1));
                if (viz.compare(j, j + 1) > 0) {
                    viz.log("Левый больше правого — меняем местами");
                    viz.swap(j, j + 1);
                    swapped = true;
                }
                viz.unhighlight(pair);
            }
            viz.setSorted(n - 1 - i);
            completedPasses = i + 1;
            if (!swapped) {
                viz.log("Перестановок не было — массив уже отсортирован, выходим");
                break;
            }
        }
        for (int k = 0; k < n - completedPasses; k++) {
            viz.setSorted(k);
        }
        viz.log("Сортировка завершена");
    }
}