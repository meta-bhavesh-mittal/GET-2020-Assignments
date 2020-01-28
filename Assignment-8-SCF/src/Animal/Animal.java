package Animal;

/**
 * 
 * @author Nilesh Patel
 * This abstract class represent animal
 *
 */
abstract public class Animal 
{	
    /**
     * This represent category of animal eg. Mammal,Reptile,Bird,Aqua
     */
    public String category;
    
    /**
     * This represent sub category of animal eg. Carnivorous,Herbivorous,Omnivorous
     */
    public String subCategory;
    
    /**
     * this represent the species of the animal eg. Lion,Tiger,Deer,Elephant
     */
    public String species;
    
    /**
     * this represent the unique name that every animal have in the zoo 
     */
    public String uniqueName;
    
    /**
     * this represent the age of the animal in years
     */
    public double age;
    
    /**
     * this represent the weight of the animal in kg
     */
    public double weight;
    
    /**
     * 
     * This method return the sound of the animal as a String eg for Lion "Roars"
     * @return String Object
     */
    abstract public  String getSound();
}