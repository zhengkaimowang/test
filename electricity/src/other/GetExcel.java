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
		// ��һ��������һ��webbook����Ӧһ��Excel�ļ�
		this.wb = new HSSFWorkbook();
		// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
		this.sheet = wb.createSheet("����");
		// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		this.rowCount = 0;
		this.row = sheet.createRow(rowCount);
		// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
		this.style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����һ�����и�ʽ
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
		// ���岽��д��ʵ������ ʵ��Ӧ������Щ���ݴ����ݿ�õ���
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
		// �����������ļ��浽ָ��λ��
		FileOutputStream fout = new FileOutputStream(path+File.separator+"report.xls");
		wb.write(fout);
		fout.close();
	}
}
