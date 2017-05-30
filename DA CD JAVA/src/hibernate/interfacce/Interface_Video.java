package hibernate.interfacce;

import java.util.ArrayList;

import hibernate.model.Video;

public interface Interface_Video  extends CRUD{

	public ArrayList<Video> getAllVideo();

	public Video getVideoByStt(int stt);
}
