package ru.algoviz_lms.algo_impls.vector.algorithms;

import org.springframework.stereotype.Component;
import ru.algoviz_lms.algo_impls.vector.VectorAlgorithm;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

import java.util.List;

@Component
public class InsertionSort implements VectorAlgorithm {

    @Override
    public String getName() {
        return "insertionSort";
    }

    @Override
    public void execute(VectorVisualizer viz) {
        int n = viz.size();

        if (n <= 1) {
            viz.log("Массив пуст или содержит один элемент — сортировать нечего");
            return;
        }

        viz.log("Начинаем сортировку вставками, элементов: " + n);

        for (int i = 1; i < n; i++) {
            viz.log("Вставляем элемент с позиции " + i + " в отсортированный префикс [0.." + (i - 1) + "]");

            int j = i;
            while (j > 0) {
                viz.highlight(List.of(j - 1, j));
                viz.log("Сравниваем позиции " + (j - 1) + " и " + j);

                int cmp = viz.compare(j - 1, j);
                viz.unhighlight(List.of(j - 1, j));

                if (cmp <= 0) {
                    viz.log("Порядок верный, элемент " + i + " на своём месте");
                    break;
                }

                viz.log("Меняем местами " + (j - 1) + " и " + j + ", продолжаем двигать влево");
                viz.swap(j - 1, j);
                j--;
            }
        }

        for (int k = 0; k < n; k++) {
            viz.setSorted(k);
        }
        viz.log("Сортировка завершена");
    }
}