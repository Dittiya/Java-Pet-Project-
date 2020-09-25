
public class VPet {

	protected String petName;
	protected String petType;
	protected String health;
	protected String ageStat;
	protected int happiness;
	protected int hunger;
	protected int age;

	
	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	
	public String getAgeStat() {
		return ageStat;
	}

	public void setAgeStat(String ageStat) {
		this.ageStat = ageStat;
	}
	
	public int countWinPrize(String result) {
		if(result.equals("Win")) {
			return 3 + (int)(Math.random()*((7-3)+1));
		}else {
			return 1;
		}
	}
	
	public VPet(String petName, String petType, String health, String ageStat, int happiness, int hunger, int age) {
		super();
		this.petName = petName;
		this.petType = petType;
		this.health = health;
		this.ageStat = ageStat;
		this.happiness = happiness;
		this.hunger = hunger;
		this.age = age;
	}

	public VPet() {
		
	}
	
	
}
