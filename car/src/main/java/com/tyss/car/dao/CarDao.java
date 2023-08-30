package com.tyss.car.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.car.dto.Car;

public class CarDao {
	Scanner read = new Scanner(System.in);
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void addCar() {
		Car car = new Car();
		System.out.println("enter the car number");
		car.setCarNumber(read.next());
		System.out.println("enter the car name");
		car.setCarName(read.next());
		System.out.println("enter the car price");
		car.setPrice(read.nextDouble());
		System.out.println("enter the car color");
		car.setColor(read.next());
		entityTransaction.begin();
		entityManager.persist(car);
		entityTransaction.commit();
		System.out.println("Car is added");
	}

	public void fetchCar() {
		System.out.println("enter the car number to fetch");
		Car car = entityManager.find(Car.class, read.next());
		if (car != null) {
			System.out.println("car number :" + car.getCarNumber());
			System.out.println("car name :" + car.getCarName());
			System.out.println("car price :" + car.getPrice());
			System.out.println("car number :" + car.getColor());
		}

	}

	public void updateCar() {
		System.out.println("enter the car number to update the price");
		Car car = entityManager.find(Car.class, read.next());
		if (car != null) {
			System.out.println("enter the new car price");
			car.setPrice(read.nextDouble());
			entityTransaction.begin();
			entityManager.merge(car);
			entityTransaction.commit();
			System.out.println("updated successfully");
		}
		else 
			System.out.println("car number is invalid");
	}
	public void fetchALl() {
		Query query=entityManager.createQuery("select c from Car c");//JPQL query
		List<Car> cars=query.getResultList();// gives list of Car
		for(Car car:cars) {
			System.out.println("-------------------------------------");
			System.out.println("car number :" + car.getCarNumber());
			System.out.println("car name :" + car.getCarName());
			System.out.println("car price :" + car.getPrice());
			System.out.println("car number :" + car.getColor());
			System.out.println("-------------------------------------");
		}
	}
	public void deleteCar() {
		System.out.println("enter the car number to delete the car");
		Car car=entityManager.find(Car.class, read.next());
		if(car != null) {
			entityTransaction.begin();
			entityManager.remove(car);
			entityTransaction.commit();
			System.out.println("car is deleted");
		}
		else 
			System.out.println("car number is invalid");
	}
}
