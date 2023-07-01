package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex03_Delete {
	public static void main(String[] args)  {
		String sql = "delete product where idx = %s";
		sql = String.format(sql, 6);
		
		String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
		String user = "c##itbank";
		String password = "it";
		
		Connection conn = null;
		Statement stmt = null;
		int row = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속하기 위해 필요한것
			
			
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			row = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 불러오는 데 실패했습니다.");
		} catch (SQLException e) {
			System.out.println("SQL 예외 발생 :" + e);
		} finally {
			try {if (stmt != null) stmt.close();} catch (Exception e) {}
			try {if (conn != null) conn.close();} catch (Exception e) {}

		}
		System.out.printf("%d 행이 (가) 삭제되었습니다.\n", row);

	}

}
