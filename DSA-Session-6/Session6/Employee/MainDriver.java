package Session6.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDriver {
	public static void main(String[] args) {

		Scanner inputObj = new Scanner(System.in);
		EmployeeLinkedList listObj = new EmployeeLinkedList();

		String moreInput="";
		int choice = 0;
		do{
			System.out.println("Enter Your Choice\n1.Add an Employee\n2.Sort\n3.Display Employee List\n4.Exit");
			try{
				choice = inputObj.nextInt();
				switch(choice){
				case 1:
					do{
						inputObj.nextLine();
						System.out.println("Enter Employee Name :");
						String name = inputObj.nextLine();
						System.out.println("Enter Employee Age");
						int age = inputObj.nextInt();
						System.out.println("Enter Employee Salary :");
						int salary = inputObj.nextInt();
						Employee emp = new Employee(name, age, salary);
						listObj.insertEmployee(emp);
						System.out.println("Employee " + name + " added in the list\n");
						System.out.println("Do you want to enter more [yes/no]");
						moreInput=inputObj.next();
					}while(moreInput.equals("yes"));
					break;
				case 2:
					listObj.quickSort();
					System.out.println("List Sorted successfully \n");
					break;
				case 3:
					Node temp = listObj.getHead() ;
					System.out.println("Employee Name\tEmployee Age\tEmployee Salary");
					while(temp!=null) {
						System.out.println(temp.employee.getName()+"\t\t"+temp.employee.getAge()+"\t\t"+temp.employee.getSalary());
						temp=temp.next;
					}

					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("\nInvalid Choice  !! Try Again\n");
				}
				inputObj.nextLine();
			}catch(InputMismatchException exception){
				System.out.println("\nWarning , Please Enter only correct data Value \n");
				inputObj.nextLine();
			}
		}while(true);
	}



}