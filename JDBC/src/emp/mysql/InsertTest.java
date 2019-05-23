package emp.mysql;

import java.sql.*;

public class InsertTest {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "scott";
		String pass = "tiger";
		Connection con = null; // 선언은 멤버변수로 한번 해주기 나중에 nullpoint exception 발생
		
		try {
			// 1. 드라이버를 메모리 로딩
			Class.forName(driver); // oracle.jdbc.OracleDriver 를 driver로 사용 메모리에 올린다.
			//2. 연결 객체 얻어오기
			 con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공");
		} catch (Exception ex) {
			System.out.println("연결 실패 :" + ex.getMessage());
		}
		
		//3. SQL 문장 만들기
		//4. SQL 전송객체 만들기
		//5. 전송하기
		//6. 닫기
		try {
				// 방금 입력한 사원정보에서 이름은 알아서 연봉은 60000달라로 변경
				String sql = "INSERT INTO temp(ename,mgr,sal,deptno)"
						+ "VALUES('아무개',3456,12000,30)";
//				String sql = "UPDATE emp SET sal = 60000 WHERE empno='1234'";
				System.out.println(sql); // 항상 sql 문장 만든후 자바에서 실행 해보기 
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
				con.close();
				System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}
		
	}

}