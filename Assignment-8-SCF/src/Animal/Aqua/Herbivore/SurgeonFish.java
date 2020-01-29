package Animal.Aqua.Herbivore;

/**
 * 
 * @author Nilesh Patel
 * This class represent the animal "Surgeon Fish"
 */
public class SurgeonFish extends HerbivoreAqua
{
	/**
	 * 
	 * This is a parameterized constructor which set the instance variable age,weight etc that this class inherit 
	 * @param uniqueName String represent unique name for Surgeon Fish that zoo keeper gives 
	 * @param age double type represent the age of the Surgeon Fish in years
	 * @param weight double type represent the weight of the Surgeon Fish in kg
	 */
	public SurgeonFish(String uniqueName, double age, double weight)
	{
		super();
		this.age = age;
		this.uniqueName = uniqueName;
		this.weight = weight;
		this.species = "SurgeonFish";
	}
	
	/**
	 * 
	 * This method return the String representation of the sound of the Surgeon Fish
	 */
	public String getSound(){
		return ("");
	}
}