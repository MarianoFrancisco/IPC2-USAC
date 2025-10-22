package com.mariano.jasper.reports.pojos.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.mariano.jasper.reports.pojos.domain.Employee;
import com.mariano.jasper.reports.pojos.domain.EmploymentStatus;

/**
 *
 * @author Mariano Camposeco {@literal (mariano1941@outlook.es)}
 */
public class InMemoryEmployeeRepository implements EmployeeRepository {

    @Override
    public List<Employee> findAll() {
        return List.of(
                new Employee(
                        UUID.randomUUID(), "Mariano", "Camposeco",
                        "Software Engineer", "IT",
                        "mariano@test.com", LocalDate.of(2025, 10, 1),
                        new BigDecimal("9500.00"), EmploymentStatus.ACTIVE
                ),
                new Employee(
                        UUID.randomUUID(), "Anabelly", "Hernández",
                        "QA Analyst", "IT",
                        "anabelly@test.com", LocalDate.of(2025, 10, 2),
                        new BigDecimal("7200.50"), EmploymentStatus.ON_LEAVE
                ),
                new Employee(
                        UUID.randomUUID(), "Francisco", "Camposeco",
                        "HR Specialist", "HR",
                        "francisco@test.com", LocalDate.of(2025, 10, 3),
                        new BigDecimal("6800.00"), EmploymentStatus.RETIRED
                )
        );
    }
}
