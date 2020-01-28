package Animal.Bird.Carnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Owl"
 */
public class Owl extends CarnivorousBird 
{	
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Owl that zoo keeper gives 
	 * @param age double type represent the age of the Owl in years
	 * @param weight double type represent the weight of the Owl in kg
	 */
	public Owl(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Owl";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Owl
	 */
	public String getSound()
	{
		return ("");
	}
}