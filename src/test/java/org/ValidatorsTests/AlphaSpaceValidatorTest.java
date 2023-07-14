package org.ValidatorsTests;

import org.example.Validators.AlphaSpaceValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlphaSpaceValidatorTest {
    private AlphaSpaceValidator alphaSpaceValidator;

    @BeforeEach
    public void setup() {
        alphaSpaceValidator= new AlphaSpaceValidator();
    }

    @Test
    public void testCannotContainNumbers() throws Exception {
        assertThrows(Exception.class, () -> {
            alphaSpaceValidator.validate("CamiloGonzalez716");
        });
    }

    @Test
    public void testCanContainÑ() {
        assertDoesNotThrow(() -> {
            boolean result = alphaSpaceValidator.validate("ÑecaBikuñeta");
            assertTrue(result);
        });
    }

    @Test
    public void testCanContainBlankSpaces() {
        assertDoesNotThrow(() -> {
            boolean result = alphaSpaceValidator.validate("Camilo Gonzalez");
            assertTrue(result);
        });
    }
}
