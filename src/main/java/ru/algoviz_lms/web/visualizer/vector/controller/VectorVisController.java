package ru.algoviz_lms.web.visualizer.vector.controller;

import org.springframework.web.bind.annotation.*;
import ru.algoviz_lms.web.visualizer.vector.dto.VecVisDto;
import ru.algoviz_lms.web.visualizer.vector.dto.VectorDataDto;
import ru.algoviz_lms.web.visualizer.vector.dto.VectorVisRequest;
import ru.algoviz_lms.web.visualizer.vector.dto.VectorVisResponse;
import ru.algoviz_lms.web.visualizer.vector.service.VectorVisService;

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