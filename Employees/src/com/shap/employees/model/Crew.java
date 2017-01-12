package com.shap.employees.model;

import com.shap.employees.util.CrewMock;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bohdan Shaposhnyk on 11.01.2017.
 */
public class Crew implements Serializable {

    private List<Employee> employees = new ArrayList<>();
    String filename;

    public Crew() {

        filename = System.getProperty("user.dir") + "\\data.dat";
        init();

    }

    public Crew(List<Employee> employees) {

        filename = System.getProperty("user.dir") + "\\data.dat";
        this.employees = employees;

    }

    private void init() {

        File persistenceFile = new File(filename);
        if (persistenceFile.exists() && !persistenceFile.isDirectory()) {
            this.employees = loadFromFile();
        } else {
            this.employees = CrewMock.init();
        }


    }

    private List<Employee> loadFromFile() {

        List<Employee> list = null;
        try ( ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream(filename)) ) {
            list = (List<Employee>)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public void saveToFile() {

        try ( ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(filename)) ){
            oos.writeObject(this.employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortBySalary() {
        Collections.sort(employees, new Employee() {
            @Override
            public double getSalary() {
                return 0;
            }
        });
    }

    public void print() {
        for ( Employee current : employees ) {
            System.out.println("id: " + current.getId() + ", name: " + current.getName() +
            ", salary: " + current.getSalary());
        }
    }

}
