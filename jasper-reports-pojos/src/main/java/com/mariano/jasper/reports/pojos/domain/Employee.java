package com.mariano.jasper.reports.pojos.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 *
 * @author Mariano Camposeco {@literal (mariano1941@outlook.es)}
 */
public class Employee {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String position;
    private final String department;
    private final String email;
    private final LocalDate hireDate;
    private final BigDecimal salary;
    private final EmploymentStatus status;

    public Employee(UUID id,
            String firstName,
            String lastName,
            String position,
            String department,
            String email,
            LocalDate hireDate,
            BigDecimal salary,
            EmploymentStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status.getLabel();
    }

    public String getFullName() {
        return (firstName + " " + lastName).trim();
    }

    public Date getHireDate() {
        return (hireDate == null) ? null : Date.valueOf(hireDate);
    }

    public String getHireDateFormatted() {
        if (hireDate == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return hireDate.format(formatter);
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
