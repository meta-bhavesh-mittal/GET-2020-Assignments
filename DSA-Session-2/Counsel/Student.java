package Session2.Counsel;

public class Student {
	private String name;
	private String[] programs;
	private String programAllocated;
	
	public Student(String name, String[] programs) {
		super();
		this.name = name;
		this.programs = programs;
		this.programAllocated = "not allocated";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getPrograms() {
		return programs;
	}

	public void setPrograms(String[] programs) {
		this.programs = programs;
	}

	public String getProgramAllocated() {
		return programAllocated;
	}

	public void setProgramAllocated(String programAllocated) {
		this.programAllocated = programAllocated;
	}
	

}
