package zhuoyue.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhuoyue.dao.IEquipmentTypeDAO;
import zhuoyue.vo.EquipmentType;

public class EquipmentTypeDAOImpl implements IEquipmentTypeDAO {
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	public EquipmentTypeDAOImpl(Connection connection)
	{
		this.connection = connection;
	}
	@Override
	public Boolean doCreate(EquipmentType type) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "Insert into EquipmentType(TypeCode,TypeName,TableName,Describe) values (?,?,?,?)";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1,type.getTypeCode());
		pstmt.setString(2,type.getTypeName());
		pstmt.setInt(3,type.getTableName());
		pstmt.setString(4,type.getDescribe());
		if(pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}

	@Override
	public Boolean doDelete(String code) throws Exception {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String sql = "Delete from EquipmentType where TypeCode = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, code);
		if(pstmt.executeUpdate()>0)
		{
			flag = true;
		}
		pstmt.close();
		return flag;
	}

	@Override
	public List<EquipmentType> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from EquipmentType";
		pstmt = this.connection.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		List<EquipmentType> list = new ArrayList<EquipmentType>();
		while(result.next())
		{
			EquipmentType type = new EquipmentType();
			type.setTypeCode(result.getString(1));
			type.setTypeName(result.getString(2));
			type.setTableName(result.getInt(3));
			type.setDescribe(result.getString(4));
			list.add(type);
		}
		this.pstmt.close();
		return list;
	}

	@Override
	public EquipmentType findByCodeOrName(String key) throws Exception {
		// TODO Auto-generated method stub
		EquipmentType type = new EquipmentType();
		String sql = "select * from EquipmentType where TypeCode = ? or TypeName = ?";
		pstmt = this.connection.prepareStatement(sql);
		pstmt.setString(1, key);
		pstmt.setString(2, key);
		ResultSet result = pstmt.executeQuery();
		if(result.next())
		{
			type.setTypeCode(result.getString(1));
			type.setTypeName(result.getString(2));
			type.setTableName(result.getInt(3));
			type.setDescribe(result.getString(4));
		}
		this.pstmt.close();
		return type;
	}
	@Override
	public int findMax() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select max(TableName) from EquipmentType";
		pstmt = this.connection.prepareStatement(sql);
		ResultSet result = pstmt.executeQuery();
		int max = 0;
		if(result.next())
		{
			max = result.getInt(1);
		}
		this.pstmt.close();
		return max;
	}

}
