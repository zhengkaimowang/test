package zhuoyue.dao;

import java.util.List;
import zhuoyue.vo.Record;

public interface IRecordDAO 
{
	public Record findByPlanAndCode(int name,int count,int planCode,String code) throws Exception; //根据计划代号与条形码找出记录
	public int getCount(int name) throws Exception;//根据表名获取该表的字段个数,成功
	public List<String> getParameterName(int name,int count) throws Exception;//根据表名与字段个数获取参数名字，成功
	public List<String> getStandard(int name,int count) throws Exception;//根据表名与字段个数获取标准值，成功
	public List<Record> findAll(int name,int count) throws Exception;//根据表名，获取全部对象 成功 ?
	public int getMax(int name) throws Exception;//根据表名获取最大ID 成功
	public List<Record> findByKeyword(int name,int count,String key) throws Exception;//根据条形码或操作人代号找出记录,成功?
	public Boolean doUpdateState(int name,int state,int id,String remark) throws Exception;//根据表名，id修改记录 状态与备注,成功
	public Record findByDateAndCode(int name,int count,String date,String code) throws Exception;//找出单条记录,成功?
	public Boolean doUpdateParameter(int name,int id,List<String> parameter,int count) throws Exception;//修改参数,成功
	public Boolean doInsert(int name,int count,Record record) throws Exception;//插入一条记录,成功?
	public Boolean doCreateTable(int name,List<String>parameterName,List<String>standard) throws Exception;//创建表,成功?
	public int findProblemByDateAndParameter(int name,String date,int parameter) throws Exception;
}
