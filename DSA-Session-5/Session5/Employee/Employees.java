package Session5.Employee;

public class Employees {
	public EmpNode headEmloye = null;
	EmpNode sorted;


	public void insertIntoEmployee(String name, int salary, int age) {
		EmpNode newNode = new EmpNode(name, age, salary);
		if (headEmloye == null) {
			headEmloye = newNode;
		} else {
			EmpNode temp = headEmloye;
			while (temp.nextEmployee != null) {
				temp = temp.nextEmployee;
			}
			temp.nextEmployee = newNode;
		}
	}


	public void printList() {
		if(this.headEmloye == null){
			System.out.println("Empty list");
		}
		EmpNode head= headEmloye;
		while(head !=null){
			System.out.println(head.salary+","+head.age+"-->");
			head= head.nextEmployee;
		}
	}


	public void insertionSort() {
		sorted = null;
		EmpNode current = headEmloye;
		while (current != null) {
			EmpNode next = current.nextEmployee;
			sortedInsert(current);
			current = next;
		}

		this.headEmloye = sorted;
	} 


	void sortedInsert(EmpNode newnode) {

		if (sorted == null || sorted.salary < newnode.salary)
		{
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} 
		else if (sorted.salary == newnode.salary && sorted.age > newnode.age)
		{
			newnode.nextEmployee = sorted;
			sorted = newnode;
		}
		else
		{
			EmpNode current = sorted;
			while (current.nextEmployee != null
					&& current.nextEmployee.salary > newnode.salary)
			{
				current = current.nextEmployee;
			}
			newnode.nextEmployee = current.nextEmployee;
			current.nextEmployee = newnode;
		}
	}
	public static void main(String[] args)
	{
		Employees e = new Employees();
		e.insertIntoEmployee("Bhavesh", 5, 21);
		e.insertIntoEmployee("Bhavesh", 15, 22);
		e.insertIntoEmployee("Bhavesh", 2, 10);
		e.insertIntoEmployee("Bhavesh", 2, 20);
		e.insertIntoEmployee("Bhavesh", 1, 25);
		e.insertionSort();
		e.printList();

	}
}