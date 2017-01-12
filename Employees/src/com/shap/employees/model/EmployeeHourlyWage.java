package com.shap.employees.model;

import java.io.Serializable;

/**
 * Created by Bohdan Shaposhnyk on 11.01.2017.
 */
public class EmployeeHourlyWage extends Employee implements Serializable {

    public EmployeeHourlyWage(int id) {
        super(id);
    }

    public EmployeeHourlyWage(int id, String name, double pay) {
        super(id, name, pay);
    }

    @Override
    public double getSalary() {
        return 20.8*8*pay;
    }

}
