package video_station;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VideoChapter {
	@Id
	private int chapterNum;
	private String name;
	@OneToMany
	private List<Video> videos;
	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public int getChapterNum() {
		return chapterNum;
	}

	public void setChapterNum(int chapterNum) {
		this.chapterNum = chapterNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
