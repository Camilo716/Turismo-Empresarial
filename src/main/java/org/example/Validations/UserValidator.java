package org.example.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public UserValidator() {
    }

    public Boolean validateNames(String names)throws Exception{
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(names);

        if (matcher.matches()) {
            return true;
        }
        else{
            throw new Exception("Name can´t contain numbers or symbols");
        }

    }
}
