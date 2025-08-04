package ru.pkgh.hive.entity.general;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import ru.pkgh.hive.entity.student.StudyGroup;

import java.util.List;
import java.util.UUID;

@Comment("Отделение")
@JmixEntity
@Table(name = "HIVE_DEPARTMENT")
@Entity(name = "hive_Department")
public class Department {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Наименование отделения. Допустим, \"Отделение информационных технологий\".")
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Comment("Учебные группы.")
    @Composition
    @OneToMany(mappedBy = "department")
    private List<StudyGroup> groups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudyGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<StudyGroup> groups) {
        this.groups = groups;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}