import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Bohdan Shaposhnyk on 08.01.2017.
 */
public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = reader.nextInt();

        try {
            System.out.println(n + "! = " + FactorialFinder.factorial(n));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
