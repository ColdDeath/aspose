package ru.gbuac.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final String DATE_PRINT_PATTERN = "dd MMMM yyyy";
    public static final String DATE_TIME_PRINT_PATTERN = "dd MMMM HH:mm";
    public static final String DATE_PATTERN = "dd.MM.yyyy";
    public static final String TIME_PATTERN = "HH:mm";
    public static final String DATE_TIME_PATTERN = "dd.MM.yyyy HH:mm";
    public static final DateTimeFormatter DATE_PRINT_FORMATTER = DateTimeFormatter.ofPattern(DATE_PRINT_PATTERN);
    public static final DateTimeFormatter DATE_TIME_PRINT_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PRINT_PATTERN);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    private DateTimeUtil() {
    }

    public static String toStringPrint(LocalDate ld) {
        return ld == null ? "" : ld.format(DATE_PRINT_FORMATTER);
    }
    public static String toStringPrint(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_PRINT_FORMATTER);
    }

    public static String toString(LocalDate ld) {
        return ld == null ? "" : ld.format(DATE_FORMATTER);
    }

    public static String toString(LocalTime lt) {
        return lt == null ? "" : lt.format(TIME_FORMATTER);
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }

    public static LocalDate parseLocalDate(String str) {
        return StringUtils.isEmpty(str) ? null : LocalDate.parse(str);
    }

    public static LocalTime parseLocalTime(String str) {
        return StringUtils.isEmpty(str) ? null : LocalTime.parse(str);
    }
}
