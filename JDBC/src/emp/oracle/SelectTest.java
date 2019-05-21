package emp.oracle;

import java.sql.*;

public class SelectTest {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
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
			String sql = "SELECT *FROM emp";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("EMPNO")+"/" // getInt("EMPNO") 컬럼명 넣어줘야 한다. 가독성을 높히기위해 대문자 이용 선호
						+rs.getString("ENAME")+ "/" +rs.getInt("SAL")); 
			}
			st.close();
			con.close();
			System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}
	}
}