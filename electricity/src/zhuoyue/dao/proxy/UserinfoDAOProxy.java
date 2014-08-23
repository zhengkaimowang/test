package zhuoyue.dao.proxy;

import java.util.List;

import zhuoyue.dao.IUserinfoDAO;
import zhuoyue.dao.impl.UserinfoDAOImpl;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.Userinfo;

public class UserinfoDAOProxy implements IUserinfoDAO {

	private DatabaseConnection dbc = null;
	private IUserinfoDAO dao = null;
	public UserinfoDAOProxy() throws Exception
	{
		this.dbc = new DatabaseConnection();
		this.dao = new UserinfoDAOImpl(this.dbc.getConnection());
	}
	@Override
	public Boolean doAlterUser(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doAlterUser(user);
		this.dbc.close();
		return flag;
	}

	@Override
	public Boolean doCreateUser(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		if(this.dao.findByCode(user.getUserCode()) == null)
		{
			flag = this.dao.doCreateUser(user);
		}
		this.dbc.close();
		return flag;
	}

	@Override
	public List<Userinfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Userinfo> all = null;
		all = this.dao.findAll();
		this.dbc.close();
		return all;
	}

	@Override
	public Userinfo findByCode(String Code) throws Exception {
		// TODO Auto-generated method stub
		Userinfo user = null;
		user = this.dao.findByCode(Code);
		this.dbc.close();
		return user;
	}

	@Override
	public List<Userinfo> findByKeyWord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<Userinfo> all = null;
		all = this.dao.findByKeyWord(keyWord);
		this.dbc.close();
		return all;
	}

	@Override
	public Boolean login(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.login(user);
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
	public Boolean doChangePwd(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doChangePwd(user);
		this.dbc.close();
		return flag;
	}
	@Override
	public Boolean doChangePrivilege(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		flag = this.dao.doChangePrivilege(user);
		this.dbc.close();
		return flag;
	}

}
