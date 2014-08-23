package zhuoyue.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IDeptDAO;
import zhuoyue.vo.Dept;

public class DeptDAOImpl implements IDeptDAO{
	PreparedStatement pstmt = null;
	Connection conn = null;
	public DeptDAOImpl(Connection conn){
		this.conn = conn;
	}
	public boolean doInsert(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int re= 0;
		String sql = "INSERT INTO Dept (DeptCode,DeptName,Phone,LegalMan,Address) VALUES(?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dept.getDeptcode());
		this.pstmt.setString(2, dept.getDeptname());
		this.pstmt.setString(3, dept.getPhone());
		this.pstmt.setString(4, dept.getLegalman());
		this.pstmt.setString(5, dept.getAddress());
		re = this.pstmt.executeUpdate();
		if (re!=0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}

	public boolean doRemove(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int re= 0;
		String sql = "DELETE  FROM Dept WHERE DeptCode=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dept.getDeptcode());
		re = this.pstmt.executeUpdate();
		if (re!=0){
			flag=true;
		}
		this.pstmt.close();
		return flag;

	}

	public boolean doUpdate(Dept dept) throws Exception {
		boolean flag = false;
		int re= 0;
		String sql = "UPDATE   Dept SET DeptCode=?,DeptName=?,Phone=?,LegalMan=?,Address=? WHERE DeptCode=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dept.getDeptcode());
		this.pstmt.setString(2, dept.getDeptname());
		this.pstmt.setString(3, dept.getPhone());
		this.pstmt.setString(4, dept.getLegalman());
		this.pstmt.setString(5, dept.getAddress());
		this.pstmt.setString(6, dept.getDeptcode());
		re = this.pstmt.executeUpdate();
		if (re!=0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}

	public List<Dept> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Dept> all= new ArrayList<Dept>();
		ResultSet re = null;

		String sql = "SELECT * FROM Dept";
		this.pstmt = this.conn.prepareStatement(sql);
		re = this.pstmt.executeQuery();
		while (re.next()){
			Dept dept = new Dept() ;
			dept.setDeptcode(re.getString(1));
			dept.setDeptname(re.getString(2));
			dept.setPhone(re.getString(3));
			dept.setLegalman(re.getString(4));
			dept.setAddress(re.getString(5));
			all.add(dept);
		}
		this.pstmt.close();
		return all;
	}

}
