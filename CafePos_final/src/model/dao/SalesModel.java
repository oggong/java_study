package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalesModel {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "GodTwo";
	String pass = "1234";
	Connection con;
	ResultSet rs;

	public SalesModel() throws Exception {
		// 1. 드라이버로딩
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pass);

//		String cols [] = {"PNAME","ORCOUNT"};
//		
//		String sql ="SELECT sum(o.ORCOUNT) AS 판매량  " + 
//				"FROM PRODUCT p, ORD o  " + 
//				"WHERE p.PNO = o.PNO  " + 
//				"GROUP BY p.PNAME;";
//		
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		rs = st.executeQuery();
//		
//		st.close();
//		con.close();
	}

	public void salesRate(int rates, String word) throws Exception {
		

		String sql = "";

		PreparedStatement st = con.prepareStatement(sql);

		rs = st.executeQuery();

		st.close();
		con.close();
	}
	// 메소드(연결객체, sql문장, 전송객체, 전송 , 닫기)

}
