
public class Medicine extends CheapFeed{

	String cure = "Healthy";
	
	public Medicine() {
	}

	public String getCure() {
		return cure;
	}

	public void setCure(String cure) {
		this.cure = cure;
	}

	public Medicine(String cure) {
		super();
		this.cure = cure;
	}

	@Override
	public int restoreHunger(int hunger) {
		return super.restoreHunger(hunger);
	}
	
	public String cureSickness(String stat) {
		return stat = cure;
	}
	
	public int cureSadness(int stat) {
		return stat += 1;
	}
}
