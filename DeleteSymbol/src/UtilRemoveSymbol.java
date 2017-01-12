/**
 * Created by Bohdan Shaposhnyk on 11.01.2017.
 */
public class UtilRemoveSymbol {

    public static String removeSymbol(String inputString, char symbolToRemove) {

        String result =  "";
        for (char current : inputString.toCharArray() ) {
            if (current != symbolToRemove) {
                result += current;
            }
        }
        return result;

    }

    public static String removeSymbolTrivial(String inputString, char symbolToRemove) {

        return inputString.replaceAll( "" + symbolToRemove, "");

    }
}
