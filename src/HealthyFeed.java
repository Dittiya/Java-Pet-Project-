
public class HealthyFeed extends CheapFeed{

	
	@Override
	public int restoreHunger(int hunger) {
		return super.restoreHunger(hunger) + super.feedPower;
	}

	public HealthyFeed() {
	}

}
