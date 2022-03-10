import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    int currentStepGoal = 10000;
    HashMap<Integer, MonthData> monthToDataMap = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            monthToDataMap.put(i, new MonthData());
        }
    }

    // п.2 меню - Напечатать статистику за определённый месяц.
    public void printStats() {
        System.out.println("Номер месяца, за который хотите увидеть статистику и нажмите ENTER");
        int monthNumberForPrint = getUserInput();
        System.out.println("Месяц " + monthNumberForPrint);
        MonthData monthData = monthToDataMap.get(monthNumberForPrint);
        monthData.printData();
        System.out.println("Количество пройденных шагов за месяц: " + monthData.sumOfStepsPerMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxNumberOfStepsPerMonth());
        System.out.println("Среднее количество шагов за месяц: " + monthData.averageNumberOfStepsPerMonth());
        System.out.println("Пройденная дистанция (в км): " + monthData.distancePerMonth());
        System.out.println("Количество сожжённых килокалорий: " + monthData.burnnedCaloriesPerMonth());
        System.out.println("Лучшая серия: " + monthData.getTheBestSeries(currentStepGoal));
    }

    // п.1 меню - Ввести количество шагов за определённый день.
    public void setDaySteps() {
        System.out.println("Введите номер месяца (1 - январь, 12 - декабрь): ");
        int monthNumber = getUserInput();
        while (true) {
            if (monthNumber < 1 || monthNumber > 12) {
                System.out.println("В году не бывает " + monthNumber + " месяца. Введите число от 1 до 12");
                monthNumber = getUserInput();
            } else {
                break;
            }
        }
        System.out.println("Введите число (от 1 до 30): ");
        int dayNumber = getUserInput();
        while (true) {
            if (dayNumber < 1 || dayNumber > 30) {
                System.out.println("Нужно ввести число от 1 до 30");
                dayNumber = getUserInput();
            } else {
                break;
            }
        }
        System.out.println("Введите количество пройденных шагов: ");
        int stepCount = getUserInput();
        while (true) {
            if (stepCount < 0) {
                System.out.println("Количество шагов не может быть отрицательным. Введите корректное значение.");
                stepCount = getUserInput();
            } else {
                break;
            }
        }
        MonthData monthData = monthToDataMap.get(monthNumber);
        monthData.enterDayStepCount(dayNumber, stepCount);
        System.out.println("Данные за " + monthNumber + " месяц изменены.");
    }

    // п.3 меню - Изменить целевое количество шагов.
    public void changeStepGoal() {
        System.out.println("Текущая цель " + currentStepGoal + " шагов.");
        while (true) {
            System.out.println("Введите новую цель в шагах (0 - для возврата в главное меню): ");
            int userInput = getUserInput();
            if (userInput == 0) {
                break;
            }
            if (userInput > 0) {
                currentStepGoal = userInput;
                break;
            } else {
                System.out.println("Введите число больше 0!");
            }
        }
        System.out.println("Ваша цель - " + currentStepGoal + " шагов!");
    }

    //Отсечение ввода текста
    public int getUserInput() {
        while (true) {
            try {
                String userInput = scanner.nextLine();
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
            }
        }
    }
}
