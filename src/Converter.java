public class Converter {
    double stepLengthInMetres = 0.75;
    double metresInKm = 1000;
    double kiloCaloriesPerStep = 0.05;

    //Вычисление пройденной дистанции в км
    public double stepCountToDistance(int totalStepCount) {
        double distanceInKm = totalStepCount * stepLengthInMetres / metresInKm;
        return distanceInKm;
    }

    //Вычисление количества сожженных килокаллорий
    public double stepCountToBurnedCalories(int totalStepCount) {
        return totalStepCount * kiloCaloriesPerStep;
    }
}
