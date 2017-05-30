package interfacce;

import java.util.ArrayList;

import model.Video;

public interface Interface_Video extends CRUD {

	public ArrayList<Video> getAllVideo();

	public Video getVideoById(int id);
}
