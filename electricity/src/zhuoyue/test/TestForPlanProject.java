package zhuoyue.test;

import java.util.Iterator;
import java.util.List;

import zhuoyue.dao.impl.PlanProjectDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.PlanProject;

public class TestForPlanProject 
{
	public static void main(String []args)
	{
		DatabaseConnection dbc = null;
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int max = 9;
		try {
			max = DAOFactory.getPlanProjectDAO().getMax();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		PlanProjectDAOImpl dao = new PlanProjectDAOImpl(dbc.getConnection());
		List<PlanProject> list = null;
		PlanProject plan = new PlanProject();
		plan.setPlanCode(3);
		plan.setStartTime("121212");
		plan.setEndTime("131313");
		plan.setSubProjectCode("11");
		plan.setSubProjectName("ybsb");
		plan.setUserCode("0001");
		plan.setUserName("ybsb");
		int max = 0;
		Boolean flag = false;
		try {
			flag = dao.doUpdate(plan);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*Iterator<PlanProject> it = list.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next().getEndTime());
		}*/
		System.out.print(max);
	}
}
