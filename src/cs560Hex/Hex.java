package cs560Hex;

public class Hex {
	public int index;
	public int cost;
	public boolean alreadyUsed;
	
	public Hex(int index, int cost){
		this.cost = cost;
		this.index = index;
		this.alreadyUsed = false;
	}
}
