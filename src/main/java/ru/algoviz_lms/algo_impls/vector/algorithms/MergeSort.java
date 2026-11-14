package ru.algoviz_lms.algo_impls.vector.algorithms;

import org.springframework.stereotype.Component;
import ru.algoviz_lms.algo_impls.vector.VectorAlgorithm;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

@Component
public class MergeSort implements VectorAlgorithm {

    @Override
    public String getName() {
        return "mergeSort";
    }

    @Override
    public void execute(VectorVisualizer viz) {
        int n = viz.size();
        if (n <= 1) {
            viz.log("Массив пуст или содержит один элемент — сортировать нечего");
            return;
        }
        viz.log("Начинаем сортировку слиянием, элементов: " + n);
        mergeSort(viz, 0, n - 1);
        for (int i = 0; i < n; i++) viz.setSorted(i);
        viz.log("Сортировка завершена");
    }

    private void mergeSort(VectorVisualizer viz, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        viz.log("Делим [" + lo + ".." + hi + "] на две части");
        mergeSort(viz, lo, mid);
        mergeSort(viz, mid + 1, hi);
        merge(viz, lo, mid, hi);
    }

    private void merge(VectorVisualizer viz, int lo, int mid, int hi) {
        int leftSize  = mid - lo + 1;
        int rightSize = hi - mid;
        int[] left  = new int[leftSize];
        int[] right = new int[rightSize];
        int[] fromLeft  = new int[leftSize];
        int[] fromRight = new int[rightSize];

        for (int k = 0; k < leftSize; k++) {
            left[k]     = viz.get(lo + k);
            fromLeft[k] = lo + k;
        }
        for (int k = 0; k < rightSize; k++) {
            right[k]     = viz.get(mid + 1 + k);
            fromRight[k] = mid + 1 + k;
        }

        viz.log("Сливаем [" + lo + ".." + mid + "] и [" + (mid + 1) + ".." + hi + "]");
        viz.range(lo, hi, "merge");   // ← подсветить весь диапазон

        int i = 0, j = 0, k = lo;
        while (i < leftSize && j < rightSize) {
            viz.log("Сравниваем " + left[i] + " и " + right[j]);
            if (left[i] <= right[j]) {
                viz.assign(k, left[i], fromLeft[i]);   // ← передаём fromIndex
                i++;
            } else {
                viz.assign(k, right[j], fromRight[j]);  // ← передаём fromIndex
                j++;
            }
            k++;
        }
        while (i < leftSize)  { viz.assign(k++, left[i],  fromLeft[i]);  i++; }
        while (j < rightSize) { viz.assign(k++, right[j], fromRight[j]); j++; }

        viz.clearRange();
    }
}