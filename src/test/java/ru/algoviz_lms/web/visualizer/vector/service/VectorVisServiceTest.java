package ru.algoviz_lms.web.visualizer.vector.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ru.algoviz_lms.algo_impls.vector.algorithms.*;
import ru.algoviz_lms.web.visualizer.vector.dto.UnknownAlgorithmException;
import ru.algoviz_lms.web.visualizer.vector.dto.VecVisDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VectorVisServiceTest {

    @Test
    void registersAllAlgorithms() {
        var service = new VectorVisService(List.of(
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort()
        ));

        assertThat(service.availableAlgorithms())
                .containsExactlyInAnyOrder(
                        "bubbleSort",
                        "selectionSort",
                        "insertionSort",
                        "quickSort",
                        "mergeSort"
                );
    }
    @Test
    void executeAlgorithm(){
        String name = "aboba67Algo";
        var service = new VectorVisService(List.of(
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort()
        ));

        assertThrows(UnknownAlgorithmException.class, () -> service.executeAlgorithm(new VecVisDto(name, List.of(1))));
    }


}