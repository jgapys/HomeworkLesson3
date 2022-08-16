import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHandler {
    public static boolean checkFirstNameAndLastNameCorrectness(String userInput) {
        String regEx = "^[a-zA-Z ]*$";
        return userInput.matches(regEx);
    }

    public static boolean checkSalaryCorrectness(String userInput) {
        String regEx = "\\d+(\\.\\d+)?";
        return userInput.matches(regEx);
    }

    public static int checkMenuChoice() {
        int menuOption = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            int[] possibleMenuOptions = {1, 2, 3, 4};
            int userMenuChoice = scanner.nextInt();
            if (Arrays.stream(possibleMenuOptions).anyMatch(i -> i == userMenuChoice)) {
                menuOption = userMenuChoice;
            } else {
                System.out.println("Sorry, you entered the wrong number. The number must be 1, 2, 3 or 4.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Sorry, you entered the wrong type of data. The entered data should be the number 1, 2, 3 or 4.");
        }
        return menuOption;
    }
}
