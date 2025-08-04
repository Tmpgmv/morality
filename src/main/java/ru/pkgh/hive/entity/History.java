package ru.pkgh.hive.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("""
        Собрать всю историю, касательно конкретного проступка.
        Это позволит вывести ее для пользователя.""")
@JmixEntity
@Table(name = "HIVE_HISTORY", indexes = {
        @Index(name = "IDX_HIVE_HISTORY_MISDEMEANOR", columnList = "MISDEMEANOR_ID")
})
@Entity(name = "hive_History")
public class History {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Ссылка на проступок.")
    @JoinColumn(name = "MISDEMEANOR_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Misdemeanor misdemeanor;

    @Comment("Время.")
    @Column(name = "TIMESTAMP_", nullable = false)
    @NotNull
    private LocalDateTime timestamp;

    @Comment("Что именно предпринято.")
    @Column(name = "STEP", nullable = false)
    @NotNull
    private String step;

    @Comment("Гиперссылка для получения детальной информации.")
    @Column(name = "LINK", length = 1000)
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Step getStep() {
        return step == null ? null : Step.fromId(step);
    }

    public void setStep(Step step) {
        this.step = step == null ? null : step.getId();
    }

    public Misdemeanor getMisdemeanor() {
        return misdemeanor;
    }

    public void setMisdemeanor(Misdemeanor misdemeanor) {
        this.misdemeanor = misdemeanor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}