package Main;

public class Skeptic extends Person {

	public Skeptic(int x,int y,Country country) {
		super(x, y,country);
	}
	
	public Skeptic() {
		super();
	}
	
	@Override
	void tryToMove() {
		// TODO Auto-generated method stub
		tryToMoveRandomly();
	}
	
}
