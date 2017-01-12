import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by Bohdan Shaposhnyk on 08.01.2017.
 */
public class FactorialFinder {

    public static BigInteger factorial(int n) throws IOException{

        if (n < 0) throw new IOException("Wrong input (should not be negative)");
        if (n == 0) return BigInteger.ONE;
        BigInteger result = BigInteger.valueOf(n);
        return result.multiply(factorial(n-1));

    }
}
