package temp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class CreateJfreeBarChart {
    // 设置柱状图上方的标题
    private static String chartTitle = "预计回款";

    // 设置Y轴的标注
    private static String rangeAxisLabel = "金额";

    // 设置X轴的标注
    private static String domainAxisLabel = "";

    // 设置数据集合
    private static CategoryDataset Dataset = createDataset2();
    // 设置柱状图的柱子顶部是否显示数据
    private static boolean baseItemLabelsVisible = true;
    // 设置生成图片的宽度
    private static int width = 800;
    // 设置生成图片的高高度
    private static int height = 500;
    /**
     * 设置保存的路径和图片名称
     */
    private static String saveImgUrlAndName = "D:/BarChart3h.png";

    public static void main(String[] args) {
        try {
            iCreateBarChart();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 创建柱状图
     *
     // * @param categoryDataset
     */
    public static void iCreateBarChart() throws IOException {
        // TODO Auto-generated method stub
        JFreeChart chart = ChartFactory.createBarChart(getChartTitle(),
                getDomainAxisLabel(), getRangeAxisLabel(), getDataset());
        iSetBarChart(chart);
        File file = new File("demoChart.jpg");
        ChartUtils.saveChartAsJPEG(file, chart, 600,400);
        // WriteChartAsImage.writeChartAsImage(chart, getSaveImgUrlAndName(), getWidth(),
        //         getHeight());
    }

    /**
     * 设置柱状图的样式
     *
     * @param chart
     */
    public static void iSetBarChart(JFreeChart chart) {
        CategoryPlot categoryplot = chart.getCategoryPlot();// 图本身
        ValueAxis rangeAxis = categoryplot.getRangeAxis();
        CategoryAxis domainAxis = categoryplot.getDomainAxis();
        // 设置Y轴的提示文字样式
        rangeAxis.setLabelFont(new Font("微软雅黑", Font.PLAIN, 12));
        // 设置Y轴刻度线的长度
        rangeAxis.setTickMarkInsideLength(0);

        // rangeAxis.setTickMarkOutsideLength(10f);
        // 设置X轴下的标签文字
        domainAxis.setLabelFont(new Font("微软雅黑", Font.PLAIN, 12));
        // 设置X轴上提示文字样式
        domainAxis.setTickLabelFont(new Font("微软雅黑", Font.PLAIN, 12));
        NumberAxis vn = (NumberAxis) categoryplot.getRangeAxis();

        // 设置Y轴的数字为百分比样式显示
        DecimalFormat df = new DecimalFormat("0.0%");
        vn.setNumberFormatOverride(df);
        // 使柱状图反过来显示
        // vn.setInverted(true);
        // vn.setVerticalTickLabels(true);

        // 自定义柱状图中柱子的样式
        BarRenderer brender = new BarRenderer();
        brender.setSeriesPaint(0, Color.decode("#E46C0A")); // 给series2 Bar
        brender.setSeriesPaint(1, Color.decode("#C0504D")); // 给series1 Bar
        brender.setSeriesPaint(2, Color.decode("#4F81BD")); // 给series3 Bar
        brender.setSeriesPaint(3, Color.decode("#00B050")); // 给series4 Bar
        brender.setSeriesPaint(4, Color.decode("#7030A0")); // 给series5 Bar
        brender.setSeriesPaint(5, Color.decode("#00BF00")); // 给series6 Bar
        // 设置柱状图的顶端显示数字
        brender.setIncludeBaseInRange(true);
        // brender.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        // brender.setBaseItemLabelsVisible(isBaseItemLabelsVisible());
        // 设置柱子为平面图不是立体的
        brender.setBarPainter(new StandardBarPainter());
        // 设置柱状图之间的距离0.1代表10%；
        brender.setItemMargin(0.1);
        // 设置柱子的阴影，false代表没有阴影
        brender.setShadowVisible(false);


        // 设置图的背景为白色
        categoryplot.setBackgroundPaint(Color.WHITE);
        // 设置背景虚线的颜色
        categoryplot.setRangeGridlinePaint(Color.decode("#B6A2DE"));
        // 去掉柱状图的背景边框，使边框不可见
        categoryplot.setOutlineVisible(false);
        // 设置标题的字体样式
        chart.getTitle().setFont(new Font("微软雅黑", Font.PLAIN, 24));
        // 设置图表下方图例上的字体样式
        chart.getLegend().setItemFont(new Font("微软雅黑", Font.PLAIN, 12));

        categoryplot.setRenderer(brender);
    }

    /**
     * 数据集合
     *
     * @return
     */
    public static CategoryDataset createDataset2() {

        DefaultCategoryDataset result = new DefaultCategoryDataset();

        String series1 = "海南";
        String series3 = "青海";
        String series4 = "上海";
        String series5 = "北京";
        String series6 = "山西";
        String series2 = "青藏";
        String type1 = "城市状况";
        String type2 = "收入状况";
        result.addValue(0.1, series1, type1);
        result.addValue(0.3, series3, type1);
        result.addValue(0.7, series6, type1);
        result.addValue(0.4, series4, type1);
        result.addValue(0.5, series5, type1);
        result.addValue(0.2, series2, type1);
        // result.addValue(0.1, series1, type2);
        // result.addValue(0.2, series2, type2);
        // result.addValue(0.3, series3, type2);
        // result.addValue(0.5, series5, type2);
        // result.addValue(0.4, series4, type2);
        // result.addValue(0.7, series6, type2);
        return result;

    }


    public static String getChartTitle() {
        return chartTitle;
    }

    public static void setChartTitle(String chartTitle) {
        CreateJfreeBarChart.chartTitle = chartTitle;
    }

    public static String getRangeAxisLabel() {
        return rangeAxisLabel;
    }

    public static void setRangeAxisLabel(String rangeAxisLabel) {
        CreateJfreeBarChart.rangeAxisLabel = rangeAxisLabel;
    }

    public static String getDomainAxisLabel() {
        return domainAxisLabel;
    }

    public static void setDomainAxisLabel(String domainAxisLabel) {
        CreateJfreeBarChart.domainAxisLabel = domainAxisLabel;
    }

    public static CategoryDataset getDataset() {
        return Dataset;
    }

    public static void setDataset(CategoryDataset dataset) {
        Dataset = dataset;
    }

    public static boolean isBaseItemLabelsVisible() {
        return baseItemLabelsVisible;
    }

    public static void setBaseItemLabelsVisible(boolean baseItemLabelsVisible) {
        CreateJfreeBarChart.baseItemLabelsVisible = baseItemLabelsVisible;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        CreateJfreeBarChart.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        CreateJfreeBarChart.height = height;
    }

    public static String getSaveImgUrlAndName() {
        return saveImgUrlAndName;
    }

    public static void setSaveImgUrlAndName(String saveImgUrlAndName) {
        CreateJfreeBarChart.saveImgUrlAndName = saveImgUrlAndName;
    }

}
