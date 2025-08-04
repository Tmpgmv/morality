package ru.pkgh.hive.entity.misdemeanor;

import io.jmix.core.DeletePolicy;
import io.jmix.core.FileRef;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import ru.pkgh.hive.entity.User;
import ru.pkgh.hive.entity.general.Student;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("Проступок студента.")
@JmixEntity
@Table(name = "HIVE_MISDEMEANOR", indexes = {
        @Index(name = "IDX_HIVE_MISDEMEANOR_TYPE", columnList = "TYPE_ID"),
        @Index(name = "IDX_HIVE_MISDEMEANOR_STUDENT", columnList = "STUDENT_ID")
})
@Entity(name = "hive_Misdemeanor")
public class Misdemeanor {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("""
            Колледж отреагировал. Флаг взводится, только если последовала реакция колледжа. 
            Если выполнены действия, флаг не взводится.
            
            
            Эта информация может быть извлечена из базы данных в таблицах 
            Warning или Reprimand. Т.е. эта информация излешняя, но
            она несет удобство пользователю.""")
    @Column(name = "COLLEGE_REACTED")
    private Boolean collegeReacted;

    @Comment("""
            Студент отреагировал. Флаг взводится, только если последовала реакция колледжа. 
            Если выполнены действия, флаг не взводится.
            
            Эта информация может быть извлечена из базы данных в таблицах 
            Promise или StatementOfExplanation. Т.е. эта информация излешняя, но
            она несет удобство пользователю.""")
    @Column(name = "STUDENT_REACTED")
    private Boolean studentReacted;

    @Comment("""
            Возможность прикрепить файл. Это может быть, например, изображение.
            Файл служит доказательством проступка.
            Если факлов несколько, пользователи должны заархивировать файлы и
            приложить один файл с архивом.""")
    @Column(name = "FILE_", length = 1024)
    private FileRef file;

    @Comment("Ссылка на тип проступка, т.е. что это (прогул, опоздание и т.п.).")
    @JoinColumn(name = "TYPE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private TypeOfMisdemeanor type;

    @Comment("""
            В чем заключается проступок.
            Допустим, пропуск такого-то занятия такого-то числа.""")
    @Lob
    @Column(name = "CASE_SUMMARY", nullable = false)
    @NotNull
    private String caseSummary;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Comment("Сотрудник, который рапортует о проступке.")
    @JoinColumn(name = "REFERRER_ID", nullable = false)
    private User referrer;

    @CreatedDate
    @Comment("Время создания записи.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("Студент, совершивший проступок.")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Student student;

    @Comment("Комментарий.")
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    public Boolean getStudentReacted() {
        return studentReacted;
    }

    public void setStudentReacted(Boolean studentReacted) {
        this.studentReacted = studentReacted;
    }

    public Boolean getCollegeReacted() {
        return collegeReacted;
    }

    public void setCollegeReacted(Boolean collegeReacted) {
        this.collegeReacted = collegeReacted;
    }

    public FileRef getFile() {
        return file;
    }

    public void setFile(FileRef file) {
        this.file = file;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public void setReferrer(User referrer) {
        this.referrer = referrer;
    }

    public User getReferrer() {
        return referrer;
    }

    public String getCaseSummary() {
        return caseSummary;
    }

    public void setCaseSummary(String caseSummary) {
        this.caseSummary = caseSummary;
    }

    public TypeOfMisdemeanor getType() {
        return type;
    }

    public void setType(TypeOfMisdemeanor type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}