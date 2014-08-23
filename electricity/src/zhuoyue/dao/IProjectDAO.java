package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.Project;

public interface IProjectDAO {
	public List<Project> findProject() throws Exception; // ��������Ŀ

	public List<Project> findSubProject(String code) throws Exception;// ��������Ŀ

	public boolean doInsertProject(String name) throws Exception; // �����Ŀ

	public boolean doInsertSubproject(String name,String subcode) throws Exception;// �������Ŀ

	public boolean doRemoveproject(String code) throws Exception;// ɾ����Ŀ
	
	public boolean doDeleterBySuperProject(String superProject) throws Exception;//���ݸ���Ŀɾ����Ŀ

	public Project findProjectByCode(String code) throws Exception;//���ݴ��������Ŀ
}
