package Animal.Mammal.Herbivore;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Deer"
 */
public class Deer extends HerbivorousMammal 
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Deer that zoo keeper gives 
	 * @param age double type represent the age of the Deer in years
	 * @param weight double type represent the weight of the Deer in kg
	 */
	public Deer(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Deer";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Deer
	 */
	public String getSound()
	{
		return ("");
	}

}