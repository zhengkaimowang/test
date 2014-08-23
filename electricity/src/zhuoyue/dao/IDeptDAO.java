package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.Dept;

public interface IDeptDAO {

	public boolean doInsert(Dept dept) throws Exception; // 部门表增加

	public boolean doRemove(Dept dept) throws Exception; // 部门表删除

	public boolean doUpdate(Dept dept) throws Exception;// 部门表修改

	public List<Dept> findAll() throws Exception;// 找到所有部门
}
