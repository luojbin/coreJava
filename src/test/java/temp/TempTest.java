package temp;

import org.junit.Test;

import javax.swing.text.DateFormatter;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

    @Test
    public void testFloat() {

        float a1 = 123456.1234567f;
        float a2 = 12345.61234567f;
        float a3 = 1234.561234567f;
        float a4 = 123.4561234567f;
        float a5 = 12.34561234567f;
        float a6 = 1.234561234567f;
        float a7 = 0.1234561234567f;

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a6);
        System.out.println(a7);

        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a1)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a2)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a3)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a4)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a5)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a6)));
        System.out.println(Integer.toBinaryString(Float.floatToIntBits(a7)));


        System.out.println(String.format("%05d",1));
        // System.out.println(String.format("%032s",Integer.toBinaryString(Float.floatToIntBits(0.5f))));
        // System.out.println(String.format("%032s",Integer.toBinaryString(Float.floatToIntBits(-0.5f))));
    }

    @Test
    public void testFloat2() {
        float a = 0.1F;
        float b = 0.2F;
        float c = 0.3F;
        float d = 0.9F;
        System.out.println(a+b == c);
        System.out.println(1-c);
        System.out.println(c+c+c);
        System.out.println(c+c);
        System.out.println(0.6F+c);
        System.out.println(0.9 == d);
    }



    @Test
    public void testdeciToLong() {
        BigDecimal b = new BigDecimal("12.2");
        long l = b.setScale(0, RoundingMode.HALF_UP).longValue();
        System.out.println(l);
    }


    @Test
    public void testC() {
        String[] array = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",};
        try {
            Arrays.asList(array).stream().forEach(s -> {
                if (Math.random() * 10 > 8) {
                    throw new RuntimeException(s);
                } else {
                    System.out.println(s);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testC2() {
        String[] array = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",};

        Arrays.asList(array).stream().forEach(s -> {
            try {
                if (Math.random() * 10 > 8) {
                    throw new RuntimeException(s);
                } else {
                    System.out.println(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @Test
    public void testLocalTime() {
        String dateStr = "2018-11-22";
        String dateTimeStr = "2018-11-11 01:02:03";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, dateTimeFormatter);
        System.out.println("datetime ok: " + dateTime);

        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
        System.out.println("date ok: " + date);

        LocalDateTime date2DateTime = date.atStartOfDay();
        System.out.println("date2DateTime ok: " + date2DateTime);

    }


    @Test
    public void testGetFont() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String font : fonts ) {
            System.out.println(font);
        }
    }











}