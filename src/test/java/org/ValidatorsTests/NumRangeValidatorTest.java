package org.ValidatorsTests;

import org.example.Validators.MailValidator;
import org.example.Validators.NumRangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumRangeValidatorTest {
    @Test
    public void testLocationBetween1_4() throws Exception {
        NumRangeValidator numRangeValidator = new NumRangeValidator(1.0, 4.0);

        assertThrows(Exception.class, () -> {
            numRangeValidator.validate(5.0);
        });
    }

    @Test
    public void testPositiveNumberValidation() throws Exception {
        NumRangeValidator numRangeValidator = new NumRangeValidator(1.0, Double.MAX_VALUE);

        assertDoesNotThrow(() -> {
            numRangeValidator.validate(1.0);
        });
        assertThrows(Exception.class, () -> {
            numRangeValidator.validate(0.0);
        });
    }
}
