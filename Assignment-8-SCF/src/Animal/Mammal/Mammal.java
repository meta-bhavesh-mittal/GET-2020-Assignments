package Animal.Mammal;

import Animal.Animal;

/**
 * 
 * @author Nilesh Patel
 * This class represent Mammals
 */
abstract public class Mammal extends Animal 
{
	/**
	 * 
	 * default constructor set the category of this type of animal to "Mammal"
	 */
	protected Mammal()
	{
		super.category = "Mammal";
	}
}