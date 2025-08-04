package ru.pkgh.hive.entity.student;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import ru.pkgh.hive.entity.general.Department;
import ru.pkgh.hive.entity.general.Student;

import java.util.List;
import java.util.UUID;

@Comment("Учебная группа.")
@JmixEntity
@Table(name = "HIVE_STUDY_GROUP", indexes = {
        @Index(name = "IDX_HIVE_STUDY_GROUP_DEPARTMENT", columnList = "DEPARTMENT_ID")
})
@Entity(name = "hive_StudyGroup")
public class StudyGroup {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Студенты.")
    @Composition
    @OneToMany(mappedBy = "studyGroup")
    private List<Student> students;

    @Comment("Наименование группы. Например, ИР-23-3.")
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Comment("Отделение.")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Department department;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}