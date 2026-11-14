package ru.algoviz_lms.web.visualizer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.algoviz_lms.algo_impls.vector.*;
import ru.algoviz_lms.algo_impls.vector.algorithms.BubbleSort;
import ru.algoviz_lms.web.visualizer.dto.VecVisDto;
import ru.algoviz_lms.web.visualizer.dto.VectorDataDto;
import ru.algoviz_lms.web.visualizer.dto.VectorVisRequest;
import ru.algoviz_lms.web.visualizer.dto.VectorVisResponse;
import ru.algoviz_lms.web.visualizer.service.VectorVisService;

import java.util.Set;


@RestController
@RequestMapping("/api/visualize/vector")
public class VectorVisController {

    private final VectorVisService service;

    public VectorVisController(VectorVisService service) {
        this.service = service;
    }

    @PostMapping("/{algorithm}")
    public VectorVisResponse visualize(
            @PathVariable String algorithm,
            @RequestBody VectorVisRequest req
    ) {
        var result = service.executeAlgorithm(new VecVisDto(algorithm, req.data()));
        return new VectorVisResponse(new VectorDataDto("vector", req.data()), result.steps());
    }

    @GetMapping("/algorithms")
    public Set<String> algorithms() {
        return service.availableAlgorithms();
    }
}