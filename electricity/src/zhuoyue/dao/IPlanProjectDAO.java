package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.PlanProject;

public interface IPlanProjectDAO 
{
	public List<PlanProject> findNotEnd(String endTime) throws Exception;//找出未结束的计划
	public List<PlanProject> findAll() throws Exception;//找出全部计划,成功
	public List<PlanProject> findByDate(String date) throws Exception;//根据日期找出全部计划,成功
	public List<PlanProject> findByDateAndPerson(String date,String userCode) throws Exception;//根据日期找出全部计划,成功
	public List<PlanProject> findByPerson(String userCode) throws Exception;//根据用户代号 找出全部计划
	public List<PlanProject> findByProject(String projectCode) throws Exception;//根据项目找出全部计划,成功
	public List<PlanProject> findByProjectAndDate(String projectCode,String date) throws Exception;//根据日期和项目找出全部计划,成功
	public PlanProject findByCode(int code) throws Exception;//根据编号找出具体计划,成功
	public Boolean doInsert(PlanProject plan) throws Exception;//生成计划,成功
	public Boolean doUpdate(PlanProject plan) throws Exception;//修改计划，成功
	public int getMax() throws Exception;//获取最大CODE，成功
}
