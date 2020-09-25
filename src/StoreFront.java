
public class StoreFront {

	String cheapFoodPrice = "5 VCoins";
	String healthyFoodPrice = "10 VCoins"; 
	String medicine = "20 VCoins";
	
	public StoreFront() {
	}

	public String getCheapFoodPrice() {
		return cheapFoodPrice;
	}

	public void setCheapFoodPrice(String cheapFoodPrice) {
		this.cheapFoodPrice = cheapFoodPrice;
	}

	public String getHealthyFoodPrice() {
		return healthyFoodPrice;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public void setHealthyFoodPrice(String healthyFoodPrice) {
		this.healthyFoodPrice = healthyFoodPrice;
	}

	public StoreFront(String cheapFoodPrice, String healthyFoodPrice, String medicine) {
		super();
		this.cheapFoodPrice = cheapFoodPrice;
		this.healthyFoodPrice = healthyFoodPrice;
		this.medicine = medicine;
	}

	

	
}
