package Main;

public class StayAtHomeIfSick extends Skeptic{


	public StayAtHomeIfSick() {
		super();
	}

	public void tryToMove() {

    if (!this.infected){
      super.tryToMove();
    }
    
	}

}
