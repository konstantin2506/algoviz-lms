package ru.algoviz_lms.algo_impls.vector.steps;

import ru.algoviz_lms.algo_impls.common.Step;
import ru.algoviz_lms.algo_impls.common.VizStep;

import java.util.List;

@VizStep("unhighlight")
public record UnhighlightStep(List<Integer> indices) implements Step {
}
