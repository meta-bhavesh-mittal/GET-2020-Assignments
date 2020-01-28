package Animal.Mammal.Carnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Lion"
 */
public class Lion extends CarnivorousMammal 
{	
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Lion that zoo keeper gives 
	 * @param age double type represent the age of the Lion in years
	 * @param weight double type represent the weight of the Lion in kg
	 */
	public Lion(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Lion";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Lion
	 */
	public String getSound()
	{
		return ("Roars");
	}
}