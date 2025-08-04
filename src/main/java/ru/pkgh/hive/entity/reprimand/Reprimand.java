package ru.pkgh.hive.entity.reprimand;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import ru.pkgh.hive.entity.User;
import ru.pkgh.hive.entity.misdemeanor.Misdemeanor;
import ru.pkgh.hive.entity.misdemeanor.TypeOfMisdemeanor;

import java.util.Date;
import java.util.UUID;

@Comment("Объявленный студенту выговор. На основании выговоров составляется характеристика студента.")
@JmixEntity
@Table(name = "HIVE_REPRIMAND", indexes = {
        @Index(name = "IDX_HIVE_REPRIMAND_MISDEMEANOR", columnList = "MISDEMEANOR_ID"),
        @Index(name = "IDX_HIVE_REPRIMAND_EMPLOYEE", columnList = "EMPLOYEE_ID"),
        @Index(name = "IDX_HIVE_REPRIMAND_TYPE_OF_MISDEMEANOR", columnList = "TYPE_OF_MISDEMEANOR_ID")
})
@Entity(name = "hive_Reprimand")
public class Reprimand {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("""
            Прощен. Дублировние информации о прощении: если есть запись о прощении (Mercy), 
            то она содержит информацию о том, какой именно выговор отменен. Но здесь флаг - 
            только для сортировки и фильтрации.""")
    @Column(name = "GRANTED_MERCY")
    private Boolean grantedMercy;

    @Comment("""
            Тип проступка. Приведен для удобства сортировок.
            Т.е. дублирование, т.к. информация о типе проступка содержится
            в проступке (поле misdemeanor).""")
    @JoinColumn(name = "TYPE_OF_MISDEMEANOR_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private TypeOfMisdemeanor typeOfMisdemeanor;

    @Comment("Ссылка на проступок.")
    @JoinColumn(name = "MISDEMEANOR_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Misdemeanor misdemeanor;

    @Comment("Сотрудник, объявивший выговор.")
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User employee;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    @Comment("Время создания.")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private Date createdAt;

    public Boolean getGrantedMercy() {
        return grantedMercy;
    }

    public void setGrantedMercy(Boolean grantedMercy) {
        this.grantedMercy = grantedMercy;
    }

    public TypeOfMisdemeanor getTypeOfMisdemeanor() {
        return typeOfMisdemeanor;
    }

    public void setTypeOfMisdemeanor(TypeOfMisdemeanor typeOfMisdemeanor) {
        this.typeOfMisdemeanor = typeOfMisdemeanor;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}