package com.hotelManagementV2.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtils {
    public static boolean formattingDate(LocalDate startDate, LocalDate endDate) {


        try {

            LocalDate now = LocalDate.now();
            return startDate.isAfter(now) && startDate.isBefore(endDate);
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format: " + e.getMessage());
            return false;
        }
    }
}
