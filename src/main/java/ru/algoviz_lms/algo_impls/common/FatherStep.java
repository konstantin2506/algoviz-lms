package ru.algoviz_lms.algo_impls.common;

import java.util.List;

@VizStep(value = "step-pack")
public record FatherStep(List<Step> steps) implements Step{
}
