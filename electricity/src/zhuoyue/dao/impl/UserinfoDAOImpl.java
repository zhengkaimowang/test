package zhuoyue.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IUserinfoDAO;
import zhuoyue.vo.Userinfo;

public class UserinfoDAOImpl implements IUserinfoDAO
{
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	public UserinfoDAOImpl(Connection conn)
	{
		this.connection = conn;
	}
	@Override
	public List<Userinfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Userinfo>all = new ArrayList<Userinfo>();
		String sql = "select * from Userinfo";
		this.pstmt = this.connection.prepareStatement(sql);
		ResultSet result = this.pstmt.executeQuery();
		Userinfo user = null;
		while(result.next())
		{
			user = new Userinfo();
			user.setUserCode(result.getString(1));
			user.setUserName(result.getString(2));
			user.setFunctionPrivilege(result.getString(4));
			user.setDeptName(result.getString(6));
			user.setEmail(result.getString(7));
			user.setAddress(result.getString(8));
			user.setQQ(result.getString(9));
			user.setTelephone(result.getString(10));
			all.add(user);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<Userinfo> findByKeyWord(String keyWord) throws Exception {
		List<Userinfo>all = new ArrayList<Userinfo>();
		String sql = "select * from Userinfo u where u.UserCode like ? or u.UserName like ? or u.DeptName like ?";
		this.pstmt = this.connection.prepareStatement(sql);
		this.pstmt.setString(1,"%"+keyWord+"%");
		this.pstmt.setString(2,"%"+keyWord+"%");
		this.pstmt.setString(3,"%"+keyWord+"%");
		ResultSet result = this.pstmt.executeQuery();
		Userinfo user = null;
		while(result.next())
		{
			user = new Userinfo();
			user.setUserCode(result.getString(1));
			user.setUserName(result.getString(2));
			user.setFunctionPrivilege(result.getString(4));
			user.setDeptName(result.getString(6));
			user.setEmail(result.getString(7));
			user.setAddress(result.getString(8));
			user.setQQ(result.getString(9));
			user.setTelephone(result.getString(10));
			all.add(user);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public Boolean login(Userinfo user) throws Exception {
		Boolean flag = false;
		String sql = "select UserName,FunctionPrivilege from Userinfo u where u.UserCode = ? and u.Pwd = ?";
		this.pstmt = this.connection.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserCode());
		this.pstmt.setString(2,user.getPwd());
		ResultSet result = pstmt.executeQuery();
		if(result.next())
		{
			user.setUserName(result.getString(1));
			user.setFunctionPrivilege(result.getString(2));
			flag = true;
		}
		result.close();
		this.pstmt.close();
		return flag;
	}
	@Override
	public Userinfo findByCode(String Code) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from Userinfo u where u.UserCode = ?";
		this.pstmt = this.connection.prepareStatement(sql);
		this.pstmt.setString(1,Code);
		ResultSet result = this.pstmt.executeQuery();
		Userinfo user = null;
		if(result.next())
		{
			user = new Userinfo();
			user.setUserCode(result.getString(1));
			user.setUserName(result.getString(2));
			user.setPwd(result.getString(3));
			user.setFunctionPrivilege(result.getString(4));
			user.setDeptCode(result.getString(5));
			user.setDeptName(result.getString(6));
			user.setEmail(result.getString(7));
			user.setAddress(result.getString(8));
			user.setQQ(result.getString(9));
			user.setTelephone(result.getString(10));
		}
		this.pstmt.close();
		return user;
	}
	@Override
	public Boolean doAlterUser(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "update Userinfo set UserName=?,DeptCode=?,DeptName=?,Email=?,Address=?,QQ=?,Telephone=? where UserCode = ?";;
		this.pstmt = this.connection.prepareStatement(sql);
		this.pstmt.setString(1, user.getUserName());
		this.pstmt.setString(2,user.getDeptCode());
		this.pstmt.setString(3,user.getDeptName());
		this.pstmt.setString(4,user.getEmail());
		this.pstmt.setString(5, user.getAddress());
		this.pstmt.setString(6, user.getQQ());
		this.pstmt.setString(7,user.getTelephone());
		this.pstmt.setString(8,user.getUserCode());
		if(this.pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}
	@Override
	public Boolean doCreateUser(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "insert into Userinfo(UserCode,UserName,Pwd,FunctionPrivilege,DeptCode,DeptName,Email,Address,QQ,Telephone) values(?,?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.connection.prepareStatement(sql);
		this.pstmt.setString(1,user.getUserCode());
		this.pstmt.setString(2, user.getUserName());
		this.pstmt.setString(3, user.getPwd());
		this.pstmt.setString(4, "*0001");
		this.pstmt.setString(5,user.getDeptCode());
		this.pstmt.setString(6,user.getDeptName());
		this.pstmt.setString(7,user.getEmail());
		this.pstmt.setString(8, user.getAddress());
		this.pstmt.setString(9, user.getQQ());
		this.pstmt.setString(10,user.getTelephone());
		if(this.pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}
	@Override
	public Boolean doDelete(String code) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "delete from Userinfo where UserCode = ?";
		this.pstmt = this.connection.prepareStatement(sql);
		this.pstmt.setString(1,code);
		if(this.pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}
	@Override
	public Boolean doChangePwd(Userinfo user) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "update Userinfo set Pwd = ? where UserCode = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1,user.getPwd());
		pstmt.setString(2,user.getUserCode());
		if(pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		pstmt.close();
		return flag;
	}
	@Override
	public Boolean doChangePrivilege(Userinfo user) throws Exception 
	{
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "update Userinfo set FunctionPrivilege = ? where UserCode = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, user.getFunctionPrivilege());
		pstmt.setString(2,user.getUserCode());
		if(pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}
	
}
