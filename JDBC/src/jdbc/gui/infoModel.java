package jdbc.gui;

import java.sql.SQLException;
import java.util.ArrayList;

public interface infoModel {

	public void modify(InfoVO vo) throws Exception;

	public void delete(InfoVO vo) throws Exception;

	public ArrayList<InfoVO> selectAllData() throws SQLException;

	public InfoVO selectByTel(String tel) throws SQLException;

	public InfoVO selectById(String id) throws SQLException;
}

