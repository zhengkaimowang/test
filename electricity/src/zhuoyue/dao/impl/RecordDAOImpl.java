package zhuoyue.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import zhuoyue.vo.Record;
import zhuoyue.dao.IRecordDAO;

public class RecordDAOImpl implements IRecordDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	public RecordDAOImpl(Connection connection)
	{
		this.connection = connection;
	}
	@Override
	public int getCount(int name) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "select count(name) from syscolumns where id=object_id(?)";
		int count = 0;
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, tableName);
		ResultSet result = pstmt.executeQuery();
		if(result.next())
		{
			count = result.getInt(1);
		}
		pstmt.close();
		return count;
	}
	
	@Override
	public List<String> getParameterName(int name, int count) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "select * from [waibao].[dbo].["+tableName+"] where id = 0";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		List<String> list = new ArrayList<String>();
		int realCount = count-Record.COUNTBEHIND;
		int num = Record.COUNTFFRONT;
		if(result.next())
		{
			for(;num<realCount;num++)
			{
				list.add(result.getString(num+1));
			}
		}
		stmt.close();
		return list;
	}
	@Override
	public List<String> getStandard(int name, int count) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "select * from [waibao].[dbo].["+tableName+"] where id = 1";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		List<String>list = new ArrayList<String>();
		int realCount = count - Record.COUNTBEHIND;
		int num = Record.COUNTFFRONT;
		if(result.next())
		{
			for(;num<realCount;num++)
			{
				list.add(result.getString(num+1));
			}
		}
		stmt.close();
		return list;
	}
	@Override
	public List<Record> findAll(int name,int count) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "select * from [waibao].[dbo].["+tableName+"] where id != 1 and id !=0";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		int realCount = count - Record.COUNTBEHIND;
		int num = Record.COUNTFFRONT;
		List<Record> list = new ArrayList<Record>();
		while(result.next())
		{
			Record record = new Record();
			record.setId(result.getInt(1));
			record.setCode(result.getString(2));
			record.setDate(result.getString(3));
			record.setUserCode(result.getString(4));
			record.setUserName(result.getString(5));
			List<String> parameter = new ArrayList<String>();
			for(;num<realCount;num++)
			{
				parameter.add(result.getString(num+1));
			}
			record.setParameter(parameter);
			num = Record.COUNTFFRONT;
			record.setRemark(result.getString(realCount+1));
			record.setState(result.getInt(realCount+2));
			record.setPlanCode(result.getInt(realCount+3));
			list.add(record);
		}
		stmt.close();
		return list;
	}
	@Override
	public int getMax(int name) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		int max = 0;
		String sql = "select max(id) from [waibao].[dbo].["+tableName+"]";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		if(result.next())
		{
			max = result.getInt(1);
		}
		stmt.close();
		return max;
	}
	@Override
	public List<Record> findByKeyword(int name, int count, String key)
			throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "select * from [waibao].[dbo].["+tableName+"] where code = '"+key+"' or userCode = '"+key+"'";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		int realCount = count - Record.COUNTBEHIND;
		int num = Record.COUNTFFRONT;
		List<Record> list = new ArrayList<Record>();
		while(result.next())
		{
			Record record = new Record();
			record.setId(result.getInt(1));
			record.setCode(result.getString(2));
			record.setDate(result.getString(3));
			record.setUserCode(result.getString(4));
			record.setUserName(result.getString(5));
			List<String> parameter = new ArrayList<String>();
			for(;num<realCount;num++)
			{
				parameter.add(result.getString(num+1));
			}
			record.setParameter(parameter);
			num = Record.COUNTFFRONT;
			record.setRemark(result.getString(realCount+1));
			record.setState(result.getInt(realCount+2));
			record.setPlanCode(result.getInt(realCount+3));
			list.add(record);
		}
		stmt.close();
		return list;
	}
	@Override
	public Boolean doUpdateState(int name, int state, int id, String remark) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "update [waibao].[dbo].["+tableName+"] set state = '"+state+"', remark = '"+remark+"' where id = '"+String.valueOf(id)+"'";
		stmt = this.connection.createStatement();
		Boolean flag = false;
		if(stmt.executeUpdate(sql)>0)
		{
			flag = true;
		}
		stmt.close();
		return flag;
	}
	@Override
	public Record findByDateAndCode(int name, int count, String date,
			String code) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "select * from [waibao].[dbo].["+tableName+"] where code = '"+code+"' and date like '%"+date+"%'";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		Record record = new Record();
		List<String> parameter = new ArrayList<String>();
		int realCount = count - Record.COUNTBEHIND;
		int num = Record.COUNTFFRONT;
		if(result.next())
		{
			record.setId(result.getInt(1));
			record.setCode(result.getString(2));
			record.setDate(result.getString(3));
			record.setUserCode(result.getString(4));
			record.setUserName(result.getString(5));
			for(;num<realCount;num++)
			{
				parameter.add(result.getString(num+1));
			}
			record.setParameter(parameter);
			record.setRemark(result.getString(realCount+1));
			record.setState(result.getInt(realCount+2));
			record.setPlanCode(result.getInt(realCount+3));
		}
		stmt.close();
		return record;
	}
	@Override
	public Boolean doUpdateParameter(int name, int id, List<String> parameter,int count)
			throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		StringBuffer sql = new StringBuffer();
		sql.append("update [waibao].[dbo].["+tableName+"] set ");
		int realCount = count - Record.COUNTBEHIND-Record.COUNTFFRONT;
		int num = 1;
		for(;num<(realCount+1);num++)
		{
			String temp = "parameter"+String.valueOf(num)+" = '"+parameter.get(num-1)+"' ";
			sql.append(temp);
			if(num!=realCount)
			{
				sql.append(",");
			}
		}
		sql.append("where id = '"+String.valueOf(id)+"'");
		stmt = this.connection.createStatement();
		Boolean flag = false;
		if(stmt.executeUpdate(sql.toString())>0)
		{
			flag = true;
		}
		stmt.close();
		return flag;
	}
	@Override
	public Boolean doInsert(int name, int count, Record record)
			throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		StringBuffer sql = new StringBuffer();
		String temp = "INSERT INTO [waibao].[dbo].["+tableName+"](id,code,date,userCode,userName,";
		sql.append(temp);
		int realCount = count - Record.COUNTBEHIND-Record.COUNTFFRONT;
		int num = 1;
		for(;num<(realCount+1);num++)
		{
			temp = "parameter"+String.valueOf(num)+",";
			sql.append(temp);
		}
		temp = "remark,state,planCode) VALUES ("+record.getId()+",'"+record.getCode()+"','"+record.getDate()+"','"+record.getUserCode()+"','"+record.getUserName()+"','";
		sql.append(temp);
		num = 0;
		for(;num<realCount;num++)
		{
			temp = record.getParameter().get(num)+"','";
			sql.append(temp);
			
		}
		temp = record.getRemark()+"',"+record.getState()+","+record.getPlanCode()+")";
		sql.append(temp);
		Boolean flag = false;
		stmt = this.connection.createStatement();
		if(stmt.executeUpdate(sql.toString())>0)
		{
			flag = true;
		}
		stmt.close();
		return flag;
	}
	@Override
	public Boolean doCreateTable(int name, List<String> parameterName,
			List<String> standard) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String tableName = String.valueOf(name);
		int count = parameterName.size();
		StringBuffer sql = new StringBuffer();
		String temp = "USE [waibao] CREATE TABLE [dbo].["+tableName+"]([id] [int] PRIMARY KEY NOT NULL,[code] [varchar](20) NOT NULL,[date] [varchar](20) NOT NULL,[userCode] [varchar](4) NOT NULL,[userName] [varchar](10) NOT NULL,";
		sql.append(temp);
		int num = 1;
		for(;num<count+1;num++)
		{
			temp = "[parameter"+String.valueOf(num)+"] [varchar] (500) NULL ,";
			sql.append(temp);
		}
		temp = "[remark] [text] NULL,[state] [int] NOT NULL DEFAULT ((0)),[planCode] [int] NULL)";
		sql.append(temp);
		stmt = this.connection.createStatement();
		stmt.execute(sql.toString());
		Record record = new Record();
		record.setId(0);
		record.setCode("*0000");
		record.setDate("000");
		record.setUserCode("*000");
		record.setUserName("*0000");
		ArrayList<String> tempList = new ArrayList<String>();
		num = 0;
		for(;num<count;num++)
		{
			tempList.add(parameterName.get(num));
		}
		record.setParameter(tempList);
		record.setRemark("±£Áô¼ÇÂ¼");
		record.setState(0);
		record.setPlanCode(0);
		flag = this.doInsert(name, count+Record.COUNTBEHIND+Record.COUNTFFRONT, record);
		record.setId(1);
		record.setCode("*1111");
		record.setDate("111");
		record.setUserCode("*111");
		record.setUserName("*1111");
		num = 0;
		ArrayList<String>tempList2 = new ArrayList<String>();
		for(;num<count;num++)
		{
			tempList2.add(standard.get(num));
		}
		record.setParameter(tempList2);
		flag = this.doInsert(name, count+Record.COUNTBEHIND+Record.COUNTFFRONT, record);
		stmt.close();
		return flag;
	}
	@Override
	public Record findByPlanAndCode(int name, int count, int planCode,
			String code) throws Exception {
		// TODO Auto-generated method stub
		String tableName = String.valueOf(name);
		String sql = "select * from [waibao].[dbo].["+tableName+"] where code = '"+code+"' and planCode = "+planCode+"";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		Record record = new Record();
		List<String> parameter = new ArrayList<String>();
		int realCount = count - Record.COUNTBEHIND;
		int num = Record.COUNTFFRONT;
		if(result.next())
		{
			record.setId(result.getInt(1));
			record.setCode(result.getString(2));
			record.setDate(result.getString(3));
			record.setUserCode(result.getString(4));
			record.setUserName(result.getString(5));
			for(;num<realCount;num++)
			{
				parameter.add(result.getString(num+1));
			}
			record.setParameter(parameter);
			record.setRemark(result.getString(realCount+1));
			record.setState(result.getInt(realCount+2));
			record.setPlanCode(result.getInt(realCount+3));
		}
		stmt.close();
		return record;
	}
	@Override
	public int findProblemByDateAndParameter(int name,String date,
			int parameter) throws Exception {
		// TODO Auto-generated method stub
		int num = 0;
		String tableName = String.valueOf(name);
		String sql = "select count(id) from [waibao].[dbo].["+tableName+"]  where date like '%"+date+"%' and parameter"+String.valueOf(parameter)+" ='¹ÊÕÏ'";
		stmt = this.connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		if(result.next())
		{
			num = result.getInt(1);
		}
		stmt.close();
		return num;
	}
}
