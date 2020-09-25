
public class CheapFeed {

	int feedPower = 1;

	public int getFeedPower() {
		return feedPower;
	}

	public void setFeedPower(int feedPower) {
		this.feedPower = feedPower;
	}

	public int restoreHunger(int hunger) {
		return hunger += feedPower;
	}
	
	public CheapFeed() {
	}

}
