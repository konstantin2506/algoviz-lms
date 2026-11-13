package ru.algoviz_lms.algo_impls.vector.steps;

import ru.algoviz_lms.algo_impls.common.Step;
import ru.algoviz_lms.algo_impls.common.VizStep;

@VizStep("highlightStep")
public record HighlightStep(int idx) implements Step {
}
