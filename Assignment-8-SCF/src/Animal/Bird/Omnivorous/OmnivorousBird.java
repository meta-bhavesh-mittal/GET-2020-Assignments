package Animal.Bird.Omnivorous;

import Animal.Bird.Bird;

/**
 * 
 * @author Nilesh Patel
 * This class represent Omnivorous Birds
 */
public abstract class OmnivorousBird extends Bird 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousBird()
	{
		super.subCategory = "Omnivorous";
	}

}