package ru.algoviz_lms;

import ru.algoviz_lms.algo_impls.common.*;
import ru.algoviz_lms.algo_impls.vector.BubbleSort;
import ru.algoviz_lms.algo_impls.vector.IntVecDto;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonMapper mapper = new BasicJsonMapper();
        var v = new VectorVisualizer(new IntVecDto(List.of(2,5,5,3,2,5,6,8,1)));

        try {
            BubbleSort.sort(v);
            System.out.println("Success:");

        }catch (ErrorInStepException e){
            System.out.println("Fail:");
        }finally {
            System.out.println("Steps:");
            System.out.println( mapper.convertToString(v.getSteps()));
        }
    }
}