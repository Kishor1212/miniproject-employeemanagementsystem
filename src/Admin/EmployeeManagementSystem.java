package Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import employeemanagement.Employee;

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getEmployeeId() == employeeId);
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("List of Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System - Admin Page");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading the integer
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character after reading the double

                    ems.addEmployee(new Employee(employeeId, name, position, salary));
                    System.out.println("Employee added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    int empIdToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading the integer
                    ems.removeEmployee(empIdToRemove);
                    System.out.println("Employee removed successfully.");
                    break;
                case 3:
                    ems.displayAllEmployees();
                    break;
                case 4:
                    System.out.println("Exiting the admin page. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
