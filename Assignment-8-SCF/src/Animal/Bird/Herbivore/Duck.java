package Animal.Bird.Herbivore;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Duck"
 */
public class Duck extends HerbivoreBird 
{	
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Duck that zoo keeper gives 
	 * @param age double type represent the age of the Duck in years
	 * @param weight double type represent the weight of the Duck in kg
	 */
	public Duck(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Duck";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Duck
	 */
	public String getSound()
	{
		return ("");
	}
}