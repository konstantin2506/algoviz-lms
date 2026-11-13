package ru.algoviz_lms.algo_impls.common;

import java.util.ArrayList;
import java.util.List;

public class BasicVisualizer implements Visualizer{
    private final List<Step> stepStorage = new ArrayList<>();
    private final Step initialState;

    public BasicVisualizer(Step initialState){
        this.initialState = initialState;
    }

    @Override
    public void log(String info) {
        stepStorage.add(new LogStep(info));
    }

    @Override
    public StepsDto getSteps() {
        return new StepsDto(initialState, stepStorage);
    }


    protected void addStep(Step step){
        stepStorage.add(step);
    }
    protected void error(String reason){
        stepStorage.add(new ErrorStep(reason));
        throw new ErrorInStepException(reason);
    }
}
