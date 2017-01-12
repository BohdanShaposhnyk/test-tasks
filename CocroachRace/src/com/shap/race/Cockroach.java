package com.shap.race;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class Cockroach implements Callable<Cockroach> {

    private int id;

    public Cockroach(int id) {
        this.id = id;
    }

    public Cockroach() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Cockroach call() throws Exception {
        Thread.sleep(500);
        System.out.println("Cockroach #" + id + " has finished");
        return null;
    }
}
