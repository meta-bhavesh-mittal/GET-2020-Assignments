package Animal.Mammal.Carnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Tiger"
 */
public class Tiger extends CarnivorousMammal 
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Tiger that zoo keeper gives 
	 * @param age double type represent the age of the Tiger in years
	 * @param weight double type represent the weight of the Tiger in kg
	 */
	public Tiger(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Tiger";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Tiger
	 */
	public String getSound() 
	{
		return "Roars";
	}

}