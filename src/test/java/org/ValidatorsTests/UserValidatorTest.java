package org.ValidatorsTests;

import org.example.Validators.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    private UserValidator userValidator;

    @BeforeEach
    public void setup() {
        userValidator = new UserValidator();
    }

    @Test
    public void testValidateName_InvalidNameWithNumbers() throws Exception {
        assertThrows(Exception.class, () -> {
            userValidator.validateName("CamiloGonzalez716");
        });
    }

    @Test
    public void testValidateName_TooShortName() throws Exception {
        assertThrows(Exception.class, () -> {
            userValidator.validateName("Camilo716");
        });
    }

    @Test
    public void testValidateName_AllowÑ() {
        assertDoesNotThrow(() -> {
            boolean result = userValidator.validateName("ÑecaBikuñeta");
            assertTrue(result);
        });
    }

    @Test
    public void testValidateName_AllowBlankSpaces() {
        assertDoesNotThrow(() -> {
            boolean result = userValidator.validateName("Camilo Gonzalez");
            assertTrue(result);
        });
    }

    @Test
    public void testValidateLocation_Above4() throws Exception {
        assertThrows(Exception.class, () -> {
            userValidator.validateLocation(5);
        });
    }

    @Test
    public void testValidateLocation_Below1() throws Exception {
        assertThrows(Exception.class, () -> {
            userValidator.validateLocation(0);
        });
    }
}