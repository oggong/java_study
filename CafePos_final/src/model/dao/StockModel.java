package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.vo.Stock;

public class StockModel {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "GodTwo";
	String pass = "1234";
//	Connection con;
//	PreparedStatement st;
//	ResultSet rs ;
	
	public StockModel() throws Exception{
		// 1. 드라이버로딩
		Class.forName(driver);	
	}
	
//	 발주 insert 메소드
	

// 원재료 재고 메소드
	public ArrayList SearchStock() throws Exception{
		Connection con = DriverManager.getConnection(url, user, pass);
	      
//	      String [] cols = {"원재료번호","원재료이름", "현재 남은 수량"};
	      
//	      sql문장
	      String sql = "SELECT ONO, ONAME, OCOUNT FROM ORIGINAL";
	      
	    //4. sql 전송객체
	      ArrayList list = new ArrayList();
	      PreparedStatement st = con.prepareStatement(sql);
	      ResultSet rs = st.executeQuery();
	      
	   // 6. 결과처리
	      while(rs.next()) {
	         ArrayList data = new ArrayList();
	         //data에 각 컬럼에서 얻어 온 값 추가
	         data.add(rs.getString("ONO"));
	         data.add(rs.getString("ONAME"));
	         data.add(rs.getInt("OCOUNT"));
	         list.add(data);
	      }
	      
	      st.close();
	      con.close();
	      return list;      
	}
	
	
//	원재료 pk로 찾기 메소드
	
	public Stock InsertBalju(String vNum, int a) throws Exception{
		
		Stock vo = new Stock();
		Connection con = DriverManager.getConnection(url, user, pass);

		String sql = "Insert into BALJU(BALJUNO, BALJUDATE, BALJUCOUNT, BNUMBER,ONO) VALUES (VALJU_SEQ.NEXTVAL, SYSDATE, ?, 'B1111',?)";
		

	      PreparedStatement st = con.prepareStatement(sql);
	      st.setInt(1,a);
	      st.setString(2, vNum);
	      ResultSet rs = st.executeQuery();
	      
//	      while(rs.next()) {
//	          vo.setONO(rs.getString("BALJUNO"));
//	          vo.setONAME(rs.getString("ONAME"));
//	          vo.setOCOUNT(rs.getInt("OCOUNT"));
//	          }
	          st.close();
	          con.close();
	          
	          return vo;
	}

	// 메소드(연결객체,  sql문장, 전송객체, 전송 , 닫기) 
	
		
	
	
	
	
}
