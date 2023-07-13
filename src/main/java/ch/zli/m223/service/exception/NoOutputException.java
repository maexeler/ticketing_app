package ch.zli.m223.service.exception;

public class NoOutputException extends RuntimeException {
    public NoOutputException() {
        super("", null, true, false);
    }
}
