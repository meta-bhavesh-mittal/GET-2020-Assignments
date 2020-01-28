package Animal.Mammal.Carnivorous;

import Animal.Mammal.Mammal;

/**
 * 
 * @author Nilesh Patel
 * This class represent Carnivorous Mammals
 */
abstract class CarnivorousMammal extends Mammal 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousMammal()
	{
		super.subCategory = "Carnivorous";
	}
}