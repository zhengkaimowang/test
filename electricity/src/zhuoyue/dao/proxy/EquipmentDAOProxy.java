package zhuoyue.dao.proxy;

import java.util.List;

import zhuoyue.dao.IEquipmentDAO;
import zhuoyue.dao.impl.EquipmentDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.Equipment;

public class EquipmentDAOProxy implements IEquipmentDAO{
	private DatabaseConnection dbc = null;
	private EquipmentDAOImpl impl = null;
	public EquipmentDAOProxy() {
		// TODO Auto-generated constructor stub
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.impl = new EquipmentDAOImpl(this.dbc.getConnection());
		
	}
	@Override
	public List<Equipment> findAll(String type) throws Exception {
		List<Equipment> all = impl.findAll(type);
		this.dbc.close();
		return all;
	}
	@Override
	public boolean doInsert(Equipment eq) throws Exception {
		boolean flag = impl.doInsert(eq);
		this.dbc.close();
		return flag;
	}
	@Override
	public List<Equipment> findByProject(String project) throws Exception {
		// TODO Auto-generated method stub
		List<Equipment> all = impl.findByProject(project);
		this.dbc.close();
		return all;
	}
	@Override
	public List<Equipment> findBySubPro(String subproject) throws Exception {
		// TODO Auto-generated method stub
		List<Equipment> all = impl.findBySubPro(subproject);
		this.dbc.close();
		return all;
	}
	@Override
	public boolean doDeleteByProject(String project) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.impl.doDeleteByProject(project);
		this.dbc.close();
		return flag;
	}
	@Override
	public boolean doDeleteBySubProject(String subProject) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.impl.doDeleteBySubProject(subProject);
		this.dbc.close();
		return flag;
	}
	@Override
	public boolean doRemove(String code) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.impl.doRemove(code);
		this.dbc.close();
		return flag;
	}
	@Override
	public Equipment findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		Equipment eq = null;
		eq = this.impl.findByCode(code);
		this.dbc.close();
		return eq;
	}
}
