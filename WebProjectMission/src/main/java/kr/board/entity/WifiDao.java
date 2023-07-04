package kr.board.entity;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;

import kr.board.mapper.BoardMapper;
import lombok.Data;
@Data
public class WifiDao {
	
	private double distance; 
	private double distance2;
	private String mgrNo;
	private String wrdOfc; 
	private String mainNm;
	private String adres1; 
	private String adres2; 
	private String instlFloor; 
	private String instlTy; 
	private String instlMby; 
	private String svcSe; 
	private String cmcwr;
	private int cnstcYear; 
	private String inoutDoor;
	private String remars3; 
	private double lat; 
	private double lnt; 
	private String workDttm;
	
	
	
	/*
	jdbc.driver=com.mysql.cj.jdbc.Driver
			jdbc.url=jdbc:mysql://localhost:3306/com?serverTimezone=UTC
			jdbc.user=com
			jdbc.password=com01
		*/	
	
	/*
	public void wifiInsert(WifiVo vo) throws SQLException, ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
		} catch (ClassNotFoundException e) {
			System.out.println(" 오류1: ClassNotFoundException");
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement stat = null;
	//	 
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection conn;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/com", "com", "com01");
		Statement stmt = conn.createStatement() ;
		String query = "select * from wifi_info ;" ;
		ResultSet rs = stmt.executeQuery(query) ;
		// 

//		conn = DriverManager.getConnection(Db.URL);
//		String sql = "insert into wifi_info values(?);";
//		stat = conn.prepareStatement(sql);
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/com", "com", "com01");
			String sql = "select * from wifi_info;" ;
			stat = conn.prepareStatement(sql);
			
		} catch (Exception e) {
			System.out.println(" 오류2: ");
			e.printStackTrace();
		}
		conn.close();
		
	}
*/
}
