package employee_company.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	private int id;
	private String name;
	private String gst_num;
	private String registretion;
	@OneToMany
	private List<Employee> employees;

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

	public String getGst_num() {
		return gst_num;
	}

	public void setGst_num(String gst_num) {
		this.gst_num = gst_num;
	}

	public String getRegistretion() {
		return registretion;
	}

	public void setRegistretion(String registretion) {
		this.registretion = registretion;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
