package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.PlanProject;

public interface IPlanProjectDAO 
{
	public List<PlanProject> findNotEnd(String endTime) throws Exception;//�ҳ�δ�����ļƻ�
	public List<PlanProject> findAll() throws Exception;//�ҳ�ȫ���ƻ�,�ɹ�
	public List<PlanProject> findByDate(String date) throws Exception;//���������ҳ�ȫ���ƻ�,�ɹ�
	public List<PlanProject> findByDateAndPerson(String date,String userCode) throws Exception;//���������ҳ�ȫ���ƻ�,�ɹ�
	public List<PlanProject> findByPerson(String userCode) throws Exception;//�����û����� �ҳ�ȫ���ƻ�
	public List<PlanProject> findByProject(String projectCode) throws Exception;//������Ŀ�ҳ�ȫ���ƻ�,�ɹ�
	public List<PlanProject> findByProjectAndDate(String projectCode,String date) throws Exception;//�������ں���Ŀ�ҳ�ȫ���ƻ�,�ɹ�
	public PlanProject findByCode(int code) throws Exception;//���ݱ���ҳ�����ƻ�,�ɹ�
	public Boolean doInsert(PlanProject plan) throws Exception;//���ɼƻ�,�ɹ�
	public Boolean doUpdate(PlanProject plan) throws Exception;//�޸ļƻ����ɹ�
	public int getMax() throws Exception;//��ȡ���CODE���ɹ�
}
