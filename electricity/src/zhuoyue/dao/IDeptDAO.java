package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.Dept;

public interface IDeptDAO {

	public boolean doInsert(Dept dept) throws Exception; // ���ű�����

	public boolean doRemove(Dept dept) throws Exception; // ���ű�ɾ��

	public boolean doUpdate(Dept dept) throws Exception;// ���ű��޸�

	public List<Dept> findAll() throws Exception;// �ҵ����в���
}
