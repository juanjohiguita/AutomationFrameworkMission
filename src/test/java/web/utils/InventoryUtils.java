package web.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class InventoryUtils {

    public static String removeCurrencySymbol(String price) {
        return price.replace("$", "");
    }

    public static double convertToDouble(String numberString) {
        try {
            return Double.parseDouble(numberString);
        } catch (NumberFormatException e) {
            System.err.println("Error: El valor ingresado no es un número válido.");
            throw new NumberFormatException();
        }
    }
}
