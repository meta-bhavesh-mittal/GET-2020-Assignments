package Session4.EmpCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainEmployee {

	public static void main(String[] args) {

		List<Employee> listEmployee = new ArrayList<Employee>();

		listEmployee.add(new Employee(1, "Ayush", "Bhilwara"));
		listEmployee.add(new Employee(2, "Bhavesh", "Alwar"));
		listEmployee.add(new Employee(3, "Keyur", "Dungarpur"));
		listEmployee.add(new Employee(4, "Ashish", "Agra"));
		listEmployee.add(new Employee(5, "Harshit", "Gurugram"));
		

		//Sorting by id
		Collections.sort(listEmployee, new SortById());

		for(int i=0;i<listEmployee.size();i++){
			System.out.println(listEmployee.get(i).empId + "\t"
					+ listEmployee.get(i).empName + "\t\t"
					+ listEmployee.get(i).address);
		}
		System.out.println();
		
		//Sorting by Name
		Collections.sort(listEmployee, new SortByName());
		
		for(int i=0;i<listEmployee.size();i++){
			System.out.println(listEmployee.get(i).empId + "\t"
					+ listEmployee.get(i).empName + "\t\t"
					+ listEmployee.get(i).address);
		}
		System.out.println();
		
		//Sorting by address
		Collections.sort(listEmployee, new SortByAddress());
		
		for(int i=0;i<listEmployee.size();i++){
			System.out.println(listEmployee.get(i).empId + "\t"
					+ listEmployee.get(i).empName + "\t\t"
					+ listEmployee.get(i).address);
		}
		System.out.println();
		
	}

}
