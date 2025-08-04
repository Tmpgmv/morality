package ru.pkgh.hive.exception;

import io.jmix.flowui.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private Notifications notifications;

    @ExceptionHandler(PromiseValidationException.class)
    public void handlePromiseValidationException(PromiseValidationException ex) {
        notifications.create(ex.getMessage())
                .withType(Notifications.Type.ERROR)
                .show();
    }
}
