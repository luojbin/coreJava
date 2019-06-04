package temp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.*;
import org.jfree.chart.util.UnitType;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
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


        calendar.set(2000, Calendar.FEBRUARY, 5);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
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

    @Test
    public void testRando() {
        for (;;){
            int index = (int) (Math.random() * 24);
            if (index >= 20){
                System.out.println(index);
            }
        }
    }

    @Test
    public void testBigDecimal() {
        Object s = null;
        String s1 = (String)s;
        System.out.println(s1);
        System.out.println(s1);

    }

    @Test
    public void testRegf() {
        String str = "111,222,333";
        String str2 = "111,,222,333,,,,,";

        int n1 = str.split(",").length;
        int n2 = str2.split(",").length;

        System.out.println(n1);
        System.out.println(n2);
    }

    @Test
    public void testStringBuilder() {
        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");
        System.out.println(a == b);
        System.out.println(a.hashCode() + ", " + b.hashCode());

        System.out.println(c == b);
        System.out.println(c.hashCode() + ", " + b.hashCode());

        System.out.println(d == b);
        System.out.println(d.hashCode() + ", " + b.hashCode());

        List l1 = new ArrayList();
        List l2 = new ArrayList();
        List l3 = new ArrayList();
        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());
        System.out.println(l3.hashCode());
    }

    @Test
    public void testSbbb() {
        StringBuilder sb = new StringBuilder();
        sb.append("123456789,");
        System.out.println(sb.substring(0, sb.length()-1));
    }

    @Test
    public void testContain() {
        String s = "1,2,4,6,8";
        System.out.println(s.contains("1"));
    }

    @Test
    public void testCalendar2() {

    }


    @Test
    public void testNullDecimal() {
        BigDecimal nullbd = new BigDecimal("null");
        System.out.println(nullbd);
    }

    @Test
    public void testJFreeChart() throws IOException {
        String title = "";
        String keyLabel = "";
        String valueLabel = "金额";
        // 数据集
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String priAmt = "应回本金";
        String intAmt = "应回利息";

        String total = "总应回款";
        String halfYear = "未来半年";
        String twoMonth = "未来2个月";
        String oneMonth = "未来一个月";
        String twoWeek = "未来两周";
        String oneWeek = "未来一周";
        dataset.addValue(100000000, priAmt, halfYear);
        dataset.addValue(100200000, priAmt, total);
        dataset.addValue(80000000, intAmt, halfYear);
        dataset.addValue(105000000, intAmt, total);
        dataset.addValue(78000000, priAmt, twoMonth);
        dataset.addValue(80000000, intAmt, twoMonth);
        dataset.addValue(80000000, priAmt, oneMonth);
        dataset.addValue(70000000, intAmt, oneMonth);
        dataset.addValue(85000000, priAmt, twoWeek);
        dataset.addValue(76000000, intAmt, twoWeek);
        dataset.addValue(84000000, priAmt, oneWeek);
        dataset.addValue(80000000, intAmt, oneWeek);

        // 生成柱状图
        JFreeChart barChart = ChartFactory.createBarChart(title, keyLabel, valueLabel, dataset,
                PlotOrientation.HORIZONTAL, true, true, false );

        // 格式化图表
        setBarChartStyle(barChart);

        File file = new File("demoChart.jpg");
        ChartUtils.saveChartAsJPEG(file, barChart, 800, 500);
    }

    public static void setValueAxisStyle(ValueAxis axis) {
        if (axis instanceof NumberAxis) {
            NumberAxis numberAxis = (NumberAxis) axis;
            numberAxis.setNumberFormatOverride(NumberFormat.getInstance());
        }

        // 设置Y轴的提示文字样式
        axis.setLabelFont(new Font("微软雅黑", Font.PLAIN, 12));
        // 设置Y轴刻度线的长度
        axis.setTickMarkInsideLength(0);
        // 设置Y轴刻度上余量比例(针对正值), 若手动设置了坐标轴范围, 则忽略
        axis.setUpperMargin(0.2);
        // 设置Y轴刻度上余量比例(针对负值), 若手动设置了坐标轴范围, 则忽略
        axis.setLowerMargin(0.2);
        // 设置坐标轴反向
        // axis.setInverted(true);
        // 设置刻度值垂直显示
        // axis.setVerticalTickLabels(true);

        // 设置坐标轴标签文字
        // axis.setLabel("setlabel");
        // 设置坐标轴标签文字角度
        // axis.setLabelAngle(45);
        // 设置坐标轴标签颜色
        // axis.setLabelPaint(Color.RED);
        axis.setLabelInsets(new RectangleInsets(UnitType.ABSOLUTE, 10,10,10,10));

        // 设置坐标轴标签位置
        axis.setLabelLocation(AxisLabelLocation.HIGH_END);


        axis.setAutoTickUnitSelection(true, true);
        axis.setAutoTickUnitSelection(true);

        axis.setMinorTickCount(100);
        // 设置坐标轴下边距或左边距
        // axis.setFixedDimension(100);
        // axis.setInverted(true);
        // axis.setAutoRange(true);
        // axis.setAutoRangeMinimumSize(5);
        // axis.setDefaultAutoRange(new Range(1,100));
        // // axis.setDownArrow(Shape);
        // axis.setFixedAutoRange(1000);
        // axis.setLowerBound(11);
        // axis.setNegativeArrowVisible(true);
        // axis.setPositiveArrowVisible(true);
        // axis.setRangeAboutValue(100,100);
        // axis.setRangeWithMargins(new Range(1,100));
        // axis.setUpperBound(2000);

    }
    public static void setBarChartStyle(JFreeChart chart) {
        CategoryPlot categoryplot = chart.getCategoryPlot();// 图本身
        // 设置图的背景为白色
        categoryplot.setBackgroundPaint(new Color(245, 247, 249));
        // 设置边框颜色
        categoryplot.setOutlinePaint(new Color(221, 221, 221));
        // 设置值坐标轴在底部
        categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        // 设置背景虚线的颜色
        categoryplot.setRangeGridlinePaint(new Color(0xB6A2DE));

        // 设置标题样式
        TextTitle titleStyle = chart.getTitle();
        titleStyle.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        // 设置图例样式
        LegendTitle legendStyle = chart.getLegend();
        legendStyle.setItemFont(new Font("微软雅黑", Font.PLAIN, 12));
        legendStyle.setPosition(RectangleEdge.TOP);
        legendStyle.setHorizontalAlignment(HorizontalAlignment.RIGHT);

        // 设置值坐标轴样式
        setValueAxisStyle(categoryplot.getRangeAxis());

        // 设置类别坐标轴样式
        CategoryAxis domainAxis = categoryplot.getDomainAxis();
        // 设置X轴下的标签文字
        domainAxis.setLabelFont(new Font("微软雅黑", Font.PLAIN, 12));
        // 设置X轴上提示文字样式
        domainAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 12));

        // 自定义柱状图中柱子的样式
        BarRenderer brender = new BarRenderer();
        // 设置颜色
        brender.setSeriesPaint(0, new Color(159, 195, 239)); // 给series2 Bar
        brender.setSeriesPaint(1, new Color(70, 120, 185)); // 给series1 Bar
        // 设置柱状图的顶端显示数字
        brender.setIncludeBaseInRange(true);
        brender.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        brender.setDefaultItemLabelsVisible(true);
        brender.setDefaultItemLabelPaint(Color.GRAY);
        brender.setDefaultItemLabelFont(new Font("微软雅黑", Font.PLAIN, 12));
        brender.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
        // 设置柱子为平面图不是立体的
        brender.setBarPainter(new StandardBarPainter());
        // 设置柱状图之间的距离0.1代表10%；
        brender.setItemMargin(0.1);

        // 设置柱子边框
        brender.setDrawBarOutline(false);
        // 设置柱子的阴影，false代表没有阴影
        brender.setShadowVisible(false);
        categoryplot.setRenderer(brender);
    }

    @Test
    public void tetttt() throws UnsupportedEncodingException {
        // 获取当前 JVM 采用的编码, utf-8
        System.out.println(System.getProperty("file.encoding"));

        String str = "中";
        char c = '中';
        byte[] strBytes = str.getBytes();
        byte[] utfBytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] gbkBytes = str.getBytes("gbk");

        System.out.println("\n获取中字的 unicode 的二进制表示");
        System.out.println("0" + Integer.toBinaryString(c));
        System.out.println(Integer.toHexString(c));

        System.out.println("\n输出中字以系统编码的二进制码");
        for (byte b : strBytes) {
            System.out.println(Integer.toBinaryString(b).substring(24));
        }

        System.out.println("\n输出中字以 utf-8编码的二进制码");
        for (byte b : utfBytes) {
            System.out.println(Integer.toBinaryString(b).substring(24));
        }

        System.out.println("\n输出中字以 gbk 编码的二进制码");
        for (byte b : gbkBytes) {
            System.out.println(Integer.toBinaryString(b).substring(24));
        }

        String gbkStr = new String(utfBytes, "gbk");
        String utf8Str = new String(utfBytes, StandardCharsets.UTF_8);
        String isoStr = new String(utfBytes, StandardCharsets.ISO_8859_1);

        System.out.println("gbkStr: " + gbkStr);
        System.out.println("utf8Str: " + utf8Str);
        System.out.println("isoStr: " + isoStr);
    }
}