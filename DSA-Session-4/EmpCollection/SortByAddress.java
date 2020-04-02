package Session4.EmpCollection;

import java.util.Comparator;

public class SortByAddress implements Comparator<Employee>
{

	@Override
	public int compare(Employee empAdd1, Employee empAdd2) {
		
		return empAdd1.address.compareTo(empAdd2.address);
	}
	

}
