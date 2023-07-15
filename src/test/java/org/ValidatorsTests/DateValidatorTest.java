package org.ValidatorsTests;

import org.example.Validators.DateValidator;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class DateValidatorTest {
    private DateValidator dateValidator;

    @BeforeEach
    public void setup() {
        dateValidator = new DateValidator();
    }

    @Test
    public void testValidDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateString = "31/12/2022";
        LocalDate validDate = LocalDate.parse(dateString, dateFormatter);

        String formattedDate = validDate.format(dateFormatter);

        assertDoesNotThrow(() -> {
            dateValidator.validate(formattedDate);
        });
    }


    @Test
    public void testShouldNotIncludeTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate invalidDate = LocalDate.parse("31/12/2022", dateFormatter).atTime(12, 30, 45).toLocalDate();

        assertThrows(Exception.class, () -> {
            dateValidator.validate(invalidDate.toString());
        });
    }
}
