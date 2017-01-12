package com.shap.race;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class Judge {

    private final static int NUMBER_OF_COCKROACHES = 10;
    private final static int NUMBER_OF_LOOPS = 3;
    private static Set<Cockroach> cockroaches = new HashSet<>();

    private static void init() {
        for (int i = 0; i < NUMBER_OF_COCKROACHES; i++) {
            cockroaches.add(new Cockroach(i+1));
        }
    }

    private static void race() {
        init();
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_COCKROACHES);
        try {
            for (int i = 0; i < NUMBER_OF_LOOPS; i++) {
                System.out.println("Loop number " + (i+1));
                List<Future<Cockroach>> invokeAll = pool.invokeAll(cockroaches);
            }
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            pool.shutdown();
        }
    }

    public static void main(String[] args) {
        race();
    }

}
