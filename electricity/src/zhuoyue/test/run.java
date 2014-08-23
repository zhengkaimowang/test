package zhuoyue.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;



import zhuoyue.dao.IEquipmentDAO;
import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.PlanProject;
import zhuoyue.vo.Problem;
import zhuoyue.vo.Record;

public class run {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Equipment> alle = null;
		List<Record> allr = new ArrayList<Record>();
		String subproject = "×ÓÏîÄ¿1";
		String plancode = "1";
		alle = DAOFactory.getEquipmentDAO().findBySubPro(subproject);
		Iterator<Equipment> ite = alle.iterator();
		while (ite.hasNext()){
			Equipment eq = ite.next(); 
			Record re = new Record();
			int tb = Integer.parseInt(eq.getTypecode());
			int count = DAOFactory.getIRecordDAOInstance().getCount(tb);
			re = DAOFactory.getIRecordDAOInstance().findByPlanAndCode(tb, count, Integer.parseInt(plancode), eq.getCode());
			allr.add(re);
		}
	}

}
