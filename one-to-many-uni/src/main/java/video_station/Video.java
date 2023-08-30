package video_station;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Video {
	@Id
	private int number;
	private String title;
	private String time;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
