package org.example.Validators;

import org.example.Util.Regex;

public class UserValidator {
    public Boolean validateName(String names) throws Exception {
        String regex = "^[a-zA-ZñÑ ]+$";
        boolean notMatchesPattern = !Regex.matchesPattern(names, regex);

        if (notMatchesPattern)
            throw new Exception("Name can´t contain numbers or symbols");
        return true;
    }
}
