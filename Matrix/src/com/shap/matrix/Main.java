package com.shap.matrix;

import java.io.File;
import java.io.IOException;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class Main {

    final static String FILE1 = System.getProperty("user.dir") + "\\matrix1.txt";
    final static String FILE2 = System.getProperty("user.dir") + "\\matrix2.txt";
    final static String FILE3 = System.getProperty("user.dir") + "\\sum.txt";


    public static void main(String[] args) {

        File matrix1File = new File(FILE1);
        File matrix2File = new File(FILE2);
        File sumFile = new File(FILE3);

        if (!matrix1File.exists() || !matrix2File.exists()) return;

        UsualMatrix first = null;
        UsualMatrix second = null;
        try {
            first = new UsualMatrix(matrix1File);
            second = new UsualMatrix(matrix2File);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        IMatrix result = first.sum(second);
        System.out.println("First matrix: ");
        first.print();
        System.out.println("Second matrix: ");
        second.print();
        System.out.println("Result matrix: ");
        result.print();
        result.write(sumFile);
    }
}
