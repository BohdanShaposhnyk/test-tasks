package com.shap.employees;

import com.shap.employees.model.Crew;


/**
 * Created by Bohdan Shaposhnyk on 11.01.2017.
 */
public class Main {

    public static void main(String[] args) {

        Crew crew = new Crew();
        crew.print();
        crew.saveToFile();
        crew.sortBySalary();
        System.out.println("Sorted: ");
        crew.print();

    }
}
