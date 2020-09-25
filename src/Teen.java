
public class Teen extends VPet {

	public Teen(String petName, String petType, String health, String ageStat, int happiness, int hunger, int age) {
		super(petName, petType, health, ageStat, happiness, hunger, age);
	
	}

	@Override
	public int countWinPrize(String result) {
		if(result.equals("Win")) {
			return 5 + (int)(Math.random() * ((15-8)+1));
		}else {
			return 2;
		}
	}

	public Teen() {		
		
	}

}
