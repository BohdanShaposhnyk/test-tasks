import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Bohdan Shaposhnyk on 10.01.2017.
 */
public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String inputString = reader.nextLine();
        System.out.println("Enter a symbol to remove: ");
        char symbolToRemove = 0;
        try {
            symbolToRemove = reader.next(".").charAt(0);
        } catch (InputMismatchException ime) {
            System.out.println("Should enter a single character! First one used");
            symbolToRemove = reader.next().charAt(0);
        }

        System.out.println("Result string: " + UtilRemoveSymbol.removeSymbol(inputString, symbolToRemove));
        System.out.println("Result string: " + UtilRemoveSymbol.removeSymbolTrivial(inputString, symbolToRemove));

    }
}
