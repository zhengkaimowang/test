package tubiao;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.*;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;


public class BaoBiao {
	public JFreeChart getMonth(List<Integer> guzhang,int month,int year,String name) {
		TimeSeriesCollection dataset = new TimeSeriesCollection();//时间曲线数据集合 
		TimeSeries s1 = new TimeSeries("故障曲线", Day.class);//创建时间数据源，每一个//TimeSeries在图上是一条曲线 
		//s1.add(new Day(day,month,year),value),添加数据点信息 
		Iterator<Integer> ite = guzhang.iterator();
		int i = 1;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH,month-1);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.DAY_OF_WEEK_IN_MONTH, 4);
		int day = c.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH);
		while (ite.hasNext()){
			s1.add(new Day(i,month,year),ite.next()); 
			i++;
		}
		dataset.addSeries(s1); 
		JFreeChart chart = ChartFactory.createTimeSeriesChart("时间表", "日期",
				"故障", dataset, true, true, true);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(10D, 10D, 10D, 10D));
		// 设置曲线是否显示数据点
		xylineandshaperenderer.setBaseShapesVisible(true);
		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		// 设置子标题
		TextTitle subtitle = new TextTitle(String.valueOf(month)+"月故障统计", new Font("黑体", Font.BOLD,
				12));
		chart.addSubtitle(subtitle);
		// 设置主标题
		chart.setTitle(new TextTitle(name, new Font("隶书", Font.ITALIC, 15)));
		chart.setAntiAlias(true);
		return chart;
	}
	public JFreeChart getWeek(List<Integer> guzhang,int month,int year,int weekofmonth,String name) {
		String remonth = String.valueOf(month);
		TimeSeriesCollection dataset = new TimeSeriesCollection();//时间曲线数据集合 
		TimeSeries s1 = new TimeSeries("故障曲线", Day.class);//创建时间数据源，每一个//TimeSeries在图上是一条曲线 
		//s1.add(new Day(day,month,year),value),添加数据点信息 
		Iterator<Integer> ite = guzhang.iterator();
		int i = 1;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH,month-1);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.DAY_OF_WEEK_IN_MONTH, weekofmonth);
		int day = c.get(Calendar.DATE);
		int day2 = c.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH);
		while (i<=7){
			s1.add(new Day(day,month,year),ite.next()); 
			day++;
			if (day>c.getActualMaximum(Calendar.DAY_OF_MONTH)){
				day=1;
				month++;
			}
			i++;
		}
		dataset.addSeries(s1); 
		JFreeChart chart = ChartFactory.createTimeSeriesChart("时间表", "日期",
				"故障", dataset, true, true, true);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(10D, 10D, 10D, 10D));
		// 设置曲线是否显示数据点
		xylineandshaperenderer.setBaseShapesVisible(true);
		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		// 设置子标题
		TextTitle subtitle = new TextTitle(remonth+"月故障统计", new Font("黑体", Font.BOLD,
				12));
		chart.addSubtitle(subtitle);
		// 设置主标题
		chart.setTitle(new TextTitle(name, new Font("隶书", Font.ITALIC, 15)));
		chart.setAntiAlias(true);
		return chart;
	}
	public JFreeChart getEquipment(List<String> name,List<Integer> guzhang,String ename){
		DefaultPieDataset dataset = new DefaultPieDataset();
		Iterator<String> ite1 = name.iterator();
		Iterator<Integer> ite2 = guzhang.iterator();
		while (ite1.hasNext()){
			dataset.setValue(ite1.next(), ite2.next());
		}
		JFreeChart chart = ChartFactory.createPieChart3D(ename+"故障饼图", dataset, true, true, true);	
		PiePlot3D pieplot = (PiePlot3D) chart.getPlot();	
		pieplot.setLabelFont(new Font("宋体", 0, 12));
		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(("{0}:{2}"), NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		//没有数据的时候显示的内容	
		pieplot.setForegroundAlpha(0.7F);
		pieplot.setNoDataMessage("该设备暂无故障记录");	
		pieplot.setCircular(false);	
		pieplot.setLabelGap(0.02D);	
		return chart;
	}
	public JFreeChart getZhu(List<String> name, List<Integer> guzhang) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Iterator<String> ite1 = name.iterator();
		Iterator<Integer> ite2 = guzhang.iterator();
		while (ite1.hasNext()){
			dataset.addValue(ite2.next(),ite1.next(),  "");
		}
		JFreeChart chart = ChartFactory.createBarChart3D("厂家故障统计图", "厂商",
				"故障/次", dataset, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = chart.getCategoryPlot();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 显示每个柱的数值，并修改该数值的字体属性
		BarRenderer3D renderer = new BarRenderer3D();
		renderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		// 默认的数字显示在柱子中，通过如下两句可调整数字的显示
		// 注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);
		// 设置每个地区所包含的平行柱的之间距离
		// renderer.setItemMargin(0.3);
		plot.setRenderer(renderer);
		return chart;
	}

	public JFreeChart getZhuForE(List<String> name, List<Integer> guzhang) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Iterator<String> ite1 = name.iterator();
		Iterator<Integer> ite2 = guzhang.iterator();
		while (ite1.hasNext()){
			dataset.addValue(ite2.next(),ite1.next(),  "");
		}
		JFreeChart chart = ChartFactory.createBarChart3D("设备故障统计图", "设备",
				"故障/次", dataset, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = chart.getCategoryPlot();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.pink);
		// 显示每个柱的数值，并修改该数值的字体属性
		BarRenderer3D renderer = new BarRenderer3D();
		renderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		// 默认的数字显示在柱子中，通过如下两句可调整数字的显示
		// 注意：此句很关键，若无此句，那数字的显示会被覆盖，给人数字没有显示出来的问题
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);
		// 设置每个地区所包含的平行柱的之间距离
		// renderer.setItemMargin(0.3);
		plot.setRenderer(renderer);
		return chart;
	}
}
