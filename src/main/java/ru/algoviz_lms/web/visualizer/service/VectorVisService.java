package ru.algoviz_lms.web.visualizer.service;

import org.springframework.stereotype.Service;
import ru.algoviz_lms.algo_impls.vector.BasicVectorVisualizer;
import ru.algoviz_lms.web.visualizer.dto.*;
import ru.algoviz_lms.algo_impls.vector.VectorAlgorithm;
import ru.algoviz_lms.algo_impls.vector.VectorVisualizer;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class VectorVisService {
    Map<String, VectorAlgorithm> algorithms;

    public VectorVisService(List<VectorAlgorithm> allAlgorithms) {
        this.algorithms = allAlgorithms.stream()
                .collect(Collectors.toUnmodifiableMap(
                        VectorAlgorithm::getName,
                        Function.identity()
                ));
    }

    public Set<String> availableAlgorithms() {
        return algorithms.keySet();
    }

    public VectorVisSteps executeAlgorithm(VecVisDto dto){
        VectorAlgorithm algorithm = algorithms.get(dto.algorithmName());
        if (algorithm == null){
            throw new UnknownAlgorithmException(dto.algorithmName(), availableAlgorithms());
        }
        VectorVisualizer vis = new BasicVectorVisualizer(dto.data());
        algorithm.execute(vis);
        return new VectorVisSteps(vis.getSteps());
    }
}
