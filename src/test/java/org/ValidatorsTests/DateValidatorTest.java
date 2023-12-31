package org.ValidatorsTests;

import org.example.Util.DateParser;
import org.example.Validators.DateValidator;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class DateValidatorTest {
    private DateValidator dateValidator;

    @BeforeEach
    public void setup() {
        dateValidator = new DateValidator();
    }

    @Test
    public void testInvalidFormat() {
        String dateString = "2022/12/31";

        assertThrows(Exception.class, () -> {
            dateValidator.validate(dateString);
        });
    }

    @Test
    public void testValidDate() {
        String dateString = "31/12/2022";

        assertDoesNotThrow(() -> {
            dateValidator.validate(dateString);
        });
    }

    @Test
    public void testEndDateShouldBeAfterStartDate()
    {
        LocalDate beforeDate = DateParser.fromStringToDate("10/03/2022", "dd/MM/yyyy");
        LocalDate afterDate = DateParser.fromStringToDate("30/12/2023", "dd/MM/yyyy");

        assertThrows(Exception.class, () -> {
            DateValidator.date1_isAfter_date2(beforeDate, afterDate);
        });
    }

}
