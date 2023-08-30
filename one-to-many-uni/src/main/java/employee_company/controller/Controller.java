package employee_company.controller;

import employee_company.dao.Dao;

public class Controller {
	public static void main(String[] args) {
		Dao dao=new Dao();
		dao.save();
//		dao.delete();
//		dao.find();
//		dao.update();
	}
}
