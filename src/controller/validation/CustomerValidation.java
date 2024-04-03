package controller.validation;

import model.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidation {
    // Regex format
    String emailRegex = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
    String phoneRegex = "\\d{3}\\d{3}\\d{4}";

    // convert to Pattern objects
    Pattern emailPattern = Pattern.compile(emailRegex);
    Pattern phonePattern = Pattern.compile(phoneRegex);

    public boolean emailValidation(String email){
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }
    public boolean phoneValidation(String phone){
        Matcher phoneMatcher = phonePattern.matcher(phone);
        return phoneMatcher.matches();
    }
}
