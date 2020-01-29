package Animal.Mammal.Omnivorous;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Chimpanzee"
 */
public class Chimpanzee extends OmnivorousMammal 
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Chimpanzee that zoo keeper gives 
	 * @param age double type represent the age of the Chimpanzee in years
	 * @param weight double type represent the weight of the Chimpanzee in kg
	 */
	public Chimpanzee(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "Chimpanzee";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Chimpanzee
	 */
	public String getSound()
	{
		return ("");
	}
}