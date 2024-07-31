public class FinancialForecastingTool {

    // Recursive method to predict future value
    public static double predictFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if periods is 0, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: calculate the future value for the current period
        return predictFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // Growth rate (5%)
        int periods = 10; // Number of periods (e.g., years)

        double futureValue = predictFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
    }
}
