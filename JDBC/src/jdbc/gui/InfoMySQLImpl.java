package jdbc.gui;

import java.sql.SQLException;
import java.util.ArrayList;

//형식만 만들것임

public class InfoMySQLImpl implements infoModel {

	public InfoMySQLImpl() {
		// mysql driver 로딩
	}

	public void insertData() {
		//실제로 mysql
	}

	@Override
	public void modify(InfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InfoVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<InfoVO> selectAllData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoVO selectByTel(String tel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InfoVO selectById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
// 인터페이스 로 하였을때 mysql 과 orcle 이어도 상관없이 사용가능
// 확장성 용이
