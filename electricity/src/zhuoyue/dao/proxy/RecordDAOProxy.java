package zhuoyue.dao.proxy;

import java.util.List;

import zhuoyue.dao.IRecordDAO;
import zhuoyue.dao.impl.RecordDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.Record;

public class RecordDAOProxy implements IRecordDAO {
	private DatabaseConnection dbc = null;
	private IRecordDAO dao = null;
	public RecordDAOProxy() throws Exception
	{
			this.dbc = new DatabaseConnection();
			this.dao = new RecordDAOImpl(dbc.getConnection());
	}
	@Override
	public Boolean doCreateTable(int name, List<String> parameterName,
			List<String> standard) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doCreateTable(name, parameterName, standard);
		this.dbc.close();
		return flag;
	}

	@Override
	public Boolean doInsert(int name, int count, Record record)
			throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doInsert(name, count, record);
		this.dbc.close();
		return flag;
	}

	@Override
	public Boolean doUpdateParameter(int name, int id, List<String> parameter,
			int count) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doUpdateParameter(name, id, parameter, count);
		this.dbc.close();
		return flag;
	}

	@Override
	public Boolean doUpdateState(int name, int state, int id, String remark) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doUpdateState(name, state, id, remark);
		this.dbc.close();
		return flag;
	}

	@Override
	public List<Record> findAll(int name, int count) throws Exception {
		// TODO Auto-generated method stub
		List<Record> list = null;
		list = this.dao.findAll(name, count);
		this.dbc.close();
		return list;
	}

	@Override
	public Record findByDateAndCode(int name, int count, String date,
			String code) throws Exception {
		// TODO Auto-generated method stub
		Record record = null;
		record = this.dao.findByDateAndCode(name, count, date, code);
		this.dbc.close();
		return record;
	}

	@Override
	public List<Record> findByKeyword(int name, int count, String key)
			throws Exception {
		// TODO Auto-generated method stub
		List<Record> list = null;
		list = this.dao.findByKeyword(name, count, key);
		this.dbc.close();
		return list;
	}

	@Override
	public int getCount(int name) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		count = this.dao.getCount(name);
		this.dbc.close();
		return count;
	}

	@Override
	public int getMax(int name) throws Exception {
		// TODO Auto-generated method stub
		int max = 0;
		max = this.dao.getMax(name);
		this.dbc.close();
		return max;
	}

	@Override
	public List<String> getParameterName(int name, int count) throws Exception {
		// TODO Auto-generated method stub
		List<String> list = null;
		list = this.dao.getParameterName(name, count);
		this.dbc.close();
		return list;
	}

	@Override
	public List<String> getStandard(int name, int count) throws Exception {
		// TODO Auto-generated method stub
		List<String>list = null;
		list = this.dao.getStandard(name, count);
		this.dbc.close();
		return list;
	}
	@Override
	public Record findByPlanAndCode(int name, int count, int planCode,
			String code) throws Exception {
		// TODO Auto-generated method stub
		Record record = null;
		record = this.dao.findByPlanAndCode(name, count, planCode, code);
		this.dbc.close();
		return record;
	}
	@Override
	public int findProblemByDateAndParameter(int name, String date,
			int parameter) throws Exception {
		int num = 0;
		num = this.dao.findProblemByDateAndParameter(name, date, parameter);
		this.dbc.close();
		return num;
	}

}
