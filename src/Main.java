import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                stepTracker.setDaySteps();
            } else if (userInput == 2) {
                stepTracker.printStats();
            } else if (userInput == 3) {
                stepTracker.changeStepGoal();
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Такой команды не существует");
            }
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("--------------------Меню-----------------------");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
        System.out.println("------------------------------------------------");
        System.out.print("Введите номер пункта меню и нажмите ENTER: ");

    }
}

