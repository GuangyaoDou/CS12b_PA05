package Main;

import java.util.Random;

public class FrequentFlier extends Person{
	
	private Random random = new Random();
	
	public FrequentFlier(int x,int y,Country country) {
		super(x, y,country);
	}
	
	public FrequentFlier() {
		super();
	}
	
	@Override
	void tryToMove() {
		 int i = random.nextInt(country.places.length);
	     int j = random.nextInt(country.places[i].length);
	     while (country.places[i][j] != null) {
	         i = random.nextInt(country.places.length);
	         j = random.nextInt(country.places[i].length);
	       }
	     if(isOK(i,j,this.country)) {
		     this.moveTo(i, j);  
	     }
	}

}
