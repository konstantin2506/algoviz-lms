package ru.algoviz_lms.algo_impls.vector;

import ru.algoviz_lms.algo_impls.common.BasicVisualizer;
import ru.algoviz_lms.algo_impls.common.JsonMapper;
import ru.algoviz_lms.algo_impls.vector.steps.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VectorVisualizer extends BasicVisualizer {
    private final List<Integer> vec;
    public VectorVisualizer(IntVecDto vecDto) {
        super(new VecInitialStep(vecDto.data()));
        this.vec = new ArrayList<>(vecDto.data());
    }
    public int size(){
        return vec.size();
    }
    public void swap(int i, int j){
        addStep(new SwapStep(List.of(i, j)));
        Collections.swap(vec, i, j);
    }
    public int compare(int i, int j){
        int cmp = Integer.compare(vec.get(i), vec.get(j));
        String stringRes = cmp > 0 ? "GREATER" : cmp < 0 ? "LESS" : "EQUAL";
        addStep(new CompareStep(List.of(i, j), stringRes));
        return cmp;
    }
    public void highlight(List<Integer> indices){
        addStep(new HighlightStep(indices));
    }
    public void unhighlight(List<Integer> indices){
        addStep(new UnhighlightStep(indices));
    }
    public void setSorted(int idx){
        addStep(new SetSortedStep(List.of(idx)));
    }

}
