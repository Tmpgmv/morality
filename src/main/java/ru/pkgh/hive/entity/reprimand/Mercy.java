package ru.pkgh.hive.entity.reprimand;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import ru.pkgh.hive.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("""
        Прощение. За конкретный проступок стуеднт прощен.
        В характеристику упомянутый в обещании проступок не попадет.""")
@JmixEntity
@Table(name = "HIVE_MERCY", indexes = {
        @Index(name = "IDX_HIVE_MERCY_REPRIMAND", columnList = "REPRIMAND_ID"),
        @Index(name = "IDX_HIVE_MERCY_EMPLOYEE", columnList = "EMPLOYEE_ID")
})
@Entity(name = "hive_Mercy")
public class Mercy {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    @Comment("Ссылка на сотрудника, простившего студента.")
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    @CreatedDate
    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Ссылка на выговор студенту.")
    @JoinColumn(name = "REPRIMAND_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Reprimand reprimand;

    public Reprimand getReprimand() {
        return reprimand;
    }

    public void setReprimand(Reprimand reprimand) {
        this.reprimand = reprimand;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}