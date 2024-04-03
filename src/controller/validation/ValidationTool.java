package controller.validation;

import model.Order;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidationTool {
    // Regex format
    String emailRegex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
    String phoneRegex = "\\d{3}\\d{3}\\d{4}";

    // convert to Pattern objects
    Pattern emailPattern = Pattern.compile(emailRegex);
    Pattern phonePattern = Pattern.compile(phoneRegex);

     static boolean emailValidation(String email){
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }
     static boolean phoneValidation(String phone){
        Matcher phoneMatcher = phonePattern.matcher(phone);
        return phoneMatcher.matches();
    }
    static boolean idValidation(int id){
         boolean idValid = false;
        while (true) {
            try {
                if (id > 0) {
                    idValid = true;
                    break;
                } else {
                    System.out.println("ID must be a positive number. Please re-enter: ");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. ID must be a number. Please re-enter: ");
            }
        }
        return idValid;
    }
    static boolean priceValidation(double price){
        boolean priceValid = false;
        while (true) {
            try {
                if (price > 0) {
                    priceValid = true;
                    break;
                } else {
                    System.out.println("Price must be a positive number. Please re-enter: ");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Price must be a number. Please re-enter: ");
            }
        }
        return priceValid;
    }
    static boolean quantityValidation(int quantity){
        boolean quantityValid = false;
        while (true) {
            try {
                if (quantity > 0) {
                    quantityValid = true;
                    break;
                } else {
                    System.out.println("Quantity must be a positive number. Please re-enter: ");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Quantity must be a number. Please re-enter: ");
            }
        }
        return quantityValid;
    }
}
