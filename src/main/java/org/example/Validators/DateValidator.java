package org.example.Validators;

import jdk.jshell.spi.ExecutionControl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator implements IValidable<String>{
    private DateTimeFormatter dateFormatter;

    public DateValidator() {
        dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }

    @Override
    public Boolean validate(String dateString) throws Exception {
        try {
            LocalDate date = LocalDate.parse(dateString, dateFormatter);
            return true;
        } catch (Exception e) {
            throw new Exception("Date is not in the correct format (dd//MM/yyyy)");
        }
    }

//    public static boolean Date1_isAfter_Date2(LocalDate)
//    {
//    }
}