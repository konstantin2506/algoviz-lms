package ru.algoviz_lms.algo_impls.vector;

import ru.algoviz_lms.algo_impls.common.BasicVisualizer;
import ru.algoviz_lms.algo_impls.vector.steps.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasicVectorVisualizer extends BasicVisualizer implements VectorVisualizer{
    private final List<Integer> vec;
    public BasicVectorVisualizer(List<Integer> vec) {
        super();
        this.vec = new ArrayList<>(vec);
    }
    @Override
    public int size(){
        return vec.size();
    }

    @Override
    public void swap(int i, int j){
        addStep(new SwapStep(List.of(i, j)));
        Collections.swap(vec, i, j);
    }
    @Override
    public int compare(int i, int j){
        int cmp = Integer.compare(vec.get(i), vec.get(j));
        String stringRes = cmp > 0 ? "GREATER" : cmp < 0 ? "LESS" : "EQUAL";
        addStep(new CompareStep(List.of(i, j), stringRes));
        return cmp;
    }
    @Override
    public void highlight(List<Integer> indices){
        addStep(new HighlightStep(indices));
    }
    @Override
    public void unhighlight(List<Integer> indices){
        addStep(new UnhighlightStep(indices));
    }
    @Override
    public void setSorted(int idx){
        addStep(new SetSortedStep(List.of(idx)));
    }

    @Override
    public int get(int index) {
        return vec.get(index);
    }

    @Override
    public void range(int from, int to, String role) {
        addStep(new RangeStep(from, to, role));
    }

    @Override
    public void clearRange() {
        addStep(new RangeStep(-1, -1, "clear"));
    }

    @Override
    public void assign(int index, int value) {
        assign(index, value, null);
    }

    @Override
    public void assign(int index, int value, Integer fromIndex) {
        addStep(new AssignStep(index, value, fromIndex));
        vec.set(index, value);
    }

}
