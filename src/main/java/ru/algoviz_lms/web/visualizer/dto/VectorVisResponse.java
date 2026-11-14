package ru.algoviz_lms.web.visualizer.dto;

import ru.algoviz_lms.algo_impls.common.Step;

import java.util.List;

public record VectorVisResponse(VectorDataDto dataStructure, List<Step> steps) {
}
