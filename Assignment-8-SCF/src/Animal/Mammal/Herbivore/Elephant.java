package Animal.Mammal.Herbivore;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Elephant"
 */
public class Elephant extends HerbivorousMammal
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Elephant that zoo keeper gives 
	 * @param age double type represent the age of the Elephant in years
	 * @param weight double type represent the weight of the Elephant in kg
	 */
	public Elephant(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Elephant";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Elephant
	 */
	public String getSound()
	{
		return ("");
	}
}
