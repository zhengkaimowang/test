package zhuoyue.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IPlanProjectDAO;
import zhuoyue.vo.PlanProject;

public class PlanProjectDAOImpl implements IPlanProjectDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	public PlanProjectDAOImpl(Connection connection)
	{
		this.connection = connection;
	}

	@Override
	public Boolean doInsert(PlanProject plan) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "Insert into PlanProject(PlanCode,UserCode,UserName,StartTime,EndTime,SubProjectCode,SubProjectName,Type) VALUES(?,?,?,?,?,?,?,?)";
		int planCode = this.getMax()+1;
		pstmt = this.connection.prepareStatement(sql);
		plan.setPlanCode(planCode);
		pstmt.setInt(1, planCode);
		pstmt.setString(2, plan.getUserCode());
		pstmt.setString(3, plan.getUserName());
		pstmt.setString(4,plan.getStartTime());
		pstmt.setString(5, plan.getEndTime());
		pstmt.setString(6,plan.getSubProjectCode());
		pstmt.setString(7,plan.getSubProjectName());
		pstmt.setString(8,plan.getType());
		if(pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}

	@Override
	public Boolean doUpdate(PlanProject plan) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "update PlanProject set UserCode=?,UserName=?,StartTime=?,EndTime=?,SubProjectCode=?,SubProjectName=?,Type=? where PlanCode = ?";
		int planCode = this.getMax()+1;
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, plan.getUserCode());
		pstmt.setString(2, plan.getUserName());
		pstmt.setString(3,plan.getStartTime());
		pstmt.setString(4, plan.getEndTime());
		pstmt.setString(5,plan.getSubProjectCode());
		pstmt.setString(6,plan.getSubProjectName());
		pstmt.setString(7, plan.getType());
		pstmt.setInt(8, plan.getPlanCode());
		if(pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}

	@Override
	public List<PlanProject> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = new ArrayList<PlanProject>();
		String sql = "Select * from PlanProject";
		pstmt = this.connection.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			PlanProject plan = new PlanProject();
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
			list.add(plan);
		}
		pstmt.close();
		return list;
	}

	@Override
	public PlanProject findByCode(int code) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Select * from PlanProject where PlanCode = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setInt(1, code);
		ResultSet result = pstmt.executeQuery();
		PlanProject plan = new PlanProject();
		if(result.next())
		{
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
		}
		pstmt.close();
		return plan;
	}

	@Override
	public List<PlanProject> findByDate(String date) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = new ArrayList<PlanProject>();
		String sql = "Select * from PlanProject where StartTime like ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, "%"+date+"%");
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			PlanProject plan = new PlanProject();
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
			list.add(plan);
		}
		pstmt.close();
		return list;
	}

	@Override
	public List<PlanProject> findByProject(String projectCode) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = new ArrayList<PlanProject>();
		String sql = "Select * from PlanProject where SubProjectCode = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, projectCode);
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			PlanProject plan = new PlanProject();
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
			list.add(plan);
		}
		pstmt.close();
		return list;
	}

	@Override
	public List<PlanProject> findByProjectAndDate(String projectCode,
			String date) throws Exception {
		List<PlanProject> list = new ArrayList<PlanProject>();
		String sql = "Select * from PlanProject where StartTime like ? and SubProjectCode = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, "%"+date+"%");
		pstmt.setString(2,projectCode);
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			PlanProject plan = new PlanProject();
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
			list.add(plan);
		}
		pstmt.close();
		return list;
	}

	@Override
	public int getMax() throws Exception {
		// TODO Auto-generated method stub
		int max = 0;
		String sql = "select max(p.PlanCode) from PlanProject p";
		pstmt = this.connection.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		if(result.next())
		{
			if(result.getInt(1)==0)
			{
				max = 1;
			}
			else
			{
				max = result.getInt(1);
			}
		}
		pstmt.close();
		return max;
	}

	@Override
	public List<PlanProject> findNotEnd(String endTime) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = new ArrayList<PlanProject>();
		String sql = "Select * from PlanProject where EndTime > ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1,endTime);
		//pstmt.setString(2,endTime);
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			PlanProject plan = new PlanProject();
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
			list.add(plan);
		}
		pstmt.close();
		return list;
	}

	@Override
	public List<PlanProject> findByPerson(String userCode) throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = new ArrayList<PlanProject>();
		String sql = "Select * from PlanProject where UserCode = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, userCode);
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			PlanProject plan = new PlanProject();
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
			list.add(plan);
		}
		pstmt.close();
		return list;
	}

	@Override
	public List<PlanProject> findByDateAndPerson(String date, String userCode)
			throws Exception {
		// TODO Auto-generated method stub
		List<PlanProject> list = new ArrayList<PlanProject>();
		String sql = "Select * from PlanProject where UserCode = ? and StartTime like ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, userCode);
		pstmt.setString(2,"%"+date+"%");
		ResultSet result = pstmt.executeQuery();
		while(result.next())
		{
			PlanProject plan = new PlanProject();
			plan.setPlanCode(result.getInt(1));
			plan.setUserCode(result.getString(2));
			plan.setUserName(result.getString(3));
			plan.setStartTime(result.getString(4));
			plan.setEndTime(result.getString(5));
			plan.setSubProjectCode(result.getString(6));
			plan.setSubProjectName(result.getString(7));
			plan.setType(result.getString(8));
			list.add(plan);
		}
		pstmt.close();
		return list;
	}

}
