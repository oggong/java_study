package emp.oracle2;

import java.sql.*;

public class InsertTest {

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
		
		//3. SQL 문장 만들기
		//4. SQL 전송객체 만들기
		//5. 전송하기
		//6. 닫기
		try {
				// 화면에서 입력값 얻어오기 
//				int empno = 5678;
//				String ename = "갓DB";
//				int sal = 9000;
//				int deptno = 30;
//				String job = "IT부서";                // Statement
				
				// 화면에서 입력한 값을 얻어와서 셋팅 
				int empno = 6789;
				String ename = "갓DB";
				int sal = 9000;
				int deptno = 30;
				String job = "IT부서";
													//preparedstatement
				
				
				String sql = "INSERT INTO emp(empno, ename, sal, deptno, job)   "
						+ "VALUES(?,?,?,?,?)";
				//"+empno+",'"+ename+"',"+sal+","+deptno+","+"'"+job+"'
				System.out.println(sql); // 항상 sql 문장 만든후 자바에서 실행 해보기 
				
				
				//Statement st = con.createStatement();
				PreparedStatement st = con.prepareStatement(sql); // 미완성된 sql 불러오기  == (VALUES ?,?,?,?,?)
				
				// SQL을 가져온 이후 물음표 세팅 해주기 
				st.setInt(1, empno);
				st.setString(2, ename);
				st.setInt(3, sal);
				st.setInt(4, deptno);
				st.setString(5, job);
				
//				int result = st.executeUpdate(sql); // excuteUpdate에 결과값이 넘어옴 
													// excuteUpdate 에 commit 이 합쳐저 있기 때문에 
													// 원래는 commit rollback 을 수동으로 해줘야 함.
				
				// 전송 
				int result = st.executeUpdate(); // -- sql 전송하면 안됨
				st.close();
				con.close();
				System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}
		
	}

}
