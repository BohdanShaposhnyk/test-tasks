package com.shap.employees.model;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by Bohdan Shaposhnyk on 11.01.2017.
 */
public abstract class Employee implements Serializable, Comparator<Employee> {

    protected Integer id;
    protected String name;
    protected double pay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, double pay) {
        this.id = id;
        this.name = name;
        this.pay = pay;
    }

    public Employee() {}

    public int compare(Employee first, Employee second) {
        if (first.getSalary() < second.getSalary()) return 1;
        if (first.getSalary() > second.getSalary()) return -1;
        return  first.getName().toUpperCase().compareTo(second.getName().toUpperCase());
    }

    public abstract double getSalary();
}
