package org.osgiexample.bundle.impl;

import org.osgiexample.bundle.DateService;

import java.text.DateFormat;
import java.util.Date;

public class DateServiceImpl implements DateService {
    @Override
    public String getFormattedDate(Date date) {
        return DateFormat.getDateInstance(DateFormat.SHORT).format(date);
    }
}
