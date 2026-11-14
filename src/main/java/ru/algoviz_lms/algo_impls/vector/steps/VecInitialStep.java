package ru.algoviz_lms.algo_impls.vector.steps;

import ru.algoviz_lms.algo_impls.common.Step;
import ru.algoviz_lms.algo_impls.common.VizStep;

import java.util.List;

@VizStep(value = "vector")
public record VecInitialStep(List<Integer> initialState) implements Step {
}
