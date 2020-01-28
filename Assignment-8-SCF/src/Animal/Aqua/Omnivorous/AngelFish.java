package Animal.Aqua.Omnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Angel Fish"
 */
public class AngelFish extends OmnivorousAqua 
{	
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Angel Fish that zoo keeper gives 
	 * @param age double type represent the age of the Angel Fish in years
	 * @param weight double type represent the weight of the Angel Fish in kg
	 */
	public AngelFish(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "AngelFish";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Angel Fish
	 */
	public String getSound()
	{
		return ("");
	}
}