package ru.pkgh.hive.entity.statement_of_explanation;

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
        Признание обоснованности доводов, изложенных в объяснительной записке студента.
        Т.е. полное освобождение от наказания. Не будет даже предупреждения.""")
@JmixEntity
@Table(name = "HIVE_ACCEPTANCE_OF_STATMENT_OF_EXPLANATION", indexes = {
        @Index(name = "IDX_HIVE_ACCEPTANCE_OF_STATMENT_OF_EXPLANATION_EMPLOYEE", columnList = "EMPLOYEE_ID"),
        @Index(name = "IDX_HIVEACCEPTANCEOFSTATMENTOFEXPLANATIO_STATEMENTOFEXPLANATION", columnList = "STATEMENT_OF_EXPLANATION_ID")
})
@Entity(name = "hive_AcceptanceOfStatmentOfExplanation")
public class AcceptanceOfStatmentOfExplanation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @CreatedDate
    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Сотрудник, признавший пояснитульную записку студента обоснованной.")
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    @Comment("Объяснительная записка студента.")
    @JoinColumn(name = "STATEMENT_OF_EXPLANATION_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private StatementOfExplanation statementOfExplanation;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    public StatementOfExplanation getStatementOfExplanation() {
        return statementOfExplanation;
    }

    public void setStatementOfExplanation(StatementOfExplanation statementOfExplanation) {
        this.statementOfExplanation = statementOfExplanation;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}