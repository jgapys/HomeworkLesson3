import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = createNewCompany();
        System.out.println("First, add five new employees");
        addNewEmployee(5, company);
        chooseMenuOption(company);
    }

    private static Company createNewCompany() {
        ArrayList<Employee> allEmployees = new ArrayList<>();
        return new Company(allEmployees);
    }

    private static Employee getEmployeeFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee's first name");
        String firstName = scanner.nextLine();

        System.out.println("Enter employee's last name");
        String lastName = scanner.nextLine();

        System.out.println("Enter employee's salary");
        float salary = scanner.nextFloat();

        return new Employee(firstName, lastName, salary);
    }

    private static void addNewEmployee(int newEmployeesNumber, Company company) {
        for (int i = 0; i < newEmployeesNumber; i++) {
            System.out.println("Adding new employee");
            company.allEmployees.add(getEmployeeFromUser());
            System.out.println("Added new employee");
        }
    }

    private static void chooseMenuOption(Company company) {
        Scanner scanner = new Scanner(System.in);
        boolean nextOption = true;

        while (nextOption) {
            System.out.println("What do you want to do next? Please choose one of the following by entering the correct number:");
            System.out.println("1 - Print sum of all employees salary");
            System.out.println("2 - Display all employees data");
            System.out.println("3 - Add new employee");
            System.out.println("4 - End program");

            int userChoice = scanner.nextInt();
            if (!UserInputHandler.checkMenuOptions(userChoice)) {
                userChoice = scanner.nextInt();
            }

            switch (userChoice) {
                case 1 -> System.out.println("The sum of salaries of all employees is: "
                        + company.allEmployees.stream().mapToDouble(Employee::getSalary).sum());
                case 2 -> company.allEmployees.forEach(System.out::println);
                case 3 -> addNewEmployee(1, company);
                case 4 -> {
                    nextOption = false;
                    System.out.println("Bye!");
                }
            }
        }
    }
}