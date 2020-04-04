//Michael LI
package Main;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numSkeptic;
  int numFrequentFlier;
  int numRecoverSlow;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numSkeptic, int numFrequentFlier, int numRecoverSlow){
    super(numShelterInPlace + numEssential + numSkeptic + numFrequentFlier + numRecoverSlow);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numSkeptic = numSkeptic; 
    this.numFrequentFlier = numFrequentFlier;
    this.numRecoverSlow = numRecoverSlow;
  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    for(int i=0; i<this.numSkeptic; i++){
      this.addPerson(new Skeptic()); // Changed Person to Skeptic since the default person is Skeptic
    }
    for(int i=0;i<this.numFrequentFlier;i++) {
      this.addPerson(new FrequentFlier());
    }
    for(int i = 0; i<this.numRecoverSlow;i++) {
    	this.addPerson(new RecoverSlow());
    }
  }
}
