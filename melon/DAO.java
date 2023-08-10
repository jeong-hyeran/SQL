package melon;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	public DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("클래스를 불러오지 못했습니다 : "  + e );
		}
	}
	
	public ArrayList<DTO> selectList() {
		ArrayList<DTO> list = new ArrayList<DTO>();
		String sql = "select * from melon";
		try {
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				DTO dto = new DTO();
				/*
				RANKING      NUMBER        
				TITLE        VARCHAR2(100) 
				ARTIST       VARCHAR2(100) 
				ALBUM        VARCHAR2(100) 
				LIKECOUNT    NUMBER        
				*/
				dto.setRanking(rs.getInt("ranking"));
				dto.setTitle(rs.getString("title"));
				dto.setArtist(rs.getString("artist"));
				dto.setAlbum(rs.getString("album"));
				dto.setLikeCount(rs.getInt("likeCount"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch (Exception e) {}
			
		}
		
		
		
		return list;
		
	}
	
}
