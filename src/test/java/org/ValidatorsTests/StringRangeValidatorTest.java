package org.ValidatorsTests;

import org.example.Validators.StringRangeValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringRangeValidatorTest{
    @Test
    public void testInvalidTooShortString() throws Exception {
        StringRangeValidator stringRangeValidator = new StringRangeValidator(11, Integer.MAX_VALUE);

        assertThrows(Exception.class, () -> {
            stringRangeValidator.validate("Camilo716");
        });
    }
}
