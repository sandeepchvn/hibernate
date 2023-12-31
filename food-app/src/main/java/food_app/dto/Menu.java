package food_app.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Menu {
	@Id
	private int id;
	@OneToMany(mappedBy = "menu")
	private List<FoodProduct> foodProducts;
	@OneToOne
	@JoinColumn
	private Userr userr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<FoodProduct> getFoodProducts() {
		return foodProducts;
	}

	public void setFoodProducts(List<FoodProduct> foodProducts) {
		this.foodProducts = foodProducts;
	}

	public Userr getUserr() {
		return userr;
	}

	public void setUserr(Userr userr) {
		this.userr = userr;
	}

}
