package Animal.Mammal.Herbivore;

import Animal.Mammal.Mammal;

/**
 * 
 * @author Nilesh Patel
 * This class represent Herbivorous Mammals
 */
abstract class HerbivorousMammal extends Mammal 
{	
	/**
	 * 
	 * default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivorousMammal()
	{
		super.subCategory = "Herbivorous";
	}
}
