package org.example.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public Boolean validateNames(String names)throws Exception{
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(names);

        boolean notMatchesWithPattern = !matcher.matches();
        boolean tooShortName = names.length()<10;

        if (notMatchesWithPattern) {
            throw new Exception("Name can´t contain numbers or symbols");
        }else if (tooShortName){
            throw new Exception("Name is too short");
        }

        return true;

    }
}
