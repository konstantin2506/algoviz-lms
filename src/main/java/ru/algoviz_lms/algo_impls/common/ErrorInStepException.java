package ru.algoviz_lms.algo_impls.common;

public class ErrorInStepException extends RuntimeException {
    public ErrorInStepException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}
