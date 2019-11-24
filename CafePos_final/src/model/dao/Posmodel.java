package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.vo.pos;

//import model.vo.Video;

public class Posmodel {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "GodTwo";
	String pass = "1234";
	Connection con = null;

	String memberNum;

	public Posmodel() throws Exception {
		Class.forName(driver);
	}

	// 회원 결제 메서드
	public void InsertPayment(ArrayList payment) throws Exception {
		System.out.println("00000");	
		Connection con = DriverManager.getConnection(url, user, pass);
System.out.println(0);
		PreparedStatement st2 = null;	
		PreparedStatement st3 = null;	
		PreparedStatement st4 = null;	
		for (int i = 0; i < payment.size(); i++) {
				String sql2 ="INSERT INTO SELL  (SELLNO, CNO , ENO, PNO, SELLCOUNT, SELLDATE)   VALUES  (SEQ_SELLNO.nextval, ?, 'A1111',   '"+payment.get(i)+"'  , 1, sysdate)"  ;
				st2 = con.prepareStatement(sql2);
				st2.setString(1,memberNum);
				st2.executeUpdate();
				st2.close();
				System.out.println("1>" + sql2 );
				
				
//				마일리지 sql
				String sql3 = "UPDATE CUSTOMER SET CSTAMP = (select * from (SELECT (sum(P.PPRICE *0.05) over(partition by CNO)) MILIEGE FROM PRODUCT P, SELL S WHERE (P.PNO = S.PNO) AND CNO = ?)where rownum = 1) WHERE CNO = ?";
//				System.out.println(memberNum);
//				System.out.println(sql3);
				st3 = con.prepareStatement(sql3);
				
				st3.setString(1, memberNum);
				st3.setString(2, memberNum);
				
				st3.executeUpdate();
				st3.close();
				System.out.println("2>" + sql3 );
				
//				원재료sql
				String sql4 = "UPDATE ORIGINAL SET OCOUNT= OCOUNT-1 WHERE ONO = (SELECT O.ONO FROM PRODUCT P , ORIGINAL O WHERE (P.ONO = O.ONO) AND PNO = '"+payment.get(i)+"')";
				st4 = con.prepareStatement(sql4);
				st4.executeUpdate();
				st4.close();
				
				System.out.println("3>" + sql4 );
				
			} 
//			
		con.commit();
		con.close();
	}
	// 비회원 결제 메서드
		public void InsertPayment1(ArrayList payment) throws Exception {
			Connection con = DriverManager.getConnection(url, user, pass);

			PreparedStatement st2 = null;	
			for (int i = 0; i < payment.size(); i++) {
					String sql2 ="INSERT INTO SELL  (SELLNO, ENO, PNO, SELLCOUNT, SELLDATE)   VALUES  (SEQ_SELLNO.nextval,'A1111',   '"+payment.get(i)+"'  , 1, sysdate)"  ;
					st2 = con.prepareStatement(sql2);
					
					st2.executeUpdate();
				} 
			con.commit();
			st2.close();
			con.close();
		}


	// 회원번호 받아오는 메서드
	public void InsertMemberNum(String memberNum) throws Exception {
		this.memberNum = memberNum;
	}
	
	

	public ArrayList PaymentList(String pno) throws Exception {

		con = DriverManager.getConnection(url, user, pass);
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "SELECT PNO pno, PNAME pname,  PPRICE price FROM PRODUCT WHERE PNO = ? "  ;
		
		ArrayList data = new ArrayList();
		st = con.prepareStatement(sql);
		st.setString(1, pno);
		rs = st.executeQuery();
		
		if(rs.next()) {
			
			data.add(rs.getString("pno"));
			data.add(rs.getString("pname"));
			data.add(rs.getInt("price"));
			
		}
		
		rs.close();
		st.close();
		con.close();
		return data;
	}

}
