package com.tyss.car.controller;

import java.util.Scanner;

import com.tyss.car.dao.CarDao;

public class CarContoller {
	public static void main(String[] args) {
		CarDao dao = new CarDao();
		Scanner read = new Scanner(System.in);
		System.out.println("welcome to car shope");
		while (true) {
			System.out.println("1. save\n2. fetch\n3. update\n4. fetch all\n5. delete\n6 exit");
			switch (read.nextInt()) {
			case 1:
				dao.addCar();
				break;
			case 2:
				dao.fetchCar();
				break;
			case 3:
				dao.updateCar();
				break;
			case 4:
				dao.fetchALl();
				break;
			case 5:
				dao.deleteCar();
				break;
			case 6:
				return;
			default: System.out.println("enter valid choice");
			}
		}
	}
}
