package org.example.Validators;

public class StringRangeValidator implements  IValidable<String> {

    Integer minLength;
    Integer maxLength;

    public StringRangeValidator(Integer minLength, Integer maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public Boolean validate(String str) throws Exception {
        boolean tooShort = str.length() <= minLength;
        boolean tooLong = str.length() > maxLength;

        if (tooShort)
            throw new Exception("String is too short");
        if (tooLong)
            throw new Exception("String is too long");

        return true;
    }
}
