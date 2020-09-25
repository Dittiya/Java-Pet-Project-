
public class Inventory {

	protected int CheapFeedAmount = 1;
	protected int HealthyFeedAmount = 1;
	protected int medicineAmount = 0;
	
	public int getMedicineAmount() {
		return medicineAmount;
	}

	public void setMedicineAmount(int medicineAmount) {
		this.medicineAmount = medicineAmount;
	}

	public int getCheapFeedAmount() {
		return CheapFeedAmount;
	}

	public void setCheapFeedAmount(int cheapFeedAmount) {
		CheapFeedAmount = cheapFeedAmount;
	}

	public int getHealthyFeedAmount() {
		return HealthyFeedAmount;
	}

	public void setHealthyFeedAmount(int healthyFeedAmount) {
		HealthyFeedAmount = healthyFeedAmount;
	}

	public Inventory(int cheapFeedAmount, int healthyFeedAmount, int medicineAmount) {
		super();
		CheapFeedAmount = cheapFeedAmount;
		HealthyFeedAmount = healthyFeedAmount;
		this.medicineAmount = medicineAmount;
	}

	public Inventory() {
	}

}
