package com.shap.employees.util;

import com.shap.employees.model.Employee;
import com.shap.employees.model.EmployeeFixedRate;
import com.shap.employees.model.EmployeeHourlyWage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class CrewMock {
    public static List<Employee> init() {

        List<Employee> employees = new ArrayList<>();
        employees.add(new EmployeeFixedRate(1, "adam", 1000.0));
        employees.add(new EmployeeHourlyWage(2, "tom", 4.5));
        employees.add(new EmployeeFixedRate(3, "john", 600.0));
        employees.add(new EmployeeHourlyWage(4, "david", 4.0));
        employees.add(new EmployeeFixedRate(5, "jacob", 800.0));
        employees.add(new EmployeeHourlyWage(6, "james", 4.0));
        employees.add(new EmployeeFixedRate(7, "william", 1000.0));
        return employees;

    }
}
