public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        System.out.println("First, add five new employees");
        int newEmployeesNumber = 5;
        for (int i = 0; i < newEmployeesNumber; i++) {
            company.addNewEmployee(UserInputHandler.getEmployeeFromUser());
        }
        chooseMenuOption(company);
    }

    private static void chooseMenuOption(Company company) {
        while (true) {
            System.out.println("What do you want to do? Please choose one of the following by entering the correct number:");
            System.out.println("1 - Print sum of all employees salary");
            System.out.println("2 - Display all employees data");
            System.out.println("3 - Add new employee");
            System.out.println("4 - End program");

            switch (UserInputHandler.checkMenuChoice()) {
                case 1 -> company.getSalariesSumOfAllEmployees();
                case 2 -> company.printAllEmployeesInfo();
                case 3 -> company.addNewEmployee(UserInputHandler.getEmployeeFromUser());
                case 4 -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }
            }
        }
    }
}