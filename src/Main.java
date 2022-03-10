import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        String userInput;
        boolean isShutdown = false;

        while (!isShutdown) {
            printMenu();
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    stepTracker.setDaySteps();
                    break;
                case "2":
                    stepTracker.printStats();
                    break;
                case "3":
                    stepTracker.changeStepGoal();
                    break;
                case "0":
                    isShutdown = true;
                    System.out.println("Программа завершена");
                    break;
                default:
                    System.out.println("Такой команды не существует");
                    break;
            }
        }
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

