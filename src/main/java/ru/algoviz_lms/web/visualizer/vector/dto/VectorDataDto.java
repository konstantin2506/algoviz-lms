package ru.algoviz_lms.web.visualizer.vector.dto;

import java.util.List;

public record VectorDataDto(
        String name,
        List<Integer> initialState
) {
}
