package zoo;

import java.util.HashMap;
import java.util.Map;

import Animal.Animal;

/**
 * 
 * @author Nilesh Patel
 * This Class represent zoo and contain method related to zoo management system
 */
public class Zoo 
{
    /**
     * HasMap which store all the animals of zoo.
     */
    static HashMap<String, Animal> animalsInZoo = new HashMap<>();
    
    /**
     * contains the number of the zones added to the zoo
     */
    public static int numberOfZones = 0;
    
    /**
     * This HashMap contain details about all zones that added to the zoo
     * here key is the integer key numberOfZones which start with 0 and increases as more zones are added
     * and value is the zone object
     * zone can't be removed once created
     */
    public static Map<Integer,Zone> zonesInZoo = new HashMap<Integer,Zone>();	
    
    /**
     * 
     * This static addZone method add new zone in the zoo
     * @param zone object of the Zone Class containing details about the zone that will be created
     * @return true if zone created successfully else return false
     */
    public static boolean addZone(Zone zone)
    {
        zone.zoneId=++(Zoo.numberOfZones);
        Zoo.zonesInZoo.put(zone.zoneId, zone);
        return true;
    }
    
    /**
     * 
     * This method find suitable zone for the animal according to animal category and sub category
     * @param animal object of animal containing details about animal
     * @return object of Zone Class containing suitable zone for the given animal 
     * @throws Exception if no suitable zone found for the type of the animal
     */
    private static Zone findSupportedZoneForAnimal(Animal animal) throws Exception
    {
        /**
         * checking every zone that is available in the zoo 
         */
        for(Zone zone : Zoo.zonesInZoo.values()){
            if(zone.categoryOfAnimalSupported.equalsIgnoreCase(animal.category) && zone.subcategoryOfAnimalSupported.equalsIgnoreCase(animal.subCategory)){
                return zone;
            }
        }
        /**
         * if no suitable zone found
         */
        throw new Exception("Supported zone not found for given animal!!!");
    }
    
    /**
     * 
     * This method is adding new animal to the zoo
     * @param animal object of animal representing any animal and contain its details
     * @return true if the animal added successfully else false
     * @throws Exception if animal is not added
     */
    public static boolean addAnimal(Animal animal) throws Exception
    {	
        /**
         * checking if same name animal already present in zoo
         */
        if(Zoo.animalsInZoo.containsKey(animal.uniqueName))
        {
            throw new Exception("Same name animal already present in zoo!!!");
        }
        
        /**
         * searching for the suitable zone for the given animal
         */
        Zone supportedZone = Zoo.findSupportedZoneForAnimal(animal);
        boolean animalPlaced = supportedZone.addAnimalInZone(animal);
        if(animalPlaced)
        {
            animalsInZoo.put(animal.uniqueName, animal);
            return true; 
        }
        return false;
    }
    
    /**
     * This method is used to add new cage in the zoo
     * @param cage object of the Cage Class containing details about the cage that need to be added
     * @return true if cage added successfully else false
     * @throws Exception if cage is not added
     */
    public static boolean addCage(Zone zone, Cage cage)
    {	
        if(Zoo.zonesInZoo.containsKey(zone.zoneId))
        {
            boolean cagePlaced = zone.addCage(cage);
            if(cagePlaced)
            { 
                return true; 
            }
        }	
        return false;
    }
    
    /**
     * 
     * This method is used to remove any animal from the zoo
     * @param animal object of the animal class containing details about the animal that needed to be removed
     * @return true if the animal removed successfully else false
     * @throws Exception if the animal can't be removed
     */
    public static boolean removeAnimal(Animal animal) throws Exception
    {
        /**
         * checking if animal present in the zoo
         */
        if(Zoo.animalsInZoo.containsKey(animal.uniqueName))
        {
            /**
             * finding zone of the animal
             */
            Zone zoneOfAnimal = Zoo.findSupportedZoneForAnimal(animal);
            for(Cage cage : zoneOfAnimal.cageList.values())
            {
                if(cage.cageSpecies == animal.species)
                {
                    cage.removeAnimalFromCage(animal);
                }
            }
            Zoo.animalsInZoo.remove(animal.uniqueName);	
            return true;
        }
        return false;
    }
}
