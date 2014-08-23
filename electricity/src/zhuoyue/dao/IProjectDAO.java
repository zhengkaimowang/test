package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.Project;

public interface IProjectDAO {
	public List<Project> findProject() throws Exception; // 查找主项目

	public List<Project> findSubProject(String code) throws Exception;// 查找子项目

	public boolean doInsertProject(String name) throws Exception; // 添加项目

	public boolean doInsertSubproject(String name,String subcode) throws Exception;// 添加子项目

	public boolean doRemoveproject(String code) throws Exception;// 删除项目
	
	public boolean doDeleterBySuperProject(String superProject) throws Exception;//根据父项目删除项目

	public Project findProjectByCode(String code) throws Exception;//根据代码查找项目
}
