package Animal.Aqua.Carnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Shark"
 */
public class Shark extends CarnivorousAqua
{
    /**
     * 
     * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
     * @param uniqueName String represent unique name for Shark that zoo keeper gives 
     * @param age double type represent the age of the Shark in years
     * @param weight double type represent the weight of the Shark in kg
     */
    public Shark(String uniqueName, double age, double weight)
    {
        super();
        this.age = age;
        this.uniqueName = uniqueName;
        this.weight = weight;
        this.species = "Shark";
    }
    
    /**
     * 
     * This method return the String representation of the sound of the Shark
     */
    public String getSound()
    {
        return ("");
    }
}