package com.ticketservice.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAdressValidator {

    public static boolean validateEmail(String emailAddress) {
        Pattern emailAdressPattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matcher = emailAdressPattern.matcher(emailAddress);
        boolean isValid = matcher.matches();

        if(isValid){
            return true;
        }

        return false;
    }


}
