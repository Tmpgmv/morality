package ru.pkgh.hive.validator;

import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.core.event.EntitySavingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.pkgh.hive.entity.promise.AcceptanceOfPromise;
import ru.pkgh.hive.entity.promise.Promise;
import ru.pkgh.hive.entity.promise.RejectionOfPromise;
import ru.pkgh.hive.repository.AcceptanceOfPromiseRepository;
import ru.pkgh.hive.repository.RejectionOfPromiseRepository;

@Component
public class PromiseValidator {

    @Autowired
    private AcceptanceOfPromiseRepository acceptanceRepository;

    @Autowired
    private RejectionOfPromiseRepository rejectionRepository;

    public boolean isPromiseAcceptedOrRejected(Promise promise) {
        boolean isAccepted = acceptanceRepository.existsByPromise(promise);
        boolean isRejected = rejectionRepository.existsByPromise(promise);

        return isAccepted || isRejected;
    }
}