package Animal.Bird.Omnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Peacock"
 */
public class Peacock extends OmnivorousBird 
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Peacock that zoo keeper gives 
	 * @param age double type represent the age of the Peacock in years
	 * @param weight double type represent the weight of the Peacock in kg
	 */
	public Peacock(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Peacock";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Peacock
	 */
	public String getSound()
	{
		return ("");
	}
}