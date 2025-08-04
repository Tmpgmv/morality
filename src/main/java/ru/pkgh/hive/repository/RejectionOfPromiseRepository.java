package ru.pkgh.hive.repository;

import io.jmix.core.repository.JmixDataRepository;
import org.springframework.stereotype.Repository;
import ru.pkgh.hive.entity.promise.Promise;
import ru.pkgh.hive.entity.promise.RejectionOfPromise;

import java.util.UUID;

@Repository
public interface RejectionOfPromiseRepository extends JmixDataRepository<RejectionOfPromise, UUID> {
    boolean existsByPromise(Promise promise);
}
