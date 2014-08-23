package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.Problem;

public interface IProblemDAO {
	public List<Problem> findAll() throws Exception; // �ҵ����м�¼
	public List<Problem> findByType(String type) throws Exception;// �������Ͳ���
	public List<Problem> findByState(String state) throws Exception;// ���ݴ���״̬����
	public List<Problem> findByStateAndType(String state,String type) throws Exception;
	public boolean doInsert(Problem pro) throws Exception;// ����
	public int findRecordByCodeAndDate(String code,String date) throws Exception;//�������ں��������ҳ����ϴ���
	public List<Problem> findByDate(String date) throws Exception;
}
