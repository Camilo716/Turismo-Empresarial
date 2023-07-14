package org.ValidatorsTests;

import org.example.Validators.MailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailValidatorTest {
    private MailValidator mailValidator;

    @BeforeEach
    public void setup() {
        mailValidator = new MailValidator();
    }

    @Test
    public void testvalidate_cantStartWithNumber() throws Exception {
        assertThrows(Exception.class, () -> {
            mailValidator.validate("123camilo@example.com");
        });
    }

    @Test
    public void testvalidate_mustContainAtSign() throws Exception {
        assertThrows(Exception.class, () -> {
            mailValidator.validate("camiloexample.com");
        });
    }

    @Test
    public void testvalidate_CanContainSomeSpecialChars() throws Exception {
        assertDoesNotThrow(() -> {
            mailValidator.validate("camilo_+.-@example.com");
        });
    }
}