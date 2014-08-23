package zhuoyue.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseConnection 
{
	private Connection connection = null;
//	private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	private static final String DBURL = "jdbc:sqlserver://localhost:1433; DatabaseName=waibao";
//	private static final String DBUSER = "sa";
//	private static final String DBPASS = "zhuoyue";
	private static final String DSNAME = "java:comp/env/jdbc/zhuoyue";
	public DatabaseConnection() throws Exception
	{
//		Class.forName(DBDRIVER);
//		this.connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup(DSNAME);
		this.connection = ds.getConnection();
	}
	public Connection getConnection()
	{
		return this.connection;
	}
	public void close() throws Exception
	{
		if(this.connection != null)
		{
			this.connection.close();
		}
	}
}
