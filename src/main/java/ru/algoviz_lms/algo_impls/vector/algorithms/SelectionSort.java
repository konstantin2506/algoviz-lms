package ru.algoviz_lms.algo_impls.vector.algorithms;

import org.springframework.stereotype.Component;
import ru.algoviz_lms.algo_impls.vector.VectorAlgorithm;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

import java.util.List;

@Component
public class SelectionSort implements VectorAlgorithm {

    @Override
    public String getName() {
        return "selectionSort";
    }

    @Override
    public void execute(VectorVisualizer viz) {
        int n = viz.size();

        if (n <= 1) {
            viz.log("Массив пуст или содержит один элемент — сортировать нечего");
            return;
        }

        viz.log("Начинаем сортировку выбором, элементов: " + n);

        for (int i = 0; i < n - 1; i++) {
            viz.log("Проход " + (i + 1) + " из " + (n - 1)
                    + ". Ищем минимум в диапазоне [" + i + ".." + (n - 1) + "]");

            int minIdx = i;
            viz.highlight(List.of(minIdx));

            for (int j = i + 1; j < n; j++) {
                viz.highlight(List.of(j));
                viz.log("Сравниваем позицию " + j + " с текущим минимумом на " + minIdx);

                int cmp = viz.compare(j, minIdx);
                viz.unhighlight(List.of(j));

                if (cmp < 0) {
                    viz.unhighlight(List.of(minIdx));
                    minIdx = j;
                    viz.highlight(List.of(minIdx));
                    viz.log("Новый минимум: позиция " + minIdx);
                }
            }

            viz.unhighlight(List.of(minIdx));

            if (minIdx != i) {
                viz.log("Меняем местами позиции " + i + " и " + minIdx);
                viz.swap(i, minIdx);
            } else {
                viz.log("Минимум уже на позиции " + i + ", обмена не нужно");
            }

            viz.setSorted(i);
        }

        viz.setSorted(n - 1);
        viz.log("Сортировка завершена");
    }
}