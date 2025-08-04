package ru.pkgh.hive.entity.general;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import ru.pkgh.hive.entity.student.StudyGroup;
import ru.pkgh.hive.entity.User;

import java.util.UUID;

@Comment("Студент.")
@JmixEntity
@Table(name = "HIVE_STUDENT", indexes = {
        @Index(name = "IDX_HIVE_STUDENT_USER", columnList = "USER_ID"),
        @Index(name = "IDX_HIVE_STUDENT_STUDY_GROUP", columnList = "STUDY_GROUP_ID")
})
@Entity(name = "hive_Student")
public class Student {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Пользователь.")
    @JoinColumn(name = "USER_ID", nullable = false)
    @Composition
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Comment("Номер студенческого билета.")
    @NotNull
    @Column(name = "IDENTITY_CARD", nullable = false)
    private String identityCard;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDY_GROUP_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private StudyGroup studyGroup;

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}