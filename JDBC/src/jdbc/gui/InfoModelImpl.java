package jdbc.gui;

import java.sql.*;
import java.util.ArrayList;

public class InfoModelImpl {
	// InfoModelImplement

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.170:1521:orcl";
	String user = "scott";
	String pass = "tiger";
	Connection con = null;
	PreparedStatement st = null;

	// 생성자 함수 생성
//	public InfoModelImpl() throws Exception { // 예외를 던져 주기 --- 사용자 화면에 오류 화면 띄워주기
	public InfoModelImpl() throws Exception {
		// 1. 드라이버를 메모리에 로딩
		Class.forName(driver);
		// 2. 연결 객체 얻어오기
//		Connection con = DriverManager.getConnection(url, user, pass);

	} // end of InfoModelImpl()

	public void insert(InfoVO vo) throws Exception {

//	
//			3. sql 문장 만들기 (*****) 
		String sql = "INSERT INTO INFORMATION(name,id,tel,sex,age,home) VALUES(?,?,?,?,?,?)";

//			4. sql 전송 객체 얻어오기 
//					- PreparedStatement : 미완성된 sql
//					-- ? 지정 ****
//	
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			st = con.prepareStatement(sql);

			st.setString(1, vo.name);
			st.setString(2, vo.id);
			st.setString(3, vo.tel);
			st.setString(4, vo.gender);
			st.setInt(5, vo.age);
			st.setString(6, vo.home);

//			5. sql 전송
//			[6. 결과 처리]
			int result = st.executeUpdate();

//			7. 닫기 
//		(연결 닫기 제일 중요함)
			st.close();
			con.close();
			System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}

	}// end of insert()

	public void modify(InfoVO vo) throws Exception {

		//
//				3. sql 문장 만들기 (*****) 
		String sql = "UPDATE INFORMATION SET name=?,id=?," + "sex=?,age=?,home=? WHERE tel=?";

//				4. sql 전송 객체 얻어오기 
//						- PreparedStatement : 미완성된 sql
//						-- ? 지정 ****
		//
		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			st = con.prepareStatement(sql);

			st.setString(1, vo.name);
			st.setString(2, vo.id);
			st.setString(3, vo.gender);
			st.setInt(4, vo.age);
			st.setString(5, vo.home);
			st.setString(6, vo.tel);

//				5. sql 전송
//				[6. 결과 처리]
			int result = st.executeUpdate();

//				7. 닫기 
//			(연결 닫기 제일 중요함)
			st.close();
			con.close();
			System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}

	}// end of modify()

	public void delete(InfoVO vo) throws Exception {

//				3. sql 문장 만들기 (*****) 
		String sql = "DELETE FROM INFORMATION WHERE tel=?";

//				4. sql 전송 객체 얻어오기 
		try {
			con = DriverManager.getConnection(url, user, pass);
			st = con.prepareStatement(sql);

			st.setString(1, vo.tel);

//				5. sql 전송
//				[6. 결과 처리]
			int result = st.executeUpdate();

			if (result != 0) {
				con.commit();
			} else {
				con.rollback();
			}

//				7. 닫기 
//			(연결 닫기 제일 중요함)
			st.close();
			con.close();
			System.out.println("연결성공");
		} catch (SQLException ex) {
			System.out.println("전송실패" + ex.getMessage());
		}

	}// end of modify()

	public ArrayList<InfoVO> selectAllData() throws SQLException { // void 대신에 return 하려는 자료형으로 맞춰줘야 return 가능
		// 2. 연결 객체 얻어오기

		Connection con = null; // Connection 객체 와 변수선언 잘라주기
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
//		3. sql 문장 만들기 (*****) 
			String sql = "SELECT * FROM INFORMATION"; // SELECT * FROM 테이블명;

//		4. sql 전송 객체 얻어오기 
			st = con.prepareStatement(sql);
//		5. sql 전송

			rs = st.executeQuery(); // sql 괄호 안에 쓰면 안됨

//		6. 결과 처리
			ArrayList<InfoVO> list = new ArrayList<InfoVO>();
			while (rs.next()) { // 새로운 객체 생성을 반복 == 한사람에 대한 정보를 반복 저장 하지 않기 위해 배열 사용 해야 함.
								// 한사람에 대한 정보를 입력한 후 InfoVO에 입력 --> InfoVO 에 입력된 것은 ArrayList로 순차적으로 저장

				InfoVO vo = new InfoVO();
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setTel(rs.getString("tel"));
				vo.setGender(rs.getString("sex"));
				vo.setAge(rs.getInt("age"));
				vo.setHome(rs.getString("home"));
				list.add(vo);
			} // 한사람에 대한 정보를 InfoVO 로 넣겠다 ---- 하나로 뭉쳐놔야 Connection 하기 용이해지기 때문에

			// 나를 부른곳으로 return 해주겠다.
			return list;

		} finally {
//					7. 닫기 
//					(연결 닫기 제일 중요함)

			rs.close(); // resultset close
			st.close(); // pst
			con.close(); // connection 관리 중요하다!

		}

	} // end of selectAllData()

	public InfoVO selectByTel(String tel) throws SQLException {

		// 2. 연결 객체 얻어오기
		InfoVO vo = new InfoVO();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(url, user, pass);
//			3. sql 문장 만들기 (*****) 
			String sql = "SELECT * FROM INFORMATION WHERE tel=?";

//			4. sql 전송 객체 얻어오기
			st = con.prepareStatement(sql);
			st.setString(1, tel);

//			5. sql 전송
			rs = st.executeQuery();

//			6. 결과 처리
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setTel(rs.getString("tel"));
				vo.setGender(rs.getString("sex"));
				vo.setAge(rs.getInt("age"));
				vo.setHome(rs.getString("home"));

			}
			return vo;
		} finally {
//			7. 닫기 
//			(연결 닫기 제일 중요함)
			rs.close();
			st.close();
			con.close();
		}
	}

	public InfoVO selectById(String id) throws SQLException {

		// 2. 연결 객체 얻어오기
		InfoVO vo = new InfoVO();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(url, user, pass);
//			3. sql 문장 만들기 (*****) 
			String sql = "SELECT * FROM INFORMATION WHERE id=?";

//			4. sql 전송 객체 얻어오기
			st = con.prepareStatement(sql);
			st.setString(1, id);

//			5. sql 전송
			rs = st.executeQuery();

//			6. 결과 처리
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setTel(rs.getString("tel"));
				vo.setGender(rs.getString("sex"));
				vo.setAge(rs.getInt("age"));
				vo.setHome(rs.getString("home"));

			}
			return vo;
		} finally {
//			7. 닫기 
//			(연결 닫기 제일 중요함)
			rs.close();
			st.close();
			con.close();
		}
	}

}// end of class // InfoModelImplement
