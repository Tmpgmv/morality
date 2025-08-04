package ru.pkgh.hive.entity.misdemeanor;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Comment;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import ru.pkgh.hive.enumeration.ReactionToMisdemeanor;

import java.util.UUID;

@Comment("Тип проступка.")
@JmixEntity
@Table(name = "HIVE_TYPE_OF_MISDEMEANOR")
@Entity(name = "hive_TypeOfMisdemeanor")
public class TypeOfMisdemeanor {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Comment("""
            Наименование типа проступка.
            Это может быть прогул, опоздание, нарушение дисциплины.""")
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Comment("""
            Реакция на проступок (по умолчанию).
            При исчерпанаии доверия (задается в Settings в поле 
            numberOfWarningsBeforeReprimand) 
            будет уже не реакция по умолчанию, а выговор.""")
    @Column(name = "REACTION", nullable = false)
    @NotNull
    private String defaultReactionToMisdemeanor;

    @Comment("Комментарий.")
    @Lob
    @Column(name = "COMMENT_")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ReactionToMisdemeanor getDefaultReactionToMisdemeanor() {
        return defaultReactionToMisdemeanor == null ? null : ReactionToMisdemeanor.fromId(defaultReactionToMisdemeanor);
    }

    public void setDefaultReactionToMisdemeanor(ReactionToMisdemeanor defaultReactionToMisdemeanor) {
        this.defaultReactionToMisdemeanor = defaultReactionToMisdemeanor == null ? null : defaultReactionToMisdemeanor.getId();
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