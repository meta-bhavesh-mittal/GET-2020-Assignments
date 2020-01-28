package Animal.Reptile.Carnivorous;

import Animal.Reptile.Reptile;

/**
 * 
 * @author Nilesh Patel
 * This class represent Carnivorous Reptiles
 */
public abstract class CarnivorousReptile extends Reptile 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousReptile()
	{
		super.subCategory = "Carnivorous";
	}

}