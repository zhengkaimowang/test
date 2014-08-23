package zhuoyue.dao;

import java.util.List;

import zhuoyue.vo.Problem;

public interface IProblemDAO {
	public List<Problem> findAll() throws Exception; // 找到所有记录
	public List<Problem> findByType(String type) throws Exception;// 根据类型查找
	public List<Problem> findByState(String state) throws Exception;// 根据处理状态查找
	public List<Problem> findByStateAndType(String state,String type) throws Exception;
	public boolean doInsert(Problem pro) throws Exception;// 增加
	public int findRecordByCodeAndDate(String code,String date) throws Exception;//根据日期和条形码找出故障次数
	public List<Problem> findByDate(String date) throws Exception;
}
