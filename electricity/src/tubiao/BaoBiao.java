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
		TimeSeriesCollection dataset = new TimeSeriesCollection();//ʱ���������ݼ��� 
		TimeSeries s1 = new TimeSeries("��������", Day.class);//����ʱ������Դ��ÿһ��//TimeSeries��ͼ����һ������ 
		//s1.add(new Day(day,month,year),value),������ݵ���Ϣ 
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
		JFreeChart chart = ChartFactory.createTimeSeriesChart("ʱ���", "����",
				"����", dataset, true, true, true);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		// �������񱳾���ɫ
		plot.setBackgroundPaint(Color.white);
		// ��������������ɫ
		plot.setDomainGridlinePaint(Color.pink);
		// �������������ɫ
		plot.setRangeGridlinePaint(Color.pink);
		// ��������ͼ��xy��ľ���
		plot.setAxisOffset(new RectangleInsets(10D, 10D, 10D, 10D));
		// ���������Ƿ���ʾ���ݵ�
		xylineandshaperenderer.setBaseShapesVisible(true);
		// ����������ʾ�����ݵ��ֵ
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		// �����ӱ���
		TextTitle subtitle = new TextTitle(String.valueOf(month)+"�¹���ͳ��", new Font("����", Font.BOLD,
				12));
		chart.addSubtitle(subtitle);
		// ����������
		chart.setTitle(new TextTitle(name, new Font("����", Font.ITALIC, 15)));
		chart.setAntiAlias(true);
		return chart;
	}
	public JFreeChart getWeek(List<Integer> guzhang,int month,int year,int weekofmonth,String name) {
		String remonth = String.valueOf(month);
		TimeSeriesCollection dataset = new TimeSeriesCollection();//ʱ���������ݼ��� 
		TimeSeries s1 = new TimeSeries("��������", Day.class);//����ʱ������Դ��ÿһ��//TimeSeries��ͼ����һ������ 
		//s1.add(new Day(day,month,year),value),������ݵ���Ϣ 
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
		JFreeChart chart = ChartFactory.createTimeSeriesChart("ʱ���", "����",
				"����", dataset, true, true, true);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		// �������񱳾���ɫ
		plot.setBackgroundPaint(Color.white);
		// ��������������ɫ
		plot.setDomainGridlinePaint(Color.pink);
		// �������������ɫ
		plot.setRangeGridlinePaint(Color.pink);
		// ��������ͼ��xy��ľ���
		plot.setAxisOffset(new RectangleInsets(10D, 10D, 10D, 10D));
		// ���������Ƿ���ʾ���ݵ�
		xylineandshaperenderer.setBaseShapesVisible(true);
		// ����������ʾ�����ݵ��ֵ
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		// �����ӱ���
		TextTitle subtitle = new TextTitle(remonth+"�¹���ͳ��", new Font("����", Font.BOLD,
				12));
		chart.addSubtitle(subtitle);
		// ����������
		chart.setTitle(new TextTitle(name, new Font("����", Font.ITALIC, 15)));
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
		JFreeChart chart = ChartFactory.createPieChart3D(ename+"���ϱ�ͼ", dataset, true, true, true);	
		PiePlot3D pieplot = (PiePlot3D) chart.getPlot();	
		pieplot.setLabelFont(new Font("����", 0, 12));
		pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator(("{0}:{2}"), NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		//û�����ݵ�ʱ����ʾ������	
		pieplot.setForegroundAlpha(0.7F);
		pieplot.setNoDataMessage("���豸���޹��ϼ�¼");	
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
		JFreeChart chart = ChartFactory.createBarChart3D("���ҹ���ͳ��ͼ", "����",
				"����/��", dataset, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = chart.getCategoryPlot();
		// �������񱳾���ɫ
		plot.setBackgroundPaint(Color.white);
		// ��������������ɫ
		plot.setDomainGridlinePaint(Color.pink);
		// �������������ɫ
		plot.setRangeGridlinePaint(Color.pink);
		// ��ʾÿ��������ֵ�����޸ĸ���ֵ����������
		BarRenderer3D renderer = new BarRenderer3D();
		renderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		// Ĭ�ϵ�������ʾ�������У�ͨ����������ɵ������ֵ���ʾ
		// ע�⣺�˾�ܹؼ������޴˾䣬�����ֵ���ʾ�ᱻ���ǣ���������û����ʾ����������
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);
		// ����ÿ��������������ƽ������֮�����
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
		JFreeChart chart = ChartFactory.createBarChart3D("�豸����ͳ��ͼ", "�豸",
				"����/��", dataset, PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = chart.getCategoryPlot();
		// �������񱳾���ɫ
		plot.setBackgroundPaint(Color.white);
		// ��������������ɫ
		plot.setDomainGridlinePaint(Color.pink);
		// �������������ɫ
		plot.setRangeGridlinePaint(Color.pink);
		// ��ʾÿ��������ֵ�����޸ĸ���ֵ����������
		BarRenderer3D renderer = new BarRenderer3D();
		renderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		// Ĭ�ϵ�������ʾ�������У�ͨ����������ɵ������ֵ���ʾ
		// ע�⣺�˾�ܹؼ������޴˾䣬�����ֵ���ʾ�ᱻ���ǣ���������û����ʾ����������
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);
		// ����ÿ��������������ƽ������֮�����
		// renderer.setItemMargin(0.3);
		plot.setRenderer(renderer);
		return chart;
	}
}
