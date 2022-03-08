import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    int currentStepGoal = 10000;
    HashMap<Integer, MonthData> monthToDataMap = new HashMap<Integer, MonthData>();
    Scanner scanner = new Scanner(System.in);

    public StepTracker() {
        for (int i = 1; i <= 12; i++ ) {
            monthToDataMap.put(i, new MonthData());
        }
    }

    // п.2 меню - Напечатать статистику за определённый месяц.
    public void printStats() {
        System.out.println("Номер месяца, за который хотите увидеть статистику и нажмите ENTER");
        int monthNumberForPrint = scanner.nextInt();
            System.out.println("Месяц " + monthNumberForPrint);
            MonthData monthData = monthToDataMap.get(monthNumberForPrint);
            monthData.printData();
        System.out.println("Количество пройденных шагов за месяц: " + monthData.sumOfStepsPerMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxNumberOfStepsPerMonth());
        System.out.println("Среднее количество шагов за месяц: " + monthData.averageNumberOfStepsPerMonth());
        System.out.println("Пройденная дистанция (в км): " + monthData.distancePerMonth());
        System.out.println("Количество сожжённых килокалорий: " + monthData.burnnedCaloriesPerMonth());

    }

    // п.1 меню - Ввести количество шагов за определённый день.
    public void setDaySteps() {
        System.out.println("Введите номер месяца (1 - январь, 12 - декабрь): ");
        int monthNumber = scanner.nextInt();
        while (true) {
            if (monthNumber < 1 || monthNumber > 12) {
                System.out.println("В году не бывает " + monthNumber + " месяца. Введите число от 1 до 12");
                monthNumber = scanner.nextInt();
            } else {
                break;
            }
        }
        System.out.println("Введите число (от 1 до 30): ");
        int dayNumber = scanner.nextInt();
        while (true) {
            if (dayNumber < 1 || dayNumber > 30) {
                System.out.println("Нужно ввести число от 1 до 30");
                dayNumber = scanner.nextInt();
            } else {
                break;
            }
        }
        System.out.println("Введите количество пройденных шагов: ");
        int stepCount = scanner.nextInt();
        while (true) {
            if (stepCount < 0) {
                System.out.println("Количество шагов не может быть отрицательным. Введите корректное значение.");
                stepCount = scanner.nextInt();
            } else {
                break;
            }
        }
        MonthData monthData = monthToDataMap.get(monthNumber);
        monthData.enterDayStepCount(dayNumber, stepCount);
        System.out.println("Данные за " + monthNumber + " месяц изменены." );
    }

    // п.3 меню - изменить целевое количество шагов.
    public void changeStepGoal() {
        System.out.println("Текущая цель " + currentStepGoal + " шагов.");
        while (true) {
            System.out.println("Введите новую цель в шагах (0 - для возврата в главное меню): ");
            int userInput = scanner.nextInt();
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
}
