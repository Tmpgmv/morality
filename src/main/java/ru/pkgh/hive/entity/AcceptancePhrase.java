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

@Comment("""
        Коллекция фраз для принятия обещания или объяснительной записки.
        Фраз не должно быть много. 5-6 достаточно. 
        Например, "Мы принимаем Ваше обещание, но выносим предупреждение.".""")
@JmixEntity
@Table(name = "HIVE_ACCEPTANCE_PHRASE")
@Entity(name = "hive_AcceptancePhrase")
public class AcceptancePhrase {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

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