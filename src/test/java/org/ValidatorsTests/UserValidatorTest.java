package org.ValidatorsTests;

import org.example.Validators.UserValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    public void testValidateName_InvalidNameWithNumbers() throws Exception {
        // Arrange
        UserValidator userValidator = new UserValidator();

        // Act and Assert
        assertThrows(Exception.class, () -> {
            userValidator.validateName("CamiloGonzalez716");
        });
    }

    @Test
    public void testValidateName_tooShortName() throws Exception {
        // Arrange
        UserValidator userValidator = new UserValidator();

        // Act and Assert
        assertThrows(Exception.class, () -> {
            userValidator.validateName("Camilo716");
        });
    }

    @Test
    public void testValidateName_AllowÑ() {
        // Arrange
        UserValidator userValidator = new UserValidator();

        // Act and Assert
        assertDoesNotThrow(() -> {
            boolean result = userValidator.validateName("ÑecaBikuñeta");
            assertTrue(result);
        });
    }

    @Test
    public void testValidateName_AllowBlankSpaces() {
        // Arrange
        UserValidator userValidator = new UserValidator();

        // Act and Assert
        assertDoesNotThrow(() -> {
            boolean result = userValidator.validateName("Camilo Gonzalez");
            assertTrue(result);
        });
    }


}