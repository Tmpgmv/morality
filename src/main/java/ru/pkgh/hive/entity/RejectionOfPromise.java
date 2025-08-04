package ru.pkgh.hive.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("Непринятие обещания. Т.е. студент понесет наказание за проступок.")
@JmixEntity
@Table(name = "HIVE_REJECTION_OF_PROMISE", indexes = {
        @Index(name = "IDX_HIVE_REJECTION_OF_PROMISE_PROMISE", columnList = "PROMISE_ID"),
        @Index(name = "IDX_HIVE_REJECTION_OF_PROMISE_EMPLOYEE", columnList = "EMPLOYEE_ID")
})
@Entity(name = "hive_RejectionOfPromise")
public class RejectionOfPromise {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    @Comment("Сообщение студенту. Нельзя отклонить обещание, ничего не сообщив студенту.")
    @Column(name = "MESSAGE", nullable = false)
    @NotNull
    private String message;

    @Comment("Ссылка на обещание.")
    @JoinColumn(name = "PROMISE_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Promise promise;

    @Comment("Ссылка на сотрудника.")
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Promise getPromise() {
        return promise;
    }

    public void setPromise(Promise promise) {
        this.promise = promise;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}