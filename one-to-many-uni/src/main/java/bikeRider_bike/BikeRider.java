package bikeRider_bike;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BikeRider {
	@Id
	private int id;
	private String name;
	@OneToMany
	private List<Bike> bike;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Bike> getBike() {
		return bike;
	}
	public void setBike(List<Bike> bike) {
		this.bike = bike;
	}

	

}
