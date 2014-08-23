package zhuoyue.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IEquipmentDAO;
import zhuoyue.dao.IProblemDAO;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.Problem;

public class ProblemDAOImpl implements IProblemDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public ProblemDAOImpl(Connection conn){
		this.conn = conn ;
	}

	@Override
	public List<Problem> findAll()  throws Exception{
		// TODO Auto-generated method stub
		List<Problem> all = new ArrayList<Problem>() ;
		ResultSet re = null;
		String Sql = "SELECT p1.[Code],e1.[TypeName],p1.[EquipmentCode],e1.[project],e1.[subproject],p1.[Date],p1.[ProblemState],e1.[TypeCode] FROM [waibao].[dbo].[Problem] p1,[waibao].[dbo].[Equipment] e1 WHERE p1.[EquipmentCode]=e1.[Code] ";
		this.pstmt = this.conn.prepareStatement(Sql);
		re = this.pstmt.executeQuery();
		while(re.next()){
			Problem pro = new Problem();
			pro.setCode(re.getInt(1));
			pro.setTypename(re.getString(2));
			pro.setEquipmentcode(re.getString(3));
			pro.setProject(re.getString(4));
			pro.setSubproject(re.getString(5));
			pro.setDate(re.getString(6));
			pro.setProblemState(re.getString(7));
			pro.setTypecode(re.getString(8));
			all.add(pro);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<Problem> findByState(String state)  throws Exception{
		// TODO Auto-generated method stub
		List<Problem> all = new ArrayList<Problem>() ;
		ResultSet re = null;
		String Sql = "SELECT p1.[Code],e1.[TypeName],p1.[EquipmentCode],e1.[project],e1.[subproject],p1.[Date],p1.[ProblemState],e1.[TypeCode] FROM [waibao].[dbo].[Problem] p1,[waibao].[dbo].[Equipment] e1 WHERE p1.[EquipmentCode]=e1.[Code] AND p1.[ProblemState]=?";
		this.pstmt = this.conn.prepareStatement(Sql);
		this.pstmt.setString(1, state);
		re = this.pstmt.executeQuery();
		while(re.next()){
			Problem pro = new Problem();
			pro.setCode(re.getInt(1));
			pro.setTypename(re.getString(2));
			pro.setEquipmentcode(re.getString(3));
			pro.setProject(re.getString(4));
			pro.setSubproject(re.getString(5));
			pro.setDate(re.getString(6));
			pro.setProblemState(re.getString(7));
			pro.setTypecode(re.getString(8));
			all.add(pro);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public List<Problem> findByType(String type)  throws Exception{
		// TODO Auto-generated method stub
		List<Problem> all = new ArrayList<Problem>() ;
		ResultSet re = null;
		String Sql = "SELECT p1.[Code],e1.[TypeName],p1.[EquipmentCode],e1.[project],e1.[subproject],p1.[Date],p1.[ProblemState],e1.[TypeCode] FROM [waibao].[dbo].[Problem] p1,[waibao].[dbo].[Equipment] e1 WHERE p1.[EquipmentCode]=e1.[Code] AND e1.[Typename]=?";
		this.pstmt = this.conn.prepareStatement(Sql);
		this.pstmt.setString(1, type);
		re = this.pstmt.executeQuery();
		while(re.next()){
			Problem pro = new Problem();
			pro.setCode(re.getInt(1));
			pro.setTypename(re.getString(2));
			pro.setEquipmentcode(re.getString(3));
			pro.setProject(re.getString(4));
			pro.setSubproject(re.getString(5));
			pro.setDate(re.getString(6));
			pro.setProblemState(re.getString(7));
			pro.setTypecode(re.getString(8));
			all.add(pro);
		}
		this.pstmt.close();
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
		List<Problem> all = new ArrayList<Problem>() ;
		ResultSet re = null;
		String Sql = "SELECT p1.[Code],e1.[TypeName],p1.[EquipmentCode],e1.[project],e1.[subproject],p1.[Date],p1.[ProblemState],e1.[TypeCode] FROM [waibao].[dbo].[Problem] p1,[waibao].[dbo].[Equipment] e1 WHERE p1.[EquipmentCode]=e1.[Code] AND e1.[Typename]=? AND p1.[ProblemState]=?";
		this.pstmt = this.conn.prepareStatement(Sql);
		this.pstmt.setString(1, type);
		this.pstmt.setString(2, state);
		re = this.pstmt.executeQuery();
		while(re.next()){
			Problem pro = new Problem();
			pro.setCode(re.getInt(1));
			pro.setTypename(re.getString(2));
			pro.setEquipmentcode(re.getString(3));
			pro.setProject(re.getString(4));
			pro.setSubproject(re.getString(5));
			pro.setDate(re.getString(6));
			pro.setProblemState(re.getString(7));
			pro.setTypecode(re.getString(8));
			all.add(pro);
		}
		this.pstmt.close();
		return all;
	}

	@Override
	public int findRecordByCodeAndDate(String code, String date)
			throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "SELECT count(Code) FROM Problem where date = ? and EquipmentCode = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1,date);
		pstmt.setString(2, code);
		ResultSet result = null;
		result = pstmt.executeQuery();
		if(result.next())
		{
			count = result.getInt(1);
		}
		this.pstmt.close();
		return count;
	}

	@Override
	public List<Problem> findByDate(String date) throws Exception {
		// TODO Auto-generated method stub
		List<Problem> all = new ArrayList<Problem>() ;
		ResultSet re = null;
		String Sql = "SELECT p1.[Code],e1.[TypeName],p1.[EquipmentCode],e1.[project],e1.[subproject],p1.[Date],p1.[ProblemState],e1.[TypeCode] FROM [waibao].[dbo].[Problem] p1,[waibao].[dbo].[Equipment] e1 WHERE p1.[EquipmentCode]=e1.[Code] AND p1.[Date]=?";
		this.pstmt = this.conn.prepareStatement(Sql);
		this.pstmt.setString(1, date);
		re = this.pstmt.executeQuery();
		while(re.next()){
			Problem pro = new Problem();
			pro.setCode(re.getInt(1));
			pro.setTypename(re.getString(2));
			pro.setEquipmentcode(re.getString(3));
			pro.setProject(re.getString(4));
			pro.setSubproject(re.getString(5));
			pro.setDate(re.getString(6));
			pro.setProblemState(re.getString(7));
			pro.setTypecode(re.getString(8));
			all.add(pro);
		}
		this.pstmt.close();
		return all;
	}

}
