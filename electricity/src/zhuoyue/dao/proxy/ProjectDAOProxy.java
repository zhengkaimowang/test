package zhuoyue.dao.proxy;

import java.sql.Connection;
import java.util.List;

import zhuoyue.dao.IProjectDAO;
import zhuoyue.dao.impl.ProjectDAOmpml;
import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.vo.Project;

public class ProjectDAOProxy implements IProjectDAO {
	ProjectDAOmpml impl = null;
	DatabaseConnection dbc = null;
	
	public ProjectDAOProxy(){
		try {
			this.dbc = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.impl = new ProjectDAOmpml(this.dbc.getConnection());
	}
	@Override
	public boolean doInsertProject(String name) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = this.impl.doInsertProject(name);
		this.dbc.close();
		return flag;
	}

	@Override
	public boolean doInsertSubproject(String name, String subcode)
			throws Exception {
		// TODO Auto-generated method stub
		boolean flag = this.impl.doInsertSubproject(name, subcode);
		this.dbc.close();
		return flag;
	}

	@Override
	public boolean doRemoveproject(String code) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = this.impl.doRemoveproject(code);
		this.dbc.close();
		return flag;
	}

	@Override
	public List<Project> findProject() throws Exception {
		// TODO Auto-generated method stub
		List<Project> all = this.impl.findProject();
		this.dbc.close();
		return all;
	}

	@Override
	public List<Project> findSubProject(String code) throws Exception {
		// TODO Auto-generated method stub
		List<Project> all = this.impl.findSubProject(code);
		this.dbc.close();
		return all;
	}
	@Override
	public boolean doDeleterBySuperProject(String superProject)
			throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = this.impl.doDeleterBySuperProject(superProject);
		this.dbc.close();
		return flag;
	}
	@Override
	public Project findProjectByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		Project project = null;
		project = this.impl.findProjectByCode(code);
		this.dbc.close();
		return project;
	}

}
