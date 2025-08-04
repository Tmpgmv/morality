package ru.pkgh.hive.entity.statement_of_explanation;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import ru.pkgh.hive.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("""
        Отклонение объяснительной записки. 
        Т.е. доводы признаны неубедительными. 
        И студент понесет наказание.""")
@JmixEntity
@Table(name = "HIVE_REJECTION_OF_STATEMENT_OF_EXPLANATION", indexes = {
        @Index(name = "IDX_HIVE_REJECTION_OF_STATEMENT_OF_EXPLANATION_EMPLOYEE", columnList = "EMPLOYEE_ID"),
        @Index(name = "IDX_HIVEREJECTIONOFSTATEMENTOFEXPLANATIO_STATEMENTOFEXPLANATION", columnList = "STATEMENT_OF_EXPLANATION_ID")
})
@Entity(name = "hive_RejectionOfStatementOfExplanation")
public class RejectionOfStatementOfExplanation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Времся создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    @Comment("Ссылка на сотрудника, признавшего пояснительную записку неубедительной.")
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    @NotNull
    @Comment("""
            Сообщение студенту.
            Нельзя отклонить пояснительную записку, ничего не сказав студенту.""")
    @Column(name = "MESSAGE", nullable = false)
    @Lob
    private String message;

    @Comment("Ссылка на объяснительную записку студента.")
    @JoinColumn(name = "STATEMENT_OF_EXPLANATION_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private StatementOfExplanation statementOfExplanation;

    public StatementOfExplanation getStatementOfExplanation() {
        return statementOfExplanation;
    }

    public void setStatementOfExplanation(StatementOfExplanation statementOfExplanation) {
        this.statementOfExplanation = statementOfExplanation;
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