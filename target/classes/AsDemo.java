package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.imooc.dbutil.DBAccess;
import com.mysql.jdbc.ResultSetMetaData;

/**
 * 测试结果集元数据与多表关联
 * @author zjh
 *
 */
public class AsDemo {
	
	public void Text() {
		// 加载mysql主类驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn
			= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Micro?useUnicode=true&characterEncoding=UTF8"
					,"root"
					"root"
					);
		// 测试关联查询 从结果集元数据中取出字段	
		String sql = "SELECT * from command_content a LEFT JOIN command b "
				+ "on a.command_id = b.id "
				+ "GROUP BY a.id "
				+ "HAVING a.command_id = 2 "
		
		// 发送数据
		PreparedStatement ps 
			= conn.prepareStatement(sql);
		// 接收结果集
		ResultSet rs = ps.executeQuery();
		
		// 查询结果集元数据中保存的 id字段
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println(rsmd.getColumnName("id"));
		
		
		
	}
	
	
}
