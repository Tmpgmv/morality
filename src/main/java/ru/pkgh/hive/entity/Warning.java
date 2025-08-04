package ru.pkgh.hive.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("Предупреждение студенту. Не попадет в характеристику.")
@JmixEntity
@Table(name = "HIVE_WARNING", indexes = {
        @Index(name = "IDX_HIVE_WARNING_TYPE_OF_MISDEMEANOR", columnList = "TYPE_OF_MISDEMEANOR_ID"),
        @Index(name = "IDX_HIVE_WARNING_MISDEMEANOR", columnList = "MISDEMEANOR_ID"),
        @Index(name = "IDX_HIVE_WARNING_EMPLOYEE", columnList = "EMPLOYEE_ID")
})
@Entity(name = "hive_Warning")
public class Warning {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("""
            Тип проступка. Приведен для удобства сортировок.
            Т.е. дублирование, т.к. информация о типе проступка содержится
            в проступке (поле misdemeanor).""")
    @JoinColumn(name = "TYPE_OF_MISDEMEANOR_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private TypeOfMisdemeanor typeOfMisdemeanor;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Ссылка на проступок.")
    @JoinColumn(name = "MISDEMEANOR_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Misdemeanor misdemeanor;

    @Comment("Сотрудник, выносящий предупреждение.")
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

    public Misdemeanor getMisdemeanor() {
        return misdemeanor;
    }

    public void setMisdemeanor(Misdemeanor misdemeanor) {
        this.misdemeanor = misdemeanor;
    }

    public TypeOfMisdemeanor getTypeOfMisdemeanor() {
        return typeOfMisdemeanor;
    }

    public void setTypeOfMisdemeanor(TypeOfMisdemeanor typeOfMisdemeanor) {
        this.typeOfMisdemeanor = typeOfMisdemeanor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}