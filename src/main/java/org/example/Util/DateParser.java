package org.example.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static LocalDate fromStringToDate(String date, String format){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(date, dateFormatter);
    }
}
