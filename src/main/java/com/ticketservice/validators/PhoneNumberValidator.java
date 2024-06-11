package com.ticketservice.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern phoneNumberPattern = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$");
        Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
        boolean isValid = matcher.matches();

        if(isValid){
            return true;
        }

        return false;
    }
}
