package food_app.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FoodOrder {
	@Id
	private int id;
	private String status;
	private double totalPrice;
	private String orderCreatedTime;
	private String orderDeliveryTime;
	private String customerName;
	private long contactNumber;
	@ManyToOne
	@JoinColumn
	private Userr userr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderCreatedTime() {
		return orderCreatedTime;
	}

	public void setOrderCreatedTime(String orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}

	public String getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	public void setOrderDeliveryTime(String orderDeliveryTime) {
		this.orderDeliveryTime = orderDeliveryTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Userr getUserr() {
		return userr;
	}

	public void setUserr(Userr userr) {
		this.userr = userr;
	}

}
