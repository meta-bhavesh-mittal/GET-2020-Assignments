package Animal.Mammal.Omnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Bear"
 */
public class Bear extends OmnivorousMammal 
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Bear that zoo keeper gives 
	 * @param age double type represent the age of the Bear in years
	 * @param weight double type represent the weight of the Bear in kg
	 */
	public Bear(String uniqueName,double age,double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Bear";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Bear
	 */
	public String getSound()
	{
		return ("");
	}

}