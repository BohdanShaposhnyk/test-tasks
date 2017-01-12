package com.shap.employees.model;

import java.io.Serializable;

/**
 * Created by Bohdan Shaposhnyk on 11.01.2017.
 */
public class EmployeeFixedRate extends Employee implements Serializable {

    public EmployeeFixedRate(int id) {
        super(id);
    }

    public EmployeeFixedRate(int id, String name, double pay) {
        super(id, name, pay);
    }

    @Override
    public double getSalary() {
        return this.pay;
    }
}
