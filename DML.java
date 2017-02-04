package DataPhiLabs.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DML 
{
	public static int generateID(String table, String col)
	{
		Connection con = null;
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try
		{
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select max(" + col + ") from " + table);
			
			if(rs.next())
			{
				return rs.getInt(1) + 1;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeConnections(rs, stmt, con);
		}

		return 1;
	}
}
