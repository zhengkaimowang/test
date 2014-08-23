package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.EquipmentType;

public interface IEquipmentTypeDAO 
{
	public Boolean doCreate(EquipmentType type) throws Exception; //��������
	public Boolean doDelete(String code) throws Exception;//�������ʹ���ɾ������
	public EquipmentType findByCodeOrName(String key) throws Exception;//�������ʹ����ҳ�����
	public List<EquipmentType> findAll() throws Exception;//�ҳ�ȫ������
	public int findMax() throws Exception;//�ҳ����ID
}
