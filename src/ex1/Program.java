package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "JDBC", "admin");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) { // 레코드 하나 가져온다.
			String title = rs.getString("TITLE"); // 선언한 컬럼의 값을 가져온다.
			System.out.printf("TITLE : %s\n", title);
		}
		
		rs.close();
		st.close();
		con.close();
	}

}

/*
 1. 드라이버 로드하기
 2. 연결 생성하기
 3. 문장 실행하기
 4. 결과집합 사용하기 
*/
 