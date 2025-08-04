package ru.pkgh.hive.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("Возможность пользователю пометить проступок флагом.")
@JmixEntity
@Table(name = "HIVE_FLAGGED_MISDEMEANOR", indexes = {
        @Index(name = "IDX_HIVE_FLAGGED_MISDEMEANOR_EMPLOYEE", columnList = "EMPLOYEE_ID"),
        @Index(name = "IDX_HIVE_FLAGGED_MISDEMEANOR_MISDEMEANOR", columnList = "MISDEMEANOR_ID")
})
@Entity(name = "hive_FlaggedMisdemeanor")
public class FlaggedMisdemeanor {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @CreatedDate
    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Пользователь, пометивший для себя проступок студента флагом.")
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    @Comment("Проступок студента. Теоретически, несколько сотрудников могут пометить флагом проступок. Поэтому many-to-one.")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MISDEMEANOR_ID", nullable = false)
    @NotNull
    private Misdemeanor misdemeanor;

    public Misdemeanor getMisdemeanor() {
        return misdemeanor;
    }

    public void setMisdemeanor(Misdemeanor misdemeanor) {
        this.misdemeanor = misdemeanor;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}