package com.mariano.jasper.reports.pojos.domain;

/**
 *
 * @author Mariano Camposeco {@literal (mariano1941@outlook.es)}
 */
public enum EmploymentStatus {
    ACTIVE("Active"),
    ON_LEAVE("On Leave"),
    TERMINATED("Terminated"),
    RETIRED("Retired");

    private final String label;

    EmploymentStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
