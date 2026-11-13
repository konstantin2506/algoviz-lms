package ru.algoviz_lms.algo_impls.vector;

import ru.algoviz_lms.algo_impls.common.BasicVisualizer;
import ru.algoviz_lms.algo_impls.common.JsonMapper;
import ru.algoviz_lms.algo_impls.vector.steps.HighlightStep;
import ru.algoviz_lms.algo_impls.vector.steps.SwapStep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VectorVisualizer extends BasicVisualizer {
    private final List<Integer> vec;
    public VectorVisualizer(JsonMapper mapper, IntVecDto vecDto) {
        super(mapper);
        this.vec = new ArrayList<>(vecDto.data());
    }

    public void swap(int i, int j){
        Collections.swap(vec, i, j);
        addStep(new SwapStep(i, j));
    }
    public void highlight(int idx){
        addStep(new HighlightStep(idx));
    }

    public Integer get(int idx){
        Integer res = 0;
        try{
            res = vec.get(idx);
        }catch (Exception e){
            error(e.getMessage());
        }
        return res;
    }

    public void set(int idx, int value){
        try{
            vec.set(idx, value);
        }catch (Exception e){
            error(e.getMessage());
        }
    }


}
