package ru.algoviz_lms.algo_impls.vector.steps;

import ru.algoviz_lms.algo_impls.common.Step;
import ru.algoviz_lms.algo_impls.common.VizStep;

@VizStep(value = "assign")
public record AssignStep(int index, int value, Integer fromIndex) implements Step {
}
