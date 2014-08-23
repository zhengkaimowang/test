package zhuoyue.dao;

import java.sql.ResultSet;
import java.util.List;

import zhuoyue.vo.Equipment;

public interface IEquipmentDAO {
	public List<Equipment> findAll(String type) throws Exception; // 查找所有数据
	public boolean doRemove(String code) throws Exception; // 删除设备
	public boolean doDeleteByProject(String project) throws Exception; //根据主项目删除设备
	public boolean doDeleteBySubProject(String subProject) throws Exception;//根据子项目删除设
	public List<Equipment> findByProject(String project) throws Exception;// 根据项目查找
	public List<Equipment> findBySubPro(String subproject) throws Exception;// 根据子项目查找
	public boolean doInsert(Equipment eq) throws Exception;// 添加设备到子项目
	public Equipment findByCode(String code) throws Exception;
}
