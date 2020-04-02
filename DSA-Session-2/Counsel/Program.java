package Session2.Counsel;

public class Program {
	
	private String name;
	private int capacity;
	private int allocated;
	
	public Program(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.allocated = 0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAllocated() {
		return allocated;
	}

	public void setAllocated(int allocated) {
		this.allocated = allocated;
	}

}
