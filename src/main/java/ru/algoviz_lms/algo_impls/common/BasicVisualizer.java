package ru.algoviz_lms.algo_impls.common;

import java.util.ArrayList;
import java.util.List;

public class BasicVisualizer implements Visualizer{
    private final List<Step> stepStorage = new ArrayList<>();

    public BasicVisualizer(){}

    @Override
    public void log(String info) {
        stepStorage.add(new LogStep(info));
    }

    @Override
    public List<Step> getSteps() {
        return stepStorage;
    }


    protected void addStep(Step step){
        stepStorage.add(step);
    }
    protected void error(String reason){
        stepStorage.add(new ErrorStep(reason));
        throw new ErrorInStepException(reason);
    }
}
