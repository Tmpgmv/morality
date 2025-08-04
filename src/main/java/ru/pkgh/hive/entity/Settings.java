package ru.pkgh.hive.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Comment("Настройки программы.")
@JmixEntity
@Table(name = "HIVE_SETTINGS")
@Entity(name = "hive_Settings")
public class Settings {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Сколько предупреждений до выговора. Шт.")
    @Column(name = "NUMBER_OF_WARNINGS_BEFORE_REPRIMAND", nullable = false)
    @NotNull
    private Integer numberOfWarningsBeforeReprimand;

    @NotNull
    @Comment("""
            Время, в течение которого студент может
            отреагировать на факт фиксации его проступка.
            В часах.""")
    @Column(name = "TIME_FOR_STUDENT_TO_REACT", nullable = false)
    private Integer timeForStudentToReact;

    public Integer getNumberOfWarningsBeforeReprimand() {
        return numberOfWarningsBeforeReprimand;
    }

    public void setNumberOfWarningsBeforeReprimand(Integer numberOfWarningsBeforeReprimand) {
        this.numberOfWarningsBeforeReprimand = numberOfWarningsBeforeReprimand;
    }

    public void setTimeForStudentToReact(Integer timeForStudentToReact) {
        this.timeForStudentToReact = timeForStudentToReact;
    }

    public Integer getTimeForStudentToReact() {
        return timeForStudentToReact;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}