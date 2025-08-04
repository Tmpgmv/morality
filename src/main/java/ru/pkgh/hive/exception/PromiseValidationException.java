package ru.pkgh.hive.exception;

/**
 * Custom exception to handle validation errors related to promises.
 */
public class PromiseValidationException extends RuntimeException {

    /**
     * Constructs a new PromiseValidationException with the specified detail message.
     *
     * @param message the detail message
     */
    public PromiseValidationException(String message) {
        super(message);
    }
}