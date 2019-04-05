/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author class
 */
public class DateUtils {

    public static LocalDate convertSDateToLDate(final java.sql.Date sdate) {
        if (sdate == null) {
            return null;
        }
        return sdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static java.sql.Date convertLDateToSDate(final LocalDate ldate) {
        if (ldate == null) {
            return null;
        }
        return Date.valueOf(ldate);
    }
}
