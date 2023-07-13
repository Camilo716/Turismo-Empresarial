package org.example.Validators;

import org.example.Util.Regex;

public class UserValidator {
    public Boolean validateName(String names)throws Exception{
        String regex = "^[a-zA-Z]+$";

        boolean notMatchesPattern = !Regex.matchesPattern(names, regex);
        boolean tooShortName = names.length()<10;

        if (notMatchesPattern) {
            throw new Exception("Name can´t contain numbers or symbols");
        }else if (tooShortName){
            throw new Exception("Name is too short");
        }

        return true;

    }
}
