package com.example.mylabandroid;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import helpers.DateFormatter;

public class DateFormatterTest {

    @Test
    public void testFormatDateString_Success() {
        String dateString = "2022-01-01T12:00:00";
        String format = "yyyy-MM-dd'T'HH:mm:ss";

        String formattedDate = DateFormatter.formatDateString(dateString, format);

        assertEquals("01 January 2022, 12:00:00", formattedDate);
    }
}
