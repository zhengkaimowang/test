package zhuoyue.factory;

import zhuoyue.dao.IEquipmentDAO;
import zhuoyue.dao.IEquipmentTypeDAO;
import zhuoyue.dao.IPlanProjectDAO;
import zhuoyue.dao.IProblemDAO;
import zhuoyue.dao.IProjectDAO;
import zhuoyue.dao.IRecordDAO;
import zhuoyue.dao.IUserinfoDAO;
import zhuoyue.dao.proxy.EquipmentDAOProxy;
import zhuoyue.dao.proxy.EquipmentTypeDAOProxy;
import zhuoyue.dao.proxy.PlanProjectDAOProxy;
import zhuoyue.dao.proxy.ProblemDAOProxy;
import zhuoyue.dao.proxy.ProjectDAOProxy;
import zhuoyue.dao.proxy.RecordDAOProxy;
import zhuoyue.dao.proxy.UserinfoDAOProxy;
import zhuoyue.dao.IDeptDAO;
import zhuoyue.dao.proxy.DeptDAOProxy;
public class DAOFactory {
	public static IUserinfoDAO getIUserinfoDAOInstance()throws Exception
	{
		return new UserinfoDAOProxy();
	}
	public static IDeptDAO getDeptDAO()
	{
		return new DeptDAOProxy();
	}
	public static IEquipmentTypeDAO getIEquipmentTypeDAOInstance() throws Exception
	{
		return new EquipmentTypeDAOProxy();
	}
	public static IRecordDAO getIRecordDAOInstance() throws Exception
	{
		return new RecordDAOProxy();
	}
	public static IEquipmentDAO getEquipmentDAO(){
		return new  EquipmentDAOProxy();
	}
	public static IProblemDAO getProblemDAO(){
		return new ProblemDAOProxy();
	}
	public static IProjectDAO getProjectDAO(){
		return new ProjectDAOProxy();
	}
	public static IPlanProjectDAO getPlanProjectDAO(){
		return new PlanProjectDAOProxy();
	}
}
