package ru.pkgh.hive.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Comment("""
        Обещание не повторять прступок. 
        
        Один из вариантов ответа студента на обвинение 
        (см. комментарий к StatementOfExplanation). 
        
        Текст обещания не важен. Важен сам факт обещания.""")
@JmixEntity
@Table(name = "HIVE_PROMISE", indexes = {
        @Index(name = "IDX_HIVE_PROMISE_STUDENT", columnList = "STUDENT_ID"),
        @Index(name = "IDX_HIVE_PROMISE_MISDEMEANOR", columnList = "MISDEMEANOR_ID")
})
@Entity(name = "hive_Promise")
public class Promise {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @CreatedDate
    @Comment("Время создания.")
    @Column(name = "CREATED_AT", nullable = false)
    @NotNull
    private LocalDateTime createdAt;

    @Comment("""
            Текст обещания. Сам текст неважен: он не пойдет в характеристику и т.п. 
            Наличие текста - важно: мы все-таки хотим выслушать студента. 
            И важен сам факт обещания.""")
    @Column(name = "TEXT", nullable = false)
    @Lob
    @NotNull
    private String text;

    @Comment("Ссылка на проступок.")
    @JoinColumn(name = "MISDEMEANOR_ID", nullable = false)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Misdemeanor misdemeanor;

    @Comment("Ссылка на студента.")
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Student student;

    public Misdemeanor getMisdemeanor() {
        return misdemeanor;
    }

    public void setMisdemeanor(Misdemeanor misdemeanor) {
        this.misdemeanor = misdemeanor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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