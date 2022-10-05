package org.LeapYear;

public class LeapYear {
    public boolean isLeapYear(int year){
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        }
        System.out.println("Year did not hit any if tests");
        return false;
    }


}
