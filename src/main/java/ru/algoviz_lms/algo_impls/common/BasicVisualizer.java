package ru.algoviz_lms.algo_impls.common;

import java.util.ArrayList;
import java.util.List;

public class BasicVisualizer implements Visualizer{
    private final List<Step> stepStorage = new ArrayList<>();
    private final JsonMapper mapper;

    public BasicVisualizer(JsonMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void log(String info) {
        stepStorage.add(new LogStep(info));
    }

    @Override
    public String getSteps() {
        var fs = new FatherStep(stepStorage);
        return fs.asString(mapper);
    }

    protected void addStep(Step step){
        stepStorage.add(step);
    }

    protected void error(String reason){
        stepStorage.add(new ErrorStep(reason));
        throw new ErrorInStepException(reason);
    }
}
