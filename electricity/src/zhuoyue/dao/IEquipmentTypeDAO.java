package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.EquipmentType;

public interface IEquipmentTypeDAO 
{
	public Boolean doCreate(EquipmentType type) throws Exception; //增加类型
	public Boolean doDelete(String code) throws Exception;//根据类型代码删除类型
	public EquipmentType findByCodeOrName(String key) throws Exception;//根据类型代号找出数据
	public List<EquipmentType> findAll() throws Exception;//找出全部数据
	public int findMax() throws Exception;//找出最大ID
}
