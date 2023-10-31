                            /*Employee Payroll System*/
import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

// Abstract class
abstract class Employee {
    private String name;
    private int id;

    // Constructor
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // abstract method
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }

}

// inheritance
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        // because we are using parent class constructor so we have to use super kryword
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    //@Override

    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    //@Override

    public double calculateSalary() {
        return (hourlyRate * hourlyRate);
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();

    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);

    }

    // remove employee by their id
    public void removeEmployee(int id) {
        Employee employeeToEmployee = null;

        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToEmployee = employee;
                break;
            }
        }
        if (employeeToEmployee != null) {
            employeeList.remove(employeeToEmployee);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class JavaProject {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("AMAN", 1020, 100000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("Ankit", 1024, 100000.0);
        FullTimeEmployee emp3 = new FullTimeEmployee("Deepak", 1029, 50000.0);
        FullTimeEmployee emp4 = new FullTimeEmployee("Shivam", 1028, 70000.0);
        FullTimeEmployee emp5 = new FullTimeEmployee("Shubham", 1025, 90000.0);
        FullTimeEmployee emp6 = new FullTimeEmployee("Vishu", 1022, 23000.0);

        PartTimeEmployee emp7 = new PartTimeEmployee("Vipin", 2078, 120, 100);
        PartTimeEmployee emp8 = new PartTimeEmployee("Rakesh", 2079, 84, 100);
        PartTimeEmployee emp9 = new PartTimeEmployee("Jivan", 2080, 78, 100);
        PartTimeEmployee emp10 = new PartTimeEmployee("Ram", 2081, 24, 100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        payrollSystem.addEmployee(emp9);
        payrollSystem.addEmployee(emp10);

        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();

        System.out.println("Removing Employee: ");
        payrollSystem.removeEmployee(1028);
        payrollSystem.removeEmployee(2080);
        payrollSystem.removeEmployee(2079);
        System.out.println(" ");
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployees();

    }
}