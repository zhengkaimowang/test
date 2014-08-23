package zhuoyue.dao.proxy;

import java.sql.Connection;
import java.util.List;

import zhuoyue.dao.IProblemDAO;
import zhuoyue.dao.impl.ProblemDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.Problem;

public class ProblemDAOProxy implements IProblemDAO {


	DatabaseConnection dbc = null;
	ProblemDAOImpl impl = null;
	public ProblemDAOProxy(){
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.impl = new ProblemDAOImpl(this.dbc.getConnection());
	}
	@Override
	public List<Problem> findAll() throws Exception {
		List<Problem> all = impl.findAll();
		this.dbc.close();
		return all;
	}

	@Override
	public List<Problem> findByState(String state) throws Exception {
		// TODO Auto-generated method stub
		List<Problem> all = impl.findByState(state);
		this.dbc.close();
		return all;
	}

	@Override
	public List<Problem> findByType(String type) throws Exception {
		// TODO Auto-generated method stub
		List<Problem> all = impl.findByType(type);
		this.dbc.close();
		return all;
	}
	@Override
	public boolean doInsert(Problem pro) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Problem> findByStateAndType(String state, String type)
			throws Exception {
		// TODO Auto-generated method stub
		List<Problem> all = impl.findByStateAndType(state,type);
		this.dbc.close();
		return all;
	}
	@Override
	public int findRecordByCodeAndDate(String code, String date)
			throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		count = impl.findRecordByCodeAndDate(code, date);
		this.dbc.close();
		return count;
	}
	@Override
	public List<Problem> findByDate(String date) throws Exception {
		// TODO Auto-generated method stub
		List<Problem> all = impl.findByDate(date);
		this.dbc.close();
		return all;
	}

}
