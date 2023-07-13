package org.example.Validators;

import org.example.Util.Regex;

public class UserValidator {
    public Boolean validateName(String names)throws Exception {
        String regex = "^[a-zA-ZñÑ ]+$";

        boolean notMatchesPattern = !Regex.matchesPattern(names, regex);
        boolean tooShortName = names.length()<10;

        if (notMatchesPattern) {
            throw new Exception("Name can´t contain numbers or symbols");
        }else if (tooShortName){
            throw new Exception("Name is too short");
        }

        return true;

    }

    public void validateLocation(int locationNumber)throws Exception {
        boolean isHigherThan4 = locationNumber > 4;

        if (isHigherThan4){
            throw new Exception("Location can't be higher than 4");
        }
    }
}
