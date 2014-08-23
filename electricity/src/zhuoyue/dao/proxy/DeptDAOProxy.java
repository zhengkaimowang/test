package zhuoyue.dao.proxy;

import java.util.List;

import zhuoyue.dao.IDeptDAO;
import zhuoyue.dao.impl.DeptDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.Dept;

public class DeptDAOProxy implements IDeptDAO {
	private DatabaseConnection dbc = null;
	private DeptDAOImpl dao = null;
	public DeptDAOProxy (){
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao = new DeptDAOImpl(this.dbc.getConnection());
	}
	public boolean doInsert(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.dao.doInsert(dept);
		this.dbc.close();
		return flag;
	}

	public boolean doRemove(Dept dept) throws Exception {
		boolean flag = false;
		flag = this.dao.doRemove(dept);
		this.dbc.close();
		return flag;
	}

	public boolean doUpdate(Dept dept) throws Exception {
		boolean flag = false;
		flag = this.dao.doUpdate(dept);
		this.dbc.close();
		return flag;
	}

	public List<Dept> findAll() throws Exception {
		List<Dept> all = null;
		all = this.dao.findAll();
		this.dbc.close();
		return all;
	}

}
