package other;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class GetExcel {
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCellStyle style;
	private String path;
	private int rowCount;
	public GetExcel()
	{
		Class theClass = this.getClass();
		java.net.URL u = theClass.getResource("");
		this.path = u.toString().replaceAll("file:/", "");
		this.path = this.path.replace("WEB-INF/classes/other/","");
		//System.out.print(path);
		// 第一步，创建一个webbook，对应一个Excel文件
		this.wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		this.sheet = wb.createSheet("报表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		this.rowCount = 0;
		this.row = sheet.createRow(rowCount);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		this.style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
	}
	public void addExcel(List<?> one,List<?> theOther,String name)
	{
		HSSFCell cell = null;
		cell = row.createCell((short) 0);
		cell.setCellValue(name);
		cell.setCellStyle(style);
		rowCount++;
		row = sheet.createRow(rowCount);
		for(int temp = 0;temp < one.size();temp ++)
		{
			cell = row.createCell((short) temp);
			cell.setCellValue(one.get(temp).toString());
			cell.setCellStyle(style);
		}
		rowCount ++;
		// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
		row = sheet.createRow(rowCount);
		for (int temp = 0; temp < theOther.size(); temp ++)
		{
			cell = row.createCell((short) temp);
			cell.setCellValue(theOther.get(temp).toString());
			cell.setCellStyle(style);
		}
		rowCount ++;
		row = sheet.createRow(rowCount);
	}
	public void getExcel() throws Exception
	{
		// 第六步，将文件存到指定位置
		FileOutputStream fout = new FileOutputStream(path+File.separator+"report.xls");
		wb.write(fout);
		fout.close();
	}
}
