package ru.algoviz_lms;

import ru.algoviz_lms.algo_impls.common.*;
import ru.algoviz_lms.algo_impls.vector.IntVecDto;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsonMapper mapper = new BasicJsonMapper();
        var visualizer = new VectorVisualizer(mapper, new IntVecDto(List.of(1,2,3,4,5,6,7)));
        visualizer.log("hello");
        visualizer.log("algoviz-lms");

        try {
            visualizer.get(4);


            System.out.println("Success:");
        }catch (ErrorInStepException e){
            System.out.println("Fail:");
        }finally {
            System.out.println("Steps:");
            System.out.println(visualizer.getSteps());
        }
    }
}