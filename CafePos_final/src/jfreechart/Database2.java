package jfreechart;

import java.sql.*;
import java.util.*;

public class Database2 {

	String URL = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String USER ="GodTwo";
	String PASS = "1234";

	public ArrayList<ArrayList> getData() {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	
			
			//***************************************************************
			String sql = "SELECT p.PNAME PNAME,sum(s.SELLCOUNT) sum  " + 
					"FROM PRODUCT p, SELL  s " + 
					"WHERE p.PNO = s.PNO  " + 
					"GROUP BY p.pname ";
//			System.out.println(sql);
			//***************************************************************
			
			PreparedStatement stmt = con.prepareStatement( sql );	

			ResultSet rset = stmt.executeQuery();

			
			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getInt("sum"));				//****************
				temp.add( rset.getString("PNAME"));		//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
}
