package Session5.Employee;

public class EmpNode {
	String name;
    int age;
    int salary;
    EmpNode nextEmployee;

    EmpNode(String name, int age, int salary) {
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.nextEmployee = null;
    }

}
