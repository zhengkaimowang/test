package zhuoyue.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IEquipmentTypeDAO;
import zhuoyue.dao.impl.EquipmentTypeDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.EquipmentType;

public class EquipmentTypeDAOProxy implements IEquipmentTypeDAO {
	private DatabaseConnection dbc = null;
	private IEquipmentTypeDAO dao = null;
	public EquipmentTypeDAOProxy() throws Exception
	{
		dbc = new DatabaseConnection();
		dao = new EquipmentTypeDAOImpl(this.dbc.getConnection());
	}
	@Override
	public Boolean doCreate(EquipmentType type) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doCreate(type);
		this.dbc.close();
		return flag;
	}

	@Override
	public Boolean doDelete(String code) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doDelete(code);
		this.dbc.close();
		return flag;
	}

	@Override
	public List<EquipmentType> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<EquipmentType> list = new ArrayList<EquipmentType>();
		list = this.dao.findAll();
		this.dbc.close();
		return list;
	}

	@Override
	public int findMax() throws Exception {
		// TODO Auto-generated method stub
		int max = 0;
		max = this.dao.findMax();
		this.dbc.close();
		return max;
	}

	@Override
	public EquipmentType findByCodeOrName(String key) throws Exception {
		// TODO Auto-generated method stub
		EquipmentType type = new EquipmentType();
		type = this.dao.findByCodeOrName(key);
		this.dbc.close();
		return type;
	}

}
