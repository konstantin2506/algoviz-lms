package ru.algoviz_lms.web.visualizer.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class UnknownAlgorithmException extends RuntimeException {
    private final String name;
    private final Set<String> available;
    public UnknownAlgorithmException(String name, Set<String> available) {
        super("");
        this.available = available;
        this.name = name;
    }
}
