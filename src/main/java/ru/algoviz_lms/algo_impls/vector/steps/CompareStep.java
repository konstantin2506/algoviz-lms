package ru.algoviz_lms.algo_impls.vector.steps;

import ru.algoviz_lms.algo_impls.common.Step;
import ru.algoviz_lms.algo_impls.common.VizStep;

import java.util.List;

@VizStep(value = "compare")
public record CompareStep(List<Integer> indices, String result) implements Step {
}
