package zhuoyue.dao;

import java.sql.ResultSet;
import java.util.List;

import zhuoyue.vo.Equipment;

public interface IEquipmentDAO {
	public List<Equipment> findAll(String type) throws Exception; // ������������
	public boolean doRemove(String code) throws Exception; // ɾ���豸
	public boolean doDeleteByProject(String project) throws Exception; //��������Ŀɾ���豸
	public boolean doDeleteBySubProject(String subProject) throws Exception;//��������Ŀɾ����
	public List<Equipment> findByProject(String project) throws Exception;// ������Ŀ����
	public List<Equipment> findBySubPro(String subproject) throws Exception;// ��������Ŀ����
	public boolean doInsert(Equipment eq) throws Exception;// ����豸������Ŀ
	public Equipment findByCode(String code) throws Exception;
}
