package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.vo.Login;


public class LoginModel {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "GodTwo";
	String passwd = "1234";
	Connection con = null;
	
	public	LoginModel() throws Exception{
		// 1. 드라이버로딩
		Class.forName(driver);	
	}		
		
		public Login LoginCheck(String id, String pass ) throws Exception{
			// DB연결
			Login vo = new Login();

			con = DriverManager.getConnection(url, user, passwd);
			// 3-1. sql문장
					String sql = "select EID FROM EMPLOYEE WHERE EID = ?";
					
					//4. 전송객체
					PreparedStatement st = con.prepareStatement(sql);
					st.setString(1, id);
					//5. 전송
					
					ResultSet rs = st.executeQuery();
					if(rs.next()) {
					vo.setEID(rs.getString("EID"));
					}
				
					
				// 3-2. sql문장
					
					String sql2 = "select EPASS FROM EMPLOYEE WHERE EPASS = ?";		
					//4. 전송객체
					PreparedStatement st1 = con.prepareStatement(sql2);
					st1.setString(1, pass);
					//5. 전송
					ResultSet rs2 = st1.executeQuery();
					if(rs2.next()) {
					vo.setEPASS(rs2.getString("EPASS"));
//					st1.setString(1, passwordField);
					}
				
					
					//6. 닫기
					rs.close();
					rs2.close();				
					st.close();
					st1.close();

					con.close();
					return vo;
		}
	}

	// 메소드(연결객체,  sql문장, 전송객체, 전송 , 닫기) 
	
	
	
	

