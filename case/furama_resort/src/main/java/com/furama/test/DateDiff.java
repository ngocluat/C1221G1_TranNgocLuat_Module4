package com.furama.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDiff {

    public static void main(String[] args) {
        compareDates("2017-01-13 ", "2017-01-14");
        compareDates("2017-01-13", "2017-01-12");
        compareDates("2017-01-13", "2017-01-13");
        compareDates("2017-01-13", "2017-01-13");
  }

    public static void compareDates(String d1, String d2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);

            System.out.println("Date1" + sdf.format(date1));
            System.out.println("Date2" + sdf.format(date2));
            System.out.println();
            if (date1.after(date2)) {
                System.out.println("Date1 is after Date2"); }
            if (date1.before(date2)) {
                System.out.println("Date1 is before Date2"); }
            if (date1.equals(date2)) {
                System.out.println("Date1 is equal Date2"); }
            System.out.println();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public static void compareDates(Date date1, Date date2) {

        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
        }
        if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        }
        if (date1.equals(date2)) {
            System.out.println("Date1 is equal Date2");
        }

        System.out.println();
    }
}
