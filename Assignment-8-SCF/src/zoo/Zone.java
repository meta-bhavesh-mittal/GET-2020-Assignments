package zoo;

import java.util.HashMap;
import java.util.Map;

import Animal.Animal;

/**
 * 
 * @author Nilesh Patel
 * This Class represent zone in the zoo
 */
public class Zone 
{	
    /**
     * unique integer value for zone
     */
    public int zoneId;
    
    /**
     * total cages that the zone can have
     */
    public int totalCagesCapacity;
    
    /**
     * total cages added to zone currently 
     */
    public int numberOfCagesPlaced;
    
    /**
     * category of the animal supported by zone
     */
    public String categoryOfAnimalSupported;
    
    /**
     * sub category of the animal supported by zone
     */
    public String subcategoryOfAnimalSupported;
    
    /**
     * HashMap contains all the cages that added to zone
     * here key the integer numberOfCagesPlaced that at start is 0 and increases after each cage placed
     * value is the object of Cage Class containing all details of the cage
     */
    public Map<Integer,Cage> cageList = new HashMap<Integer,Cage>();
    
    /**
     * true if zone has a Canteen
     */
    public boolean hasCanteen;
    
    /**
     * true if zone has a Park
     */
    public boolean hasPark;
    
    /**
     * 
     * parameterized constructor creating object of the Zone with given parameters
     * @param zoneId integer value must be unique for all zones
     * @param totalCagesCapacity integer value total number of cages zone can have
     * @param categoryOfAnimalSupported String value category of animal supported by zone
     * @param subcategoryOfAnimalSupported String value sub category  of animal supported by the zone
     * @param hasCanteen boolean value true if zone has a canteen
     * @param hasPark boolean value true if zone has a park
     */
    public Zone(int totalCagesCapacity, String categoryOfAnimalSupported, String subcategoryOfAnimalSupported, boolean hasCanteen,boolean hasPark)
    {
        this.totalCagesCapacity = totalCagesCapacity;
        this.categoryOfAnimalSupported = categoryOfAnimalSupported;
        this.subcategoryOfAnimalSupported = subcategoryOfAnimalSupported;
        this.hasCanteen = hasCanteen;
        this.hasPark = hasPark;
    }
    
    /**
     * 
     * This method add new cage to the zone
     * @param cage object of the Cage Class contain details about the cage
     * @return true if cage is added successfully else false
     * @throws Exception if cage is not added because zone cage capacity is full
     */
    public boolean addCage(Cage cage)
    {
        if(this.totalCagesCapacity == this.numberOfCagesPlaced)
        {
            return false;
        }
        cage.cageId = ++this.numberOfCagesPlaced;
        this.cageList.put(cage.cageId, cage);
        return true;
    }
    
    /**
     * 
     * This method add animal to zone
     * @param animal object of the Animal Class contain details about the animal 
     * @return true if the animal added successfully else false
     * @throws Exception if animal is not supported in this zone or cage is not available in zone
     */
    public boolean addAnimalInZone(Animal animal) throws Exception
    {
        for(Cage cage :this.cageList.values())
        {	
            if(cage.addAnimalInCage(animal))
            {
                return true;
            }		
        }
        return false;
    }
}