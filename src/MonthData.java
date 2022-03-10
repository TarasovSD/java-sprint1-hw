import java.util.HashMap;

public class MonthData {
    HashMap<Integer, Integer> dayStepCountMap = new HashMap<>();

    public MonthData() {
        for (int i = 1; i <= 30; i++) {
            dayStepCountMap.put(i, 0);
        }
    }

    //Ввод количества шагов за день
    public void enterDayStepCount(int dayNumber, int stepCount) {
        dayStepCountMap.put(dayNumber, stepCount);
    }

    //Печать количества пройденных шагов по дням
    public void printData() {
        String result = "";
        for (int i = 1; i <= 30; i++) {
            Integer stepCount = dayStepCountMap.get(i);
            if (stepCount != 0) {
                if (i != 30) {
                    result += "" + i + " день: " + stepCount + ", ";
                }
                if (i == 30) {
                    result += "" + i + " день: " + stepCount;
                }
            }
        }
        System.out.println(result);
        System.out.println();
    }

    //Вычисление суммы пройденных шагов за месяц
    public int sumOfStepsPerMonth() {
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        return sum;
    }

    //Вычисление среднего количества шагов за месяц
    public double averageNumberOfStepsPerMonth() {
        int sum = 0;
        int numberOfDays = 30;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        double averageNumberOfSteps = sum / numberOfDays;
        return averageNumberOfSteps;
    }

    //Вычисление максимального пройденного количества шагов в месяце
    public int maxNumberOfStepsPerMonth() {
        int maxCount = 0;
        for (int i = 1; i <= 30; i++) {
            if (dayStepCountMap.get(i) > maxCount) {
                maxCount = dayStepCountMap.get(i);
            }
        }
        return maxCount;
    }

    //Вычисление пройденной дистанции за месяц (в км)
    public double distancePerMonth() {
        Converter converter = new Converter();
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        double distanceTraveled = converter.stepCountToDistance(sum);
        return distanceTraveled;
    }

    //Вычисление количества сожжённых за месяц килокалорий
    public double burnnedCaloriesPerMonth() {
        Converter converter = new Converter();
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        double burnedCalories = converter.stepCountToBurnedCalories(sum);
        return burnedCalories;
    }

    //Вычисление максимальное количества подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого
    public int getTheBestSeries(int currentStepGoal) {
        int theBestSeriesCount = 0;
        int currentStepCount = 0;
        for (int i = 1; i <= 30; i++) {
            int stepCount = dayStepCountMap.get(i);
            if (stepCount >= currentStepGoal) {
                currentStepCount++;
            } else {
                if (currentStepCount > theBestSeriesCount) {
                    theBestSeriesCount = currentStepCount;
                }
                currentStepCount = 0;
            }
        }
        return theBestSeriesCount;
    }
}
