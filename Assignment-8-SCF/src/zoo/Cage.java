package zoo;

import java.util.HashMap;

import Animal.Animal;

/**
 *
 * @author Nilesh Patel
 * This class represent cage in the zoo
 */
public class Cage 
{
    /**
     * integer value unique to every cage in a zone
     */
    public int cageId;
    
    /**
     * total animal capacity of the cage
     */
    public int capacityOfCage;
    
    public String cageSpecies;
    
    /**
     * total animal in the cage currently 
     */
    public int TotalAnimalInCage;
    
    /**
     * This HashMap store details about the animals stored in the cage
     * key is the unique name of the animal and value is the animal object
     */
    public HashMap<String,Animal> animalList = new HashMap<String,Animal>();
    
    /**
     * 
     * parameterized constructor used to create object of Cage
     * @param cageId unique integer id for cage in zone
     * @param capacityOfCage capacity of the cage to contain animal
     * @param catagoryOfAnimalSupported category of the animal supported by cage
     * @param subCatagoryOfAnimalSupported sub category of the animal supported by cage
     */
    public Cage(int capacityOfCage, String cageSpecies)
    {
        this.capacityOfCage = capacityOfCage;
        this.cageSpecies = cageSpecies;
        this.TotalAnimalInCage = 0;
    }
    
    /**
     * 
     * This method is use to add animal to the cage
     * @param animal object of the animal class contain details about the animal
     * @return true if the animal is added else false
     * @throws Exception if different species animal already present in the cage 
     */
    public boolean addAnimalInCage(Animal animal)
    {	
        if(this.cageSpecies != animal.species || this.capacityOfCage == this.TotalAnimalInCage)
        {
            return false;
        }		
        this.animalList.put(animal.uniqueName, animal);
        this.TotalAnimalInCage++;
        return true;
    }
    
    /**
     * 
     * This method is used to remove given animal from cage
     * @param animal object of animal class contain details of the animal to be removed
     * @return true if animal is removed else false
     */
    public boolean removeAnimalFromCage(Animal animal)
    {
        if(this.animalList.containsKey(animal.uniqueName))
        {	
            this.animalList.remove(animal.uniqueName);
            this.TotalAnimalInCage--;
        }	
        return true;
    }
}
