package ru.pkgh.hive.entity.general;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Comment("""
        Коллекция типовых обещаний. В этой коллекции желательно иметь
        пословицы и поговорки. Например, "Мое слово тверже гороха".
        Пользователи увидят такие тексты. И это позволит все-таки немножко разрядить
        обстановку.""")
@JmixEntity
@Table(name = "HIVE_OATH")
@Entity(name = "hive_Oath")
public class Oath {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("Типовой текст обещания студента.")
    @Column(name = "TEXT", nullable = false, length = 1000)
    @NotNull
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}