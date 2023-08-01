package employeemanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private List<Employee> employees;
    private int nextId;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        nextId = 1; // Initialize the ID counter
    }

    // Add new employee
    public void addEmployee(String name1, String position, double salary) {
        Employee employee = new Employee(nextId, name1, position, salary);
        employees.add(employee);
        nextId++;
    }

    // View all employees
    public void viewEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.getName1());
        }
    }

    // Update employee details
    public void updateEmployee(int id, String name1, String position, double salary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName1(name1);
                employee.setPosition(position);
                employee.setSalary(salary);
                System.out.println("Employee details updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    // Delete employee
    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    // Main method to run the program
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Details");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter employee name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter employee position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    System.out.println("Employees Data Added Successfully");
                    system.addEmployee(name1, position, salary);
                    break;
                case 2:
				system.viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter updated name: ");
                    name1 = scanner.nextLine();
                    System.out.print("Enter updated position: ");
                    position = scanner.nextLine();
                    System.out.print("Enter updated salary: ");
                    salary = scanner.nextDouble();
                    system.updateEmployee(id, name1, position, salary);
                    break;
                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    system.deleteEmployee(id);
                    break;
                case 5:
                    System.out.println("Exiting the Employee Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

	
}

