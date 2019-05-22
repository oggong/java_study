package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.CustomerDao;
import model.vo.Customer;

public class CustomerModel implements CustomerDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "GodTwo";
	String pass = "1234";
	Connection con = null;
	PreparedStatement st = null;

	public CustomerModel() throws Exception {
		// 1. 드라이버로딩
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);

	}

	public void insertCustomer(Customer vo) throws Exception {
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		String sql = "INSERT INTO MEMBER(PHONE_NUMBER,NAME,HOME_NUMBER,ADDRESS,EMAIL)" + "VALUES(?,?,?,?,?)";
		// 3. sql 문장 만들기
		st = con.prepareStatement(sql);
		st.setString(1, vo.getCustName());
		st.setString(2, vo.getCustTel1());
		st.setString(3, vo.getCustTel2());
		st.setString(4, vo.getCustAddr());
		st.setString(5, vo.getCustEmail());
		// 4. sql 전송객체 (PreparedStatement)

		// 5. sql 전송
		int result = st.executeUpdate();
		// 6. 닫기
		st.close();
		con.close();

	}

	public Customer selectByTel(String tel) throws Exception {
		Customer dao = new Customer();
		Customer vo = new Customer();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			con = DriverManager.getConnection(url, user, pass);
//			3. sql 문장 만들기 (*****) 
			String sql = "SELECT * FROM MEMBER WHERE PHONE_NUMBER=?";

//			4. sql 전송 객체 얻어오기
			st = con.prepareStatement(sql);
			st.setString(1,tel);

//			5. sql 전송
			rs = st.executeQuery();

//			6. 결과 처리
			if (rs.next()) {
				dao.setCustName(rs.getString("NAME"));
				dao.setCustTel1(rs.getString("PHONE_NUMBER"));
				dao.setCustTel2(rs.getString("HOME_NUMBER"));
				dao.setCustAddr(rs.getString("ADDRESS"));
				dao.setCustEmail(rs.getString("EMAIL"));
			}

			
			return dao;
		} finally {
//			7. 닫기 
//			(연결 닫기 제일 중요함)
			rs.close();
			st.close();
			con.close();
			}


	}

	public int updateCustomer(Customer vo) throws Exception {
		int result = 0;
		String sql = "UPDATE MEMBER SET NAME=?,HOME_NUMBER=?,ADDRESS=?,EMAIL=? WHERE PHONE_NUMBER=?";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		st = con.prepareStatement(sql);
		
		st.setString(1, vo.getCustName());
		st.setString(2, vo.getCustTel2());
		st.setString(3, vo.getCustAddr());
		st.setString(4, vo.getCustEmail());
		st.setString(5,vo.getCustTel1());

		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		
		return result;
	
	}
}
