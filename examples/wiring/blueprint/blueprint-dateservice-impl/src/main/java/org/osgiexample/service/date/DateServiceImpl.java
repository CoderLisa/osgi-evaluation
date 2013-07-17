package org.osgiexample.service.date;

import java.text.DateFormat;
import java.util.Date;

public class DateServiceImpl implements DateService {

    public DateServiceImpl() {
        System.out.println("starting date service blueprint");
    }

    @Override
    public String getFormattedDate(Date date) {
        return DateFormat.getDateInstance(DateFormat.LONG).format(date);
    }
}
