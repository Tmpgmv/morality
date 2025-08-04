package ru.pkgh.hive.event_listener;

import io.jmix.core.Messages;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.pkgh.hive.entity.promise.AcceptanceOfPromise;
import ru.pkgh.hive.entity.promise.RejectionOfPromise;
import ru.pkgh.hive.exception.PromiseValidationException;
import ru.pkgh.hive.validator.PromiseValidator;

import java.util.concurrent.CompletionException;


@Component
public class AcceptanceOfPromiseEntityListener {

    @Autowired
    private PromiseValidator promiseValidator;

    @Autowired
    private Messages messages;

    @Autowired
    private Notifications notifications;

    @EventListener
    public void onAcceptanceOfPromiseSaving(EntitySavingEvent<AcceptanceOfPromise> event) {
        AcceptanceOfPromise acceptance = event.getEntity();

        if (promiseValidator.isPromiseAcceptedOrRejected(acceptance.getPromise())) {
            String message = messages.getMessage("validation.promise.alreadyProcessed");
//            notifications.create(message)
//                    .withType(Notifications.Type.ERROR)
//                    .show();
            throw new PromiseValidationException(message);
        }
    }
}
