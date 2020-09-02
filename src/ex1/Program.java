package ex1;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "JDBC", "admin");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) { // 레코드 하나 가져온다.
			int id = rs.getInt("ID");
			String title = rs.getNString("TITLE");
			String writerID = rs.getNString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getNString("FILES");
			
//			if(hit >= 10) {
//				System.out.printf("ID : %d\n", id);
//				System.out.printf("TITLE : %s\n", title);
//				System.out.printf("WRITER_ID : %s\n", writerID);
//				System.out.printf("REGDATE : %s\n", regDate);
//				System.out.printf("CONTENT : %s\n", content);
//				System.out.printf("HIT : %d\n", hit);
//				System.out.printf("FILES : %s\n", files);
//				System.out.println("----------------------------");
//			} 이것보다 sql문을 이용해 미리 거르는게 훨씬 효율적이다! 
//			데이터 필터링, 정렬, 그룹화 등의 모든 데이터 연산은 데이터베이스에서 처리한다.
//			JAVA는 UI레이아웃만, 데이터 가공처리는 SQL이
			
			System.out.printf("ID : %d\n", id);
			System.out.printf("TITLE : %s\n", title);
			System.out.printf("WRITER_ID : %s\n", writerID);
			System.out.printf("REGDATE : %s\n", regDate);
			System.out.printf("CONTENT : %s\n", content);
			System.out.printf("HIT : %d\n", hit);
			System.out.printf("FILES : %s\n", files);
			System.out.println("----------------------------");
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

/*
	트랜잭션이란? -> 하나의 단위로 수행되길 바라는 쿼리의 묶음(=업무 수행단위, 논리적인 수행단위)
	트랜잭션 처리란? -> ACID
	A : Atomicity (원자성) -> 논리적 수행단위가 깨지면 안된다.
	C : Consistency(일관성) -> 데이터의 결함이 발생하면 안된다.
	I : ISolation(고립성) -> 한 사람이 작업을 할 경우 다른 사용자가 그 작업을 침해하면 안된다.
	D : Durability(지속성) -> 데이터 변경된 것이 완전히 그 내용이 데이터베이스에 적용되어야한다.

+) MySql은 알아서 자동 트랜잭션 처리를 해준다.(따로 처리할 필요가 없다.)
 */
 