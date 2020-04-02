package Session4.EmpCollection;

import java.util.Comparator;

public class SortById implements Comparator<Employee>
{

	@Override
	public int compare(Employee empId1, Employee empId2)
	{
		return empId1.empId - empId2.empId;
	}
	

}
