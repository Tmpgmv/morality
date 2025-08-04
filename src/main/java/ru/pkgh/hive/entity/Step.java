package ru.pkgh.hive.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Step implements EnumClass<String> {

    ACCEPTANCE_OF_PROMISE("AcceptanceOfPromise"),
    ACCEPTANCE_OF_STATMENT_OF_EXPLANATION("AcceptanceOfStatmentOfExplanation"),
    MERCY("Mercy"),
    MISDEMEANOR("Misdemeanor"),
    PERMISSION_FOR_STUDENT_TO_REACT("PermissionForStudentToReact"),
    PROMISE("Promise"),
    REJECTION_OF_PROMISE("RejectionOfPromise"),
    REJECTION_OF_STATEMENT_OF_EXPLANATION("RejectionOfStatementOfExplanation"),
    REPRIMAND("Reprimand"),
    STATEMENT_OF_EXPLANATION("StatementOfExplanation"),
    WARNING("Warning");

    private final String id;

    Step(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Step fromId(String id) {
        for (Step at : Step.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}