
public class Adult extends VPet {

	public Adult(String petName, String petType, String health, String ageStat, int happiness, int hunger, int age) {
		super(petName, petType, health, ageStat, happiness, hunger, age);
	}

	@Override
	public int countWinPrize(String result) {
		
		return 17 + (int)(Math.random()*(25-17));
	}

	public Adult() {
		
	}

}
