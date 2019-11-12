import java.util.*;

public class TestData {
    public static void main(String[] args){

        System.out.println(diff(10,0,10,1,5,9));
    }

    private static int julianDay(int year, int month, int day) {
        int a = (14 - month) / 12;
        int y = year + 4800 - a;
        int m = month + 12 * a - 3;
        return day + (153 * m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045;
    }

    private static int diff(int y1, int m1, int d1, int y2, int m2, int d2) {
        return julianDay(y1, m1, d1) - julianDay(y2, m2, d2);
    }
}
