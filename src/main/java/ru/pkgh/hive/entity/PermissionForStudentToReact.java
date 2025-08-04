package ru.pkgh.hive.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("""
        Разрешение отреагировать на фиксацию проступка.
        Применяется, если студент упустил время, данное на то, чтобы отреагировать
        на обвинение.
        Иначе говоря, время уже прошло, но студенту разрешаем добавить
        обещание или объяснительную записку.
        
        Чтобы получить разрешение, студент должен обратиться на отделение лично (не
        через интерфейс "Цифровой морали". Сделать форму обращения технически 
        несложно, но воспитательное воздействие будет лучше, если студент придет 
        на отделение или хотя бы позвонит.""")
@JmixEntity
@Table(name = "HIVE_PERMIT_TO_PROMISE", indexes = {
        @Index(name = "IDX_HIVE_PERMIT_TO_PROMISE_PROMISE", columnList = "PROMISE_ID"),
        @Index(name = "IDX_HIVE_PERMIT_TO_PROMISE_EMPLOYEE", columnList = "EMPLOYEE_ID")
})
@Entity(name = "hive_PermitToPromise")
public class PermissionForStudentToReact {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Ссылка на проступок.")
    @NotNull
    @JoinColumn(name = "PROMISE_ID", nullable = false)
    @Composition
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Misdemeanor misdemeanor;

    @CreatedDate
    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Сотрудник, давший разрешение.")
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    public void setMisdemeanor(Misdemeanor misdemeanor) {
        this.misdemeanor = misdemeanor;
    }

    public Misdemeanor getMisdemeanor() {
        return misdemeanor;
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