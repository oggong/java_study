package emp.oracle2;

import java.sql.*;

public class SelectTest {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.170:1521:orcl";
		String user = "scott";
		String pass = "tiger";
		Connection con = null; // 선언은 멤버변수로 한번 해주기 나중에 nullpoint exception 발생

		try {
			// 1. 드라이버를 메모리 로딩
			Class.forName(driver); // oracle.jdbc.OracleDriver 를 driver로 사용 메모리에 올린다.
			// 2. 연결 객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공");
		} catch (Exception ex) {
			System.out.println("연결 실패 :" + ex.getMessage());
		}

		try {
//			String sql = "SELECT *FROM emp ORDER BY sal DESC";

//			int empno = 7788;
//			// 7788 에 해당하는 record 를 가져옴 
//			// 처음엔 바로 가리키지 않고 그위를 읽어옴 . next 를 써줘야 7788 레코드를 가져옴 
//			
//			String sql = "SELECT *FROM emp WHERE empno=?";
//			
//			PreparedStatement st = con.prepareStatement(sql);
//			
//			st.setInt(1,empno);
//			
//			ResultSet rs = st.executeQuery(sql);
//			
//			// 하나를 쓰더라도 next 를 사용하여 7788을 가져와야 함.
//			while(rs.next()) {
//				System.out.println(rs.getInt("EMPNO")+"/" // getInt("EMPNO") 컬럼명 넣어줘야 한다. 가독성을 높히기위해 대문자 이용 선호
//						+rs.getString("ENAME")+ "/" +rs.getInt("SAL")); 
//			st.close();
//			con.close();			

			// 사원 테이블의 총 사원수와 월급의 평균을 출력하세요.

			// 1. 드라이버를 메모리 로딩
			// 2. 연결 객체 얻어오기
			// 3. SQL 문장 만들기

			
			String sql = "SELECT count(*) as count, round(avg(sal)) as avg FROM emp" ;
			PreparedStatement st = con.prepareStatement(sql);
			
			
			
	

			ResultSet rs = st.executeQuery();
			// 4. SQL 전송객체 만들기

			while (rs.next()) {
				System.out.println(rs.getInt("count") + "/" + rs.getInt("avg") );
				// 5. 전송하기
				}

				// 6. 닫기
				rs.close();
				st.close();
				con.close();

			System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}
	}
}