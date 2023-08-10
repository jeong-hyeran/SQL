package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	public MovieDAO() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 불러오지 못 했습니다. :" + e);
		}
	}
	
	public ArrayList<MovieDTO> selectList() {
		ArrayList<MovieDTO> list = new ArrayList<>();
		String sql = "select * from movie2";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MovieDTO dto = new MovieDTO();
		
				dto.setMovie_rank(rs.getInt("movie_rank"));
				dto.setTitle(rs.getString("title"));
				dto.setOpenningdate(rs.getString("openningdate"));
				dto.setReserveRate(rs.getDouble("reserveRate"));
				dto.setReserveCount(rs.getInt("reserveCount"));
				dto.setWatchCount(rs.getInt("watchCount"));
		
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		
		return list;
	}
}
