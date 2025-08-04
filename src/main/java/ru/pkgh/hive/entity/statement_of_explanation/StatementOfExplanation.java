package ru.pkgh.hive.entity.statement_of_explanation;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import ru.pkgh.hive.entity.misdemeanor.Misdemeanor;
import ru.pkgh.hive.entity.general.Student;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("""
        Объяснительная записка.
        Студент приводит уважительную причину или сообщает о несправедливости обвинений.
        В иных случаях писать объяснительную записку смысла нет.
        
        Писать объяснительную записку, нет никакого смысла, если студент не 
        может привести в ней уважительных причин. Нет уважительных причин - значит, 
        студент может только раскаяться и дать обещание исправиться.""")
@JmixEntity
@Table(name = "HIVE_STATEMENT_OF_EXPLANATION", indexes = {
        @Index(name = "IDX_HIVE_STATEMENT_OF_EXPLANATION_STUDENT", columnList = "STUDENT_ID"),
        @Index(name = "IDX_HIVE_STATEMENT_OF_EXPLANATION_MISDEMEANOR", columnList = "MISDEMEANOR_ID")
})
@Entity(name = "hive_StatementOfExplanation")
public class StatementOfExplanation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("""
            Возможность прикрепить файл. Это может быть, например, изображение.
            Файл служит доказательством приводимых аргументов.
            Если факлов несколько, пользователи должны заархивировать файлы и
            приложить один файл с архивом.""")
    @Column(name = "FILE_", length = 1024)
    private FileRef file;

    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Ссылка на студента.")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Student student;

    @Comment("Ссылка на проступок.")
    @JoinColumn(name = "MISDEMEANOR_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Misdemeanor misdemeanor;

    @NotNull
    @Comment("Текст объяснительной записки студента.")
    @Column(name = "TEXT", nullable = false)
    @Lob
    private String text;

    public FileRef getFile() {
        return file;
    }

    public void setFile(FileRef file) {
        this.file = file;
    }

    public Misdemeanor getMisdemeanor() {
        return misdemeanor;
    }

    public void setMisdemeanor(Misdemeanor misdemeanor) {
        this.misdemeanor = misdemeanor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}