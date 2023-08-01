package abs;

abstract class Employee {
    private int empId;
    private String name;
    private String designation;
    private double salary;

    public Employee(int empId, String name, String designation, double salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayDetails();

    // Getters and Setters (omitted for brevity)

    @Override
    public String toString() {
        return "Employee ID: " + empId +
               "\nName: " + name +
               "\nDesignation: " + designation +
               "\nSalary: " + salary;
    }
}

class Manager extends Employee {
    private String department;

    public Manager(int empId, String name, String designation, double salary, String department) {
        super(empId, name, designation, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager Details:");
        System.out.println(this);
        System.out.println("Department: " + department);
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int empId, String name, String designation, double salary, String programmingLanguage) {
        super(empId, name, designation, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        System.out.println("Developer Details:");
        System.out.println(this);
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

 class main {
    public static void main(String[] args) {
        Employee manager = new Manager(1, "John Doe", "Manager", 50000, "Sales");
        Employee developer = new Developer(2, "Jane Smith", "Developer", 40000, "Java");

        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
    }
}
