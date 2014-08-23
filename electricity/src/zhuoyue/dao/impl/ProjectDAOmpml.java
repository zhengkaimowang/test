package zhuoyue.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IProjectDAO;
import zhuoyue.vo.Project;

public class ProjectDAOmpml implements IProjectDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	public ProjectDAOmpml(Connection conn){
		this.conn = conn ;
	}
	@Override
	public boolean doInsertProject(String name)  throws Exception{
		// TODO Auto-generated method stub
		int flag = 0 ;
		String pcode = null;
		ResultSet re = null;
		String max = "SELECT MAX(ProjectCode) FROM Project WHERE SuperCode='*'";
		this.pstmt = this.conn.prepareStatement(max);
		re = this.pstmt.executeQuery();
		while(re.next()){
			pcode = new Integer((Integer.parseInt(re.getString(1))+1)).toString();
		}
		String sql = "INSERT INTO Project (ProjectCode,SuperCode,Name) VALUES(?,'*',?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, pcode);
		this.pstmt.setString(2, name);
		flag = this.pstmt.executeUpdate();
		if (flag !=0){
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public boolean doInsertSubproject(String name,String subcode)  throws Exception{
		// TODO Auto-generated method stub
		int flag = 0 ;
		String pcode = null;
		ResultSet re = null;
		String max = "SELECT MAX(ProjectCode) FROM Project WHERE SuperCode=?";
		this.pstmt = this.conn.prepareStatement(max);
		this.pstmt.setString(1, subcode);
		re = this.pstmt.executeQuery();
		if(re.next()){
			if(re.getString(1)!=null)
			{
				pcode = new Integer((Integer.parseInt(re.getString(1))+1)).toString();
			}
			else
			{
				pcode = new Integer((Integer.parseInt(subcode)*10+1)).toString();
			}
		}
		
		String sql = "INSERT INTO Project (ProjectCode,SuperCode,Name) VALUES (?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, pcode);
		this.pstmt.setString(2, subcode);
		this.pstmt.setString(3, name);
		flag = this.pstmt.executeUpdate();
		if (flag !=0){
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}


	@Override
	public boolean doRemoveproject(String code)  throws Exception{
		int flag = 0 ;
		String sql = "DELETE FROM Project WHERE ProjectCode=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, code);
		flag = this.pstmt.executeUpdate();
		if (flag !=0){
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}

	@Override
	public List<Project> findProject() throws Exception {
		List<Project> all = new ArrayList<Project>();
		String sql = "SELECT * FROM Project WHERE SuperCode='*'";
		ResultSet re = null;
		this.pstmt = this.conn.prepareStatement(sql);
		re = this.pstmt.executeQuery();
		Project project = null;
		while (re.next()){
			project = new Project();
			project.setProjectCode(re.getString(1));
			project.setSuperCode(re.getString(2));
			project.setName(re.getString(3));
			all.add(project);
		}
		return all;
	}

	@Override
	public List<Project> findSubProject(String code)  throws Exception{
		// TODO Auto-generated method stub
		List<Project> all = new ArrayList<Project>();
		String sql = "SELECT * FROM Project WHERE SuperCode=?";
		ResultSet re = null;
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, code);
		re = this.pstmt.executeQuery();
		Project project = null;
		while (re.next()){
			project = new Project();
			project.setProjectCode(re.getString(1));
			project.setSuperCode(re.getString(2));
			project.setName(re.getString(3));
			all.add(project);
		}
		return all;
	}
	@Override
	public boolean doDeleterBySuperProject(String superProject)
			throws Exception {
		// TODO Auto-generated method stub
		int flag = 0 ;
		String sql = "DELETE FROM Project WHERE SuperCode=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, superProject);
		flag = this.pstmt.executeUpdate();
		if (flag !=0){
			this.pstmt.close();
			return true;
		}
		this.pstmt.close();
		return false;
	}
	@Override
	public Project findProjectByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		Project project = new Project();
		String sql = "select * from Project where ProjectCode = ?";
		pstmt = this.conn.prepareStatement(sql);
		pstmt.setString(1, code);
		ResultSet result = pstmt.executeQuery();
		if(result.next())
		{
			project.setProjectCode(result.getString(1));
			project.setSuperCode(result.getString(2));
			project.setName(result.getString(3));
		}
		this.pstmt.close();
		return project;
	}

}
