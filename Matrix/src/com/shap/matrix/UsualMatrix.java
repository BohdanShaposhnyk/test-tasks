package com.shap.matrix;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class UsualMatrix implements IMatrix {

    private int rankDim1;
    private int rankDim2;
    private int[][] matrix;

    public int getRankDim1() {
        return rankDim1;
    }

    public int getRankDim2() {
        return rankDim2;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public UsualMatrix(int rankDim1, int rankDim2) {
        this.rankDim1 = rankDim1;
        this.rankDim2 = rankDim2;
        matrix = new int[this.rankDim1][this.rankDim2];
    }

    public UsualMatrix(int[][] matrix, int rankDim1, int rankDim2) {
        this(rankDim1,rankDim2);
        for (int i = 0; i < rankDim1; i++) {
            for (int j = 0; j < rankDim2; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public UsualMatrix(File file) throws IOException{
        Scanner input = new Scanner(file);
        this.rankDim1 = input.nextInt();
        this.rankDim2 = input.nextInt();
        this.matrix = new int[rankDim1][rankDim2];

        for (int i = 0; i < rankDim1; i++) {
            for (int j = 0; j < rankDim2; j++) {
                if (input.hasNextInt()) {
                    matrix[i][j] = input.nextInt();
                }
            }
        }

    }


    public UsualMatrix sum(UsualMatrix other) throws IllegalArgumentException {
        if (rankDim1 != other.getRankDim1() || rankDim2 != other.getRankDim2())
            throw new IllegalArgumentException("Can't sum matrices with different ranks.");
        int[][] result = new int[rankDim1][rankDim2];
        for (int i = 0; i < rankDim1; i++) {
            for (int j = 0; j < rankDim2; j++) {
                result[i][j] = this.matrix[i][j] + other.getMatrix()[i][j];
            }
        }
        return new UsualMatrix(result, rankDim1, rankDim2);
    }

    @Override
    public void write(File file) {
        try{
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.print(rankDim1);
            writer.println(rankDim2);
            for (int i = 0; i < rankDim1; i++) {
                for (int j = 0; j < rankDim2; j++) {
                    writer.print(matrix[i][j] + " ");
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void print() {
        for (int i = 0; i < rankDim1; i++) {
            System.out.println();
            for (int j = 0; j < rankDim2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
