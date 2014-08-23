package zhuoyue.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IEquipmentDAO;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.Equipment;

public class EquipmentDAOImpl implements IEquipmentDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public EquipmentDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Equipment> findAll(String type) throws Exception {
		List<Equipment> all = null;
		ResultSet re = null;
		if (type.equals("all")) {
			String sql = "SELECT * FROM Equipment";
			this.pstmt = this.conn.prepareStatement(sql);
			re = this.pstmt.executeQuery();
			all = new ArrayList<Equipment>();
			while (re.next()) {
				Equipment eq = new Equipment();
				eq.setCode(re.getString(1));
				eq.setTypecode(re.getString(2));
				eq.setTypename(re.getString(3));
				eq.setProject(re.getString(4));
				eq.setSubproject(re.getString(5));
				eq.setAddress(re.getString(6));
				eq.setDate(re.getString(7));
				eq.setProducer(re.getString(8));
				all.add(eq);
			}
			this.pstmt.close();
			return all;
		} else {
			String sql = "SELECT * FROM Equipment WHERE TypeCode=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, type);
			re = this.pstmt.executeQuery();
			all = new ArrayList<Equipment>();
			while (re.next()) {
				Equipment eq = new Equipment();
				eq.setCode(re.getString(1));
				eq.setTypecode(re.getString(2));
				eq.setTypename(re.getString(3));
				eq.setProject(re.getString(4));
				eq.setSubproject(re.getString(5));
				eq.setAddress(re.getString(6));
				eq.setDate(re.getString(7));
				eq.setProducer(re.getString(8));
				all.add(eq);
			}
			this.pstmt.close();
			return all;

		}
	}

	@Override
	public boolean doInsert(Equipment eq) throws Exception{
		// TODO Auto-generated method stub
		int f = 0;
		String sql = "INSERT INTO Equipment (Code,TypeCode,TypeName,Project,SubProject,Address,Date,Producer) VALUES(?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, eq.getCode());
		this.pstmt.setString(2, eq.getTypecode());
		this.pstmt.setString(3, eq.getTypename());
		this.pstmt.setString(4, eq.getProject());
		this.pstmt.setString(5, eq.getSubproject());
		this.pstmt.setString(6, eq.getAddress());
		this.pstmt.setString(7, eq.getDate());
		this.pstmt.setString(8, eq.getProducer());
		try {
			f = this.pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.pstmt.close();
			return false;
		}
		if (f!=0){
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean doRemove(String code) throws Exception {
		boolean flag = false;
		int re= 0;
		String sql = "DELETE  FROM Equipment WHERE Code=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, code);
		re = this.pstmt.executeUpdate();
		if (re!=0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public List<Equipment> findByProject(String project) throws Exception {
		ResultSet re = null;
		List<Equipment> all = null;
		String sql = "SELECT * FROM Equipment WHERE Project=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, project);
		re = this.pstmt.executeQuery();
		all = new ArrayList<Equipment>();
		while (re.next()) {
			Equipment eq = new Equipment();
			eq.setCode(re.getString(1));
			eq.setTypecode(re.getString(2));
			eq.setTypename(re.getString(3));
			eq.setProject(re.getString(4));
			eq.setSubproject(re.getString(5));
			eq.setAddress(re.getString(6));
			eq.setDate(re.getString(7));
			eq.setProducer(re.getString(8));
			all.add(eq);
		}
		this.pstmt.close();
		return all;

	}

	@Override
	public List<Equipment> findBySubPro(String subproject) throws Exception {
		// TODO Auto-generated method stub
		ResultSet re = null;
		List<Equipment> all = null;
		String sql = "SELECT * FROM Equipment WHERE SubProject=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, subproject);
		re = this.pstmt.executeQuery();
		all = new ArrayList<Equipment>();
		while (re.next()) {
			Equipment eq = new Equipment();
			eq.setCode(re.getString(1));
			eq.setTypecode(re.getString(2));
			eq.setTypename(re.getString(3));
			eq.setProject(re.getString(4));
			eq.setSubproject(re.getString(5));
			eq.setAddress(re.getString(6));
			eq.setDate(re.getString(7));
			eq.setProducer(re.getString(8));
			all.add(eq);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public boolean doDeleteByProject(String project) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int re= 0;
		String sql = "DELETE  FROM Equipment WHERE Project=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, project);
		re = this.pstmt.executeUpdate();
		if (re!=0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public boolean doDeleteBySubProject(String subProject) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		int re= 0;
		String sql = "DELETE  FROM Equipment WHERE SubProject=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, subProject);
		re = this.pstmt.executeUpdate();
		if (re!=0){
			flag=true;
		}
		this.pstmt.close();
		return flag;
	}

	@Override
	public Equipment findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		ResultSet re = null;
		String sql = "SELECT * FROM Equipment where code = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1, code);
		re = this.pstmt.executeQuery();
		Equipment eq = new Equipment();
		if (re.next()) 
		{
			eq.setCode(re.getString(1));
			eq.setTypecode(re.getString(2));
			eq.setTypename(re.getString(3));
			eq.setProject(re.getString(4));
			eq.setSubproject(re.getString(5));
			eq.setAddress(re.getString(6));
			eq.setDate(re.getString(7));
			eq.setProducer(re.getString(8));
		}
		this.pstmt.close();
		return eq;
	}

}
