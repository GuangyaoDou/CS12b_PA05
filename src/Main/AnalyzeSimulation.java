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
		NUM_SIMULATION = Integer.parseInt(args[7]);

		//Entire simulation
		double average_affected = 0;
		double average_days = 0;
		int maximum_people = 0;
		
		for(int i = 0; i<NUM_SIMULATION; i++) {
			
			Population population;
			
			population = new MixedPopulation(numStayHome, numEssential, numSkeptic,numFrequentFlier, numRecoverSlow);
			population.createPeople();
			Country country = new Country(width,height);
			country.population = population;
			population.placePeople(country);
			
			// Each simulation
			int total_infected = 0;
			int peak_infected = 0;
			int num_of_days = 0;
			int infected_yesterday = 0;
			int recovered_yesterday = 0;
			int infected_level = 0;
			int infected_level_yesterday = 0;
			
			
			for(int k=0;k<MAX_TICKS; k++) {
				country.simulateOneStep();
				infected_level = country.numInfected + country.numRecovered - infected_yesterday - recovered_yesterday;
				total_infected += infected_level;
				
				if(infected_level > infected_level_yesterday) {
					peak_infected = infected_level;
				}

				if (country.numInfected==0) {
					num_of_days = k;
					break;
				}
				infected_yesterday = country.numInfected;
				recovered_yesterday = country.numRecovered;
				infected_level_yesterday = infected_level;
			}
			System.out.printf("%-11s%-4d%-15s%-2d%-24s%-3d%-19s%-2d%n","Simulation",(i+1), ": number of days:",num_of_days,
					 " total number of infected ", total_infected,
					" peak infected level ", peak_infected);
			
			average_affected += total_infected;
			average_days += num_of_days;
			if(peak_infected > maximum_people) {
				maximum_people = peak_infected;
			}
			
		}
		average_affected = average_affected/NUM_SIMULATION;
		average_days = average_days/NUM_SIMULATION;
		System.out.println("The avergae number of days until there are no infections is: "+average_days);
		System.out.println("The average number of people infected is: " + average_affected);
		System.out.println("the maximum number of people infected at any one time in the simulation is: " + maximum_people);
	}

}
