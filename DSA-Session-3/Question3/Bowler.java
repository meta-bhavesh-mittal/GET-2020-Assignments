package Session3.Question3;

public class Bowler {
	private int bowler;
	private int balls;
	
	Bowler(int bowler,int balls) {
		this.bowler = bowler;
		this.balls = balls;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public int getBowler() {
		return bowler;
	}

	public void setBowler(int bowler) {
		this.bowler = bowler;
	}

	@Override
	public String toString() {
		return "HeapStructure [balls=" + this.balls + ", bowler=" + this.bowler + "]";
	}
	
}
