package ru.pkgh.hive.repository;

import io.jmix.core.repository.JmixDataRepository;
import org.springframework.stereotype.Repository;
import ru.pkgh.hive.entity.promise.AcceptanceOfPromise;
import ru.pkgh.hive.entity.promise.Promise;
import java.util.UUID;

@Repository
public interface AcceptanceOfPromiseRepository extends JmixDataRepository<AcceptanceOfPromise, UUID> {
    boolean existsByPromise(Promise promise);
}
