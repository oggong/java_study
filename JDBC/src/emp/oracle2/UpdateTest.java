package emp.oracle2;

import java.sql.*;

public class UpdateTest {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.170:1521:orcl";
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
		
		try {
			//3. SQL 문장 만들기
				// 화면에서 입력값 얻어오기 	
				// 화면에서 입력한 값을 얻어와서 셋팅 
				int empno = 6789;
				String ename = "홍숙자";
				int sal = 12000;
				int deptno = 20;
				String job = "개발";
													//preparedstatement
				
				// 6789 사번의 사원정보를 변경
				String sql = " UPDATE emp SET ename= ?,sal= ?,deptno= ?,job= ?   "
						+ "WHERE empno = ? ";
				
				
				// 항상 sql 문장 만든후 자바에서 실행 해보기 
				System.out.println(sql); 
				
				//4. SQL 전송객체 만들기
				PreparedStatement st = con.prepareStatement(sql); 
				// 미완성된 sql 불러오기  == (VALUES ?,?,?,?,?)
				
				// SQL을 가져온 이후 물음표 순서대로  세팅 해주기 
				st.setString(1, ename);
				st.setInt(2, sal);
				st.setInt(3, deptno);
				st.setString(4, job);
				st.setInt(5, empno);
				
				//5. 전송하기
				int result = st.executeUpdate(); // -- sql 전송하면 안됨
				
				//6. 닫기
				st.close();
				con.close();

				System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}
		
	}

}
