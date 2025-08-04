package ru.pkgh.hive.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum ReactionToMisdemeanor implements EnumClass<String> {

    ПРЕДУПРЕЖДЕНИЕ("warning"),
    ВЫГОВОР("reprimand");

    private final String id;

    ReactionToMisdemeanor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ReactionToMisdemeanor fromId(String id) {
        for (ReactionToMisdemeanor at : ReactionToMisdemeanor.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}