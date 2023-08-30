package com.tyss.car.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Car implements Serializable{
	@Id
	private String carNumber;
	private String carName;
	private double price;
	private String color;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
