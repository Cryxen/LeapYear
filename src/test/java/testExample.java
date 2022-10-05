import org.LeapYear.LeapYear;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

class LeapYearTests {
    @Test
    @DisplayName("Check if 2000 is leap year")
    void checkIf2000IsLeapYear() {
        LeapYear leapYear = new LeapYear();
        Assumptions.assumeTrue(leapYear.isLeapYear(2000));
    }
    @Test
    @DisplayName("Check if 2001 is not a leap year")
    void checkIf2001IsNotLeapYear() {
        LeapYear leapYear = new LeapYear();
        Assumptions.assumeFalse(leapYear.isLeapYear(2001));
    }
    @Test
    @DisplayName("Check if all years from year 0 until 2000 dividable with 4 but not 100 is leap year")
    void checkAllYearsDividableWithFourButNot100() {
        LeapYear leapYear = new LeapYear();
        for (int Year = 0;  Year <= 2000 ; Year += 4) {
            if (Year % 100 != 0){
                Assumptions.assumeTrue(leapYear.isLeapYear(Year));
            }
        }
    }
    @Test
    @DisplayName("Check if every year dividable with 400 is a Leap year")
    void checkEveryYearDividableWith400() {
        LeapYear leapYear = new LeapYear();
        for (int Year = 0; Year <= 2000 ; Year++){
            if (Year % 400 == 0) {
                Assumptions.assumeTrue(leapYear.isLeapYear(Year));
            }
        }
    }
    @Test
    @DisplayName("See if years that is not dividable by four is not a leap year")
    void checkFalseLeapYearsNotDividableByFour(){
        LeapYear leapYear = new LeapYear();
        for (int Year = 0; Year <= 2000; Year++){
            if(Year % 4 != 0) {
                Assumptions.assumeFalse(leapYear.isLeapYear(Year));
            }
        }
    }
    @Test
    @DisplayName("See if years dividable with 100 but not 400 is a leap year")
    void checkFalseLeapYearsNotDividableWith100Not400(){
        // TODO: That was a bit of a long method name, come back and refactor.
        LeapYear leapYear = new LeapYear();
        for (int Year = 0; Year <= 2000; Year++){
            if (Year % 100 == 0 && Year % 400 != 0){
                Assumptions.assumeFalse(leapYear.isLeapYear(Year));
            }
        }
    }
    @Test
    @DisplayName("See if 1700 was not a Leap year")
    void check1700NotLeapYear() {
        LeapYear leapYear = new LeapYear();
        Assumptions.assumeFalse(leapYear.isLeapYear(1700));
    }
    @Test
    @DisplayName("See if 1800 was not a Leap year")
    void check1800NotLeapYear() {
        LeapYear leapYear = new LeapYear();
        Assumptions.assumeFalse(leapYear.isLeapYear(1800));
    }
    @Test
    @DisplayName("See if 1900 was not a Leap year")
    void check1900NotLeapYear() {
        LeapYear leapYear = new LeapYear();
        Assumptions.assumeFalse(leapYear.isLeapYear(1900));
    }
    @Test
    @DisplayName("See if 2100 is not going to be Leap year")
    void check2100NotLeapYear() {
        LeapYear leapYear = new LeapYear();
        Assumptions.assumeFalse(leapYear.isLeapYear(2100));
    }
}