package ru.algoviz_lms.algo_impls.vector;

import ru.algoviz_lms.algo_impls.common.Visualizer;
import java.util.List;

public interface VectorVisualizer extends Visualizer {
    int size();
    int compare(int i, int j);
    void swap(int i, int j);

    void highlight(List<Integer> indices);
    void unhighlight(List<Integer> indices);
    void setSorted(int idx);
    void range(int from, int to, String role);    // подсветить диапазон
    void clearRange();                            // снять подсветку

    int get(int index);
    void assign(int index, int value);
    void assign(int index, int value, Integer fromIndex);
}