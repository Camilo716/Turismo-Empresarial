package org.example.Validators;

import org.example.Util.Regex;

public class AlphaSpaceValidator implements IValidable<String>{
    @Override
    public Boolean validate(String str) throws Exception {
        String regex = "^[a-zA-ZñÑ ]+$";
        boolean notMatchesPattern = !Regex.matchesPattern(str, regex);

        if (notMatchesPattern)
            throw new Exception("Name can´t contain numbers or symbols");

        return true;
    }
}
