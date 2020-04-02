package Session4.EmpCollection;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>
{
	
	@Override
	public int compare(Employee empName1, Employee empName2)
	{
		return empName1.empName.compareTo(empName2.empName);
	}
	
}
