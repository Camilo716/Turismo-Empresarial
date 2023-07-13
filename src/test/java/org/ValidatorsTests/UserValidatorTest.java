package org.ValidatorsTests;

import org.example.Validators.UserValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserValidatorTest {

    @Test
    public void testValidateName_InvalidNameWithNumbers() throws Exception {
        // Arrange
        UserValidator userValidator = new UserValidator();

        // Act and Assert
        assertThrows(Exception.class, () -> {
            userValidator.validateName("Camilo716");
        });
    }
}