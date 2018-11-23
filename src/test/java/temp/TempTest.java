package temp;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author luojbin
 * @version 1.0
 * @create 2018-10-16 10:22
 */
public class TempTest {
    @Test
    public void testSwitch() {
        System.out.println("1234\tABCD");
        System.out.println("1234\\tABCD");
        System.out.println("1234\\\tABCD");
        System.out.println("1234\\\\tABCD");
    }

    @Test
    public void testStringFormat() {
        int a = 1;
        System.out.println(stringFormat(a));
        System.out.println(switchFormat(a));
    }

    private String stringFormat(int a) {
        return "1234567890".substring(0, 8) + String.format("%05d", a);
    }

    private String switchFormat(int codeNew) {
        String newCodePrefix = "1234567890".substring(0, 8);
        // 判断当前是几位

        switch ((""+codeNew).length()) {
            case 1:
                newCodePrefix += "0000" + codeNew;
                break;
            case 2:
                newCodePrefix += "000" + codeNew;
                break;
            case 3:
                newCodePrefix += "00" + codeNew;
                break;
            case 4:
                newCodePrefix += "0" + codeNew;
                break;
            case 5:
                newCodePrefix += codeNew;
                break;
            default:
                break;
        }
        return newCodePrefix;
    }

    @Test
    public void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        System.out.println(list);
    }
    @Test
    public void testFormat() {
        String s1 = String.format("%5d", 1);
        String s2 = String.format("%05d", 1);
        String s3 = String.format("%+5d", 1);

        System.out.println(">" + s1 + "<");
        System.out.println(">" + s2 + "<");
        System.out.println(">" + s3 + "<");
    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String today = sdf.format(calendar.getTime());

        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        String tomorrow = sdf.format(calendar.getTime());

        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        String nextWeek = sdf.format(calendar.getTime());

        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 15);
        String nextHalfMonth = sdf.format(calendar.getTime());

        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 30);
        String nextMonth = sdf.format(calendar.getTime());

        System.out.println(today);
        System.out.println(tomorrow);
        System.out.println(nextWeek);
        System.out.println(nextHalfMonth);
        System.out.println(nextMonth);


    }

    @Test
    public void testDateComparator() {
        String today = "2018-11-16";
        String endDate = "2018-11-15";
        if (today.compareTo(endDate) > 0) {
            System.out.println("当前授信已过期, 请重新申请或选择其他授信额度");
        } else {
            System.out.println("有效");
        }
    }

    @Test
    public void testFont() {

        // oO0 1iIlL 从此不再混淆

        System.out.println("abcdefghijklmn");
        System.out.println("ABCDEFGHIJKLMN");
        System.out.println("0123456789");
    }

    @Test
    public void testPattern() {
        String reg = "(1,2,3,4|1)";
        System.out.println(Pattern.matches(reg, "1,2,3,4"));
        System.out.println(Pattern.matches(reg, "1"));
        System.out.println(Pattern.matches(reg, "1,2,3"));
    }

}