package employeemanagement;

public class Employee {
    private int id;
    private String name1;
    private String position;
    private double salary;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(int id, String name1, String position, double salary) {
		super();
		this.id = id;
		this.name1 = name1;
		this.position = position;
		this.salary = salary;
	}

	public int getEmployeeId() {
		// TODO Auto-generated method stub
		return 0;
	}

  
}
