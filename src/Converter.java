public class Converter {
    double stepLengthInMetres = 0.75;
    double metresInKm = 1000;
    double kiloCaloriesPerStep = 0.05;

    public double stepCountToDistance (int totalStepCount) {
        double distanceInKm = totalStepCount * stepLengthInMetres/metresInKm;
        return distanceInKm;
    }

    public double stepCountToBurnedCalories(int totalStepCount) {
        return totalStepCount * kiloCaloriesPerStep;
    }
}
