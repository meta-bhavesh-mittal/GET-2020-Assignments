package Session6.Employee;

public class Employee {

	private String name;
	private int age;
	private int salary;

	/**
	 * constructor for employee class
	 * @param name, employee name
	 * @param age, employee age
	 * @param salary, employee salary
	 */
	public Employee(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * @return employee name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return employee age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @return employee salary
	 */
	public int getSalary() {
		return salary;
	}

	public void setData(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String toString(){

		return "Employee Name : "+name+ " Employee Salary : "+salary+" Employee Age : "+age;
	}
}
