package product_order;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	@Id
	private int id;
	private String name;
	@ManyToMany
	private List<Order1> orders;

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

	public List<Order1> getOrders() {
		return orders;
	}

	public void setOrders(List<Order1> orders) {
		this.orders = orders;
	}



}
