package model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.VideoDao;
import model.vo.Video;

public class VideoModel implements VideoDao {

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
	String user = "GodTwo";
	String pass = "1234";
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public VideoModel() throws Exception {

		// 1. 드라이버로딩

		Class.forName(driver);
		con = DriverManager.getConnection(url, user, pass);
	}

	public void insertVideo(Video vo, int count) throws Exception {
		// 2. Connection 연결객체 얻어오기
		// 3. sql 문장 만들기
		String sql = "INSERT INTO VIDEO(VIDEO_NUMBER, GENRE,TITLE, DIRECTOR, ACTOR ) "
				+ "VALUES(VIDEO_SEQ.nextval,?,?,?,?) ";
		// 4. sql 전송객체 (PreparedStatement)
		st = con.prepareStatement(sql);

		st.setString(1, vo.getGenre());
		st.setString(2, vo.getVideoName());
		st.setString(3, vo.getDirector());
		st.setString(4, vo.getActor());

		for (int i = 0; i < count; i++) {
			// 5. sql 전송
			st.executeUpdate();
		}
		// 6. 닫기
		st.close();
		con.close();
	}

	public ArrayList SearchVideo(int sel, String word) throws Exception {
		con = DriverManager.getConnection(url, user, pass);

		String[] cols = { "TITLE", "DIRECTOR" };
		// 2. 연결 객체 얻어오기

		// 3. sql 문장
		String sql = "SELECT VIDEO_NUMBER, TITLE, GENRE, DIRECTOR, ACTOR FROM VIDEO   " + "WHERE  " + cols[sel]
				+ " LIKE '%" + word + "%'  ";
//		System.out.println(sql);

		// 2차원 배열이니깐 arraylist 안에 arraylist 로 해줘야 한다.
		ArrayList list = new ArrayList();
		// 4. sql 전송객체 얻어오기

		st = con.prepareStatement(sql);

		// 5.sql 전송
		rs = st.executeQuery();

		// 6. 결과처리
		while (rs.next()) {
			ArrayList data = new ArrayList();
			// data 에 각 컬럼에서 얻어 온 값을 추가
			data.add(rs.getInt("VIDEO_NUMBER"));
			// 나머지도
			data.add(rs.getString("TITLE"));
			data.add(rs.getString("GENRE"));
			data.add(rs.getString("DIRECTOR"));
			data.add(rs.getString("ACTOR"));

			list.add(data);
		}
		// 7. 연결 해제
		st.close();
		con.close();

		return list;
	}

	public Video selectByPk(int vNum) throws Exception {
		Video vo = new Video();
		con = DriverManager.getConnection(url, user, pass);
		// 2. 연결 객체 얻어오기
		// 3. sql 문장
		String sql = "SELECT * FROM VIDEO WHERE VIDEO_NUMBER=?";

		// 4. sql 전송객체 얻어오기

		st = con.prepareStatement(sql);
		st.setString(1,String.valueOf(vNum));
		

		// 5.sql 전송
		rs = st.executeQuery();
		
		// 6. 결과처리
		
		if(rs.next()) {
			vo.setVideoNo(rs.getInt("VIDEO_NUMBER"));
			vo.setVideoName(rs.getString("TITLE"));
			vo.setGenre(rs.getString("GENRE"));
			vo.setDirector(rs.getString("DIRECTOR"));
			vo.setActor(rs.getString("ACTOR"));
			vo.setExp(rs.getString("DESCRIPTION"));
		}
		
		// 7. 연결 해제
				st.close();
				con.close();

		return vo;
	}
}
