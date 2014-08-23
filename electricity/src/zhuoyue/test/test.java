package zhuoyue.test;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import zhuoyue.dao.impl.RecordDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.Record;


public class test {
	public static void main(String args[])
	{
		/*DatabaseConnection database = null;
		try {
			database = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RecordDAOImpl re = new RecordDAOImpl(database.getConnection());
		List<Record> list = null;
		Record record = new Record();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("电压");
		temp.add("电流");
		temp.add("电阻");
		ArrayList<String> standard = new ArrayList<String>();
		standard.add("110~120");
		standard.add("10~20");
		standard.add("50~100");
		try {
			Boolean flag = re.doCreateTable(5, temp, standard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			list = re.findByKeyword(1, 9, "0125436456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Record> it = list.iterator();
		while(it.hasNext())
		{
			Record record = it.next();
			System.out.print(record.getId()+" ");
			System.out.print(record.getCode()+" ");
			System.out.print(record.getDate()+" ");
			System.out.print(record.getUserCode()+" ");
			System.out.print(record.getUserName()+" ");
			List<String> parameter = record.getParameter();
			Iterator<String> it2 = parameter.iterator();
			while(it2.hasNext())
			{
				System.out.print(it2.next()+" ");
			}
			System.out.print(record.getRemark()+" ");
			System.out.print(record.getState()+" ");
		}*/
		String year = "2014";
		String month = "03";
		String date = "";
		String subName = "控制室";
		if((year == null) ||( "".equals(year)))
		{
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			year = df.format(c.getTime());
			df = new SimpleDateFormat("MM");
			month = df.format(c.getTime());
		}
		int iYear = new Integer(year);
		int iMonth = new Integer(month);
		int[] monDays = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if ( ( (iYear) % 4 == 0 && (iYear) % 100 != 0) ||(iYear) % 400 == 0) 
		{
		        monDays[1]++;
		}
		int iDate = monDays[iMonth-1];
		List<Equipment> list = null;
		try {
			list = DAOFactory.getEquipmentDAO().findBySubPro(subName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<String>> parameter = new ArrayList<List<String>>();
		int length = list.size();
		for(int temp = 0;temp < length;temp ++)
		{
			List<Integer> problem = new ArrayList<Integer>();
			List<String> theParameter = null;
			int name = 0;
			int count = 0;
			name = new Integer(list.get(temp).getTypecode());
			try {
				count = DAOFactory.getIRecordDAOInstance().getCount(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				theParameter = DAOFactory.getIRecordDAOInstance().getParameterName(name, count);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parameter.add(theParameter);
			for(int tempP = 0;tempP<theParameter.size();tempP++)
			{
				int theCount = 0;
				for(int tempDay = 0;tempDay < iDate;tempDay ++)
				{
					int increase = 0;
					if(tempDay<9)
					{
						date = year+"-"+month+"-0"+String.valueOf(tempDay+1);
					}
					else
					{
						date = year+"-"+month+"-"+String.valueOf(tempDay+1);
					}
					try {
						increase = DAOFactory.getIRecordDAOInstance().findProblemByDateAndParameter(name, date, tempP+1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					theCount += increase;
				}
				problem.add(theCount);
			}
			result.add(problem);
		}
		System.out.print(result);
	}
}
