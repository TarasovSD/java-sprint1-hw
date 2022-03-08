import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthData {
    HashMap<Integer, Integer> dayStepCountMap = new HashMap<Integer, Integer>();

    public MonthData () {
        for (int i = 1; i <= 30; i++ ) {
            dayStepCountMap.put(i, 0);
        }
    }

    //Ввод количества шагов за день
    public void enterDayStepCount(int dayNumber, int stepCount) {;
        dayStepCountMap.put(dayNumber, stepCount);
    }

    public void printData() {
        String result = "";
        for (int i = 1; i <= 30; i++ ) {
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

    public int sumOfStepsPerMonth(){
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        return sum;
    }

    public double averageNumberOfStepsPerMonth(){
        int sum = 0;
        int numberOfDays = 30;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        double averageNumberOfSteps = sum/numberOfDays;
        return averageNumberOfSteps;
    }

    public int maxNumberOfStepsPerMonth(){
        int maxCount = 0;
        for (int i = 1; i <= 30; i++) {
            if (dayStepCountMap.get(i) > maxCount) {
                maxCount = dayStepCountMap.get(i);
            }
        }
        return maxCount;
    }

    public double distancePerMonth() {
        Converter converter = new Converter();
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        double distanceTraveled = converter.findDistance(sum);
        return distanceTraveled;
    }

    public double burnnedCaloriesPerMonth(){
        Converter converter = new Converter();
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum = sum + dayStepCountMap.get(i);
        }
        double burnedCalories = converter.findBurnedCalories(sum);
        return burnedCalories;
    }


}
