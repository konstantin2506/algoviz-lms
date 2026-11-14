package ru.algoviz_lms.algo_impls.vector.algorithms;

import org.springframework.stereotype.Component;
import ru.algoviz_lms.algo_impls.vector.VectorAlgorithm;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

import java.util.List;

@Component
public class QuickSort implements VectorAlgorithm {

    @Override
    public String getName() {
        return "quickSort";
    }

    @Override
    public void execute(VectorVisualizer viz) {
        int n = viz.size();
        if (n <= 1) {
            viz.log("Массив пуст или содержит один элемент — сортировать нечего");
            return;
        }
        viz.log("Начинаем быструю сортировку, элементов: " + n);
        quickSort(viz, 0, n - 1);
        viz.log("Сортировка завершена");
    }

    private void quickSort(VectorVisualizer viz, int lo, int hi) {
        if (lo > hi) return;

        if (lo == hi) {
            viz.setSorted(lo);
            return;
        }

        viz.log("Сортируем подмассив [" + lo + ".." + hi + "]");
        int pivotIndex = partition(viz, lo, hi);

        viz.setSorted(pivotIndex);
        viz.log("Опорный элемент встал на позицию " + pivotIndex + " — это его финальное место");

        quickSort(viz, lo, pivotIndex - 1);
        quickSort(viz, pivotIndex + 1, hi);
    }

    private int partition(VectorVisualizer viz, int lo, int hi) {
        viz.log("Разбиение: pivot — последний элемент подмассива (позиция " + hi + ")");
        viz.highlight(List.of(hi));

        int i = lo;
        for (int j = lo; j < hi; j++) {
            viz.highlight(List.of(j));
            int cmp = viz.compare(j, hi);
            viz.unhighlight(List.of(j));

            if (cmp < 0) {
                if (i != j) {
                    viz.log("arr[" + j + "] < pivot, меняем с позицией " + i);
                    viz.swap(i, j);
                }
                i++;
            }
        }

        if (i != hi) {
            viz.log("Ставим pivot на финальную позицию " + i);
            viz.swap(i, hi);
        }
        viz.unhighlight(List.of(hi));

        return i;
    }
}