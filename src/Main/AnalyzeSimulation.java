package Main;

import java.util.Random;

public class AnalyzeSimulation {

	private static int MAX_TICKS=1000;
	private static int NUM_SIMULATION = 100;
 
	private Random random = new Random();

	public static void main(String[] args) {
		
		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int numStayHome = Integer.parseInt(args[2]);
		int numEssential = Integer.parseInt(args[3]);
		int numSkeptic = Integer.parseInt(args[4]);
		int numFrequentFlier = Integer.parseInt(args[5]);
		int numRecoverSlow = Integer.parseInt(args[6]);

		for(int i = 0; i<NUM_SIMULATION; i++) {
			
			Population population;
			
			population = new MixedPopulation(numStayHome, numEssential, numSkeptic,numFrequentFlier, numRecoverSlow);
			population.createPeople();
			Country country = new Country(width,height);
			country.population = population;
			population.placePeople(country);
			
			int total_infected = 0;
			int peak_infected = 0;
			int num_of_days = 0;
			
			for(int k=0;k<MAX_TICKS; k++) {
				country.simulateOneStep();
				total_infected += country.numInfected;
				
				if(country.numInfected>peak_infected) {
					peak_infected = country.numInfected;
				}

				if (country.numInfected==0) {
					num_of_days = k;
					break;
				}
			}
			System.out.printf("%-11s%-4d%-15s%-2d%-24s%-2d%-19s%-2d%n","Simulation",(i+1), ": number of days:",num_of_days,
					 " total number of infected ", total_infected,
					" peak infected level ", peak_infected);
			
		}
	}

}
