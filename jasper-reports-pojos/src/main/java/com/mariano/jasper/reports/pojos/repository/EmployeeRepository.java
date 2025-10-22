package com.mariano.jasper.reports.pojos.repository;

import java.util.List;

import com.mariano.jasper.reports.pojos.domain.Employee;

/**
 *
 * @author Mariano Camposeco {@literal (mariano1941@outlook.es)}
 */
public interface EmployeeRepository {

    List<Employee> findAll();
}
