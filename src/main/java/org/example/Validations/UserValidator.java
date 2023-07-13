package org.example.Validations;

import org.example.Util.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public Boolean validateNames(String names)throws Exception{
        boolean notMatchesPattern = !Regex.matchesPattern(names, "^[a-zA-Z]+$");
        boolean tooShortName = names.length()<10;

        if (notMatchesPattern) {
            throw new Exception("Name can´t contain numbers or symbols");
        }else if (tooShortName){
            throw new Exception("Name is too short");
        }

        return true;

    }
}
