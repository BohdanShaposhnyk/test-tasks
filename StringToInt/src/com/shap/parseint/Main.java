package com.shap.parseint;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Bohdan Shaposhnyk on 12.01.2017.
 */
public class Main {

    public static int strToInt( String string ) throws IOException {

        int result = 0;

        for (int i = 0; i < string.length(); i++) {
            int currentNumber = string.charAt(string.length()-1-i)-'0';
            if (currentNumber < 0 || currentNumber > 9) throw new IOException("Input should be numeric!");
            result += Math.pow(10, i) * currentNumber;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a numeric string: ");
        String inputString = reader.nextLine();
        try {
            System.out.println("Your number: " + strToInt(inputString));
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
