package org.example.Validators;

import org.example.Util.Regex;

public class UserValidator {
    public Boolean validateName(String names) throws Exception {
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

    public Boolean validateLocation(int locationNumber) throws Exception {
        boolean isHigherThan4 = locationNumber > 4;
        boolean isLowerThan1 = locationNumber < 1;

        if (isHigherThan4){
            throw new Exception("Location can't be higher than 4");
        } else if (isLowerThan1) {
            throw new Exception("Location can't be lower than 1");
        }
        return true;
    }

    public Boolean validateMail(String mail) throws Exception {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        boolean notMatchesPattern = !Regex.matchesPattern(mail, regex);
        boolean startWithNumber = Character.isDigit(mail.charAt(0));
        boolean doesNotContainAtSign = !mail.contains("@");

        if (notMatchesPattern){
            throw new Exception("Must be a valid mail");
        } else if (startWithNumber) {
            throw new Exception("Mail can't start with number");
        } else if (doesNotContainAtSign) {
            throw new Exception("Mail must contain at sign");
        }
        return true;
    }
}
