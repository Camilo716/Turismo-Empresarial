package org.example.Validators;

import org.example.Util.DateParser;

import java.time.LocalDate;


public class DateValidator implements IValidable<String>{
    @Override
    public Boolean validate(String dateString) throws Exception {
        try {
            LocalDate parsedDate = DateParser.fromStringToDate(dateString, "dd/MM/yyyy");
            return true;
        } catch (Exception e) {
            throw new Exception("Date is not in the correct format (dd//MM/yyyy)");
        }
    }

    public static boolean date1_isAfter_date2(LocalDate dateAfter, LocalDate dateBefore) throws Exception {
        if (dateBefore.isAfter(dateAfter))
            throw new Exception("End date should be after start date");

        return true;
    }
}