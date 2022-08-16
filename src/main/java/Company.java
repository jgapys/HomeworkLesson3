import java.util.ArrayList;

public class Company {
    private final ArrayList<Employee> allEmployees;

    public Company() {
        this.allEmployees = new ArrayList<>();
    }

    public void addNewEmployee(Employee employee) {
        allEmployees.add(employee);
        System.out.println("Added new employee");
    }

    public void getSalariesSumOfAllEmployees() {
        double salariesSum = allEmployees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("The sum of salaries of all employees is: " + salariesSum);
    }

    public void printAllEmployeesInfo() {
        allEmployees.forEach(System.out::println);
    }
}