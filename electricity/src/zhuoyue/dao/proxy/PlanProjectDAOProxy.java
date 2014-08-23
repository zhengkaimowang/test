package zhuoyue.dao.proxy;

import java.util.List;

import zhuoyue.dao.IPlanProjectDAO;
import zhuoyue.dao.impl.PlanProjectDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.PlanProject;

public class PlanProjectDAOProxy implements IPlanProjectDAO {
	private DatabaseConnection dbc = null;
	private IPlanProjectDAO dao = null;
	public PlanProjectDAOProxy()
	{
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao = new PlanProjectDAOImpl(dbc.getConnection());
	}
	@Override
	public Boolean doInsert(PlanProject plan) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = dao.doInsert(plan);
		this.dbc.close();
		return flag;
	}

	@Override
	public Boolean doUpdate(PlanProject plan) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = dao.doUpdate(plan);
		this.dbc.close();
		return flag;
	}

	@Override
	public List<PlanProject> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = null;
		list = this.dao.findAll();
		this.dbc.close();
		return list;
	}

	@Override
	public PlanProject findByCode(int code) throws Exception {
		// TODO Auto-generated method stub
		PlanProject plan = null;
		plan = this.dao.findByCode(code);
		this.dbc.close();
		return plan;
	}

	@Override
	public List<PlanProject> findByDate(String date) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = null;
		list = this.dao.findByDate(date);
		this.dbc.close();
		return list;
	}

	@Override
	public List<PlanProject> findByProject(String projectCode) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = null;
		list = this.dao.findByProject(projectCode);
		this.dbc.close();
		return list;
	}

	@Override
	public List<PlanProject> findByProjectAndDate(String projectCode,
			String date) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = null;
		list = this.dao.findByProjectAndDate(projectCode, date);
		this.dbc.close();
		return list;
	}

	@Override
	public int getMax() throws Exception {
		// TODO Auto-generated method stub
		int max = 0;
		max = this.dao.getMax();
		this.dbc.close();
		return max;
	}
	@Override
	public List<PlanProject> findNotEnd(String endTime) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = null;
		list = this.dao.findNotEnd(endTime);
		this.dbc.close();
		return list;
	}
	@Override
	public List<PlanProject> findByPerson(String userCode) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = null;
		list = this.dao.findByPerson(userCode);
		this.dbc.close();
		return list;
	}
	@Override
	public List<PlanProject> findByDateAndPerson(String date, String userCode)
			throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = null;
		list = this.dao.findByDateAndPerson(date, userCode);
		this.dbc.close();
		return list;
	}

}
