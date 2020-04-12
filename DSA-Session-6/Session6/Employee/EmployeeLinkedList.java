package Session6.Employee;

public class EmployeeLinkedList {
	
	
	private Node head ;
	private Node last;
	private int size = 0;

	public EmployeeLinkedList() {
		this.last = null;
	}

	/**
	 * insert employee in list
	 * @param employee to be inserted in linkedList
	 */
	public void insertEmployee(Employee employee) {
		Node newNode = new Node(employee);
		// if list is empty
		if (last == null) {
			head = newNode;
			last = newNode;
		}
		// enter employee at last index
		else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	
	/**
	 * @param index of employee linked list
	 * @return employee on index
	 */
	private Employee get(int index) {
		//check index is valid or not
		if (index < size) {
			Node curr = getHead();
			for (int count_i = 0; count_i < index; count_i++)
				curr = curr.next;
			return curr.employee;
		} else
			throw new AssertionError("index out of bound");
	}

	
	/**
	 * sort employees by quick sort algorithm
	 */
	void quickSort() {
		sort(0, size - 1);
	}

	/**
	 * method called by quickSort
	 * @param low index of employee list
	 * @param high index of employee list
	 */
	private void sort(int low, int high) {
		if (low < high) {
			int mid = partition(low, high);
			//recursive call
			sort(low, mid - 1);
			sort(mid + 1, high);
		}
	}

	/**
	 * partition method for quick Sort
	 * @param low index of employee list
	 * @param high index of employee list
	 * @return position of partition
	 */
	private int partition(int low, int high) {
		
		Employee pivot = get(high);
		int index = (low - 1);
		
		for (int index2 = low; index2 < high; index2++) {
			//check any employee has salary greater than pivot
			if (get(index2).getSalary() >= pivot.getSalary()) {
				//if salary is same than compare age
				if(get(index2).getSalary() == pivot.getSalary() && get(index2).getAge() > pivot.getAge())
					continue;
				index++;
				//swap data of employees
				String name = get(index).getName();
				int age = get(index).getAge();
				int salary = get(index).getSalary();
				get(index).setData(get(index2).getName(), get(index2).getAge(), get(index2).getSalary());
				get(index2).setData(name, age, salary);
			}
		}
		
		// set pivot employee on his correct position
		String name = get(index + 1).getName();
		int age = get(index + 1).getAge();
		int salary = get(index + 1).getSalary();
		get(index + 1).setData(get(high).getName(), get(high).getAge(), get(high).getSalary());
		get(high).setData(name, age, salary);
		return index + 1;
	}

	/**
	 * return employee name list
	 */
	public String[] getEmployeeList() {
		String[] employees = new String[size];
		Node curr = getHead().next;
		int count = 0;
		while (curr != null && count < size) {
			employees[count] = curr.employee.getName();
			curr = curr.next;
			count++;
		}
		return employees;
	}

	public Node getHead() {
		return head;
	}

}