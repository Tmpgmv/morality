package ru.pkgh.hive.entity.promise;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import ru.pkgh.hive.entity.User;

import java.util.Date;
import java.util.UUID;

@Comment("Поверили обещанию.")
@JmixEntity
@Table(name = "HIVE_ACCEPTANCE_OF_PROMISE", indexes = {
        @Index(name = "IDX_HIVE_ACCEPTANCE_OF_PROMISE_EMPLOYEE", columnList = "EMPLOYEE_ID"),
        @Index(name = "IDX_HIVE_ACCEPTANCE_OF_PROMISE_PROMISE", columnList = "PROMISE_ID")
})
@Entity(name = "hive_AcceptanceOfPromise")
public class AcceptanceOfPromise {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private Date createdAt;

    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    @Comment("Обещание студента.")
    @JoinColumn(name = "PROMISE_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Promise promise;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Promise getPromise() {
        return promise;
    }

    public void setPromise(Promise promise) {
        this.promise = promise;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}