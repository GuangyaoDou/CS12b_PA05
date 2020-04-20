package Main;

public class RecoverSlow extends Person{
	/**
	 * This type of person has slower recovery time and they still move around like Skeptics
	 * 
	 * Since they still wander like skeptics, and harder to recover, the chance of affecting others
	 * increases and it takes the country more time to recover everyone
	 */
	
	int recoveryTime = 10; //This type of person recovers slower
	
	public RecoverSlow() {
		super();
	}
	
	public RecoverSlow(int x,int y,Country country) {
		super(x, y,country);
	}
	
	@Override
	void tryToMove() {
		tryToMoveRandomly();
	}

}
