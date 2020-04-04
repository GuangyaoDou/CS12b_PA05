//Michael LI
package Main;

public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numSkeptic;
  int numFrequentFlier;

  public MixedPopulation(int numShelterInPlace, int numEssential, int numSkeptic, int numFrequentFlier){
    super(numShelterInPlace + numEssential + numSkeptic + numFrequentFlier);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numSkeptic = numSkeptic;
    this.numFrequentFlier = numFrequentFlier;
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
  }
}
