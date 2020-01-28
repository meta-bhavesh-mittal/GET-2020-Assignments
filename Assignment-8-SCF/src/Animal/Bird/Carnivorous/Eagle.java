package Animal.Bird.Carnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Eagle"
 */
public class Eagle extends CarnivorousBird 
{	
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Eagle that zoo keeper gives 
	 * @param age double type represent the age of the Eagle in years
	 * @param weight double type represent the weight of the Eagle in kg
	 */
	public Eagle(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Eagle";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Eagle
	 */
	public String getSound()
	{
		return ("");
	}
}