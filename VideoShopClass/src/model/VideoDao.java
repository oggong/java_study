package model;

import java.util.ArrayList;

import model.vo.Video;

public interface VideoDao {
	public void insertVideo(Video vo, int count) throws Exception;
	public ArrayList SearchVideo(int sel, String word) throws Exception;
	public Video selectByPk(int vNum) throws Exception;
}
