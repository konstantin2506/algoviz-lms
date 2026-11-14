package ru.algoviz_lms.algo_impls.vector.steps;

import ru.algoviz_lms.algo_impls.common.Step;
import ru.algoviz_lms.algo_impls.common.VizStep;

@VizStep(value = "range")
public record RangeStep(int from, int to, String role) implements Step {
}
