package Animal.Reptile.Carnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Snake"
 */
public class Snake extends CarnivorousReptile 
{	
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Snake that zoo keeper gives 
	 * @param age double type represent the age of the Snake in years
	 * @param weight double type represent the weight of the Snake in kg
	 */
	public Snake(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Snake";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Snake
	 */
	public String getSound()
	{
		return ("");
	}
}