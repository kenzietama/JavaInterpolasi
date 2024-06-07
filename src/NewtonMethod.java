public class NewtonMethod {

    // Method to calculate the coefficients of the Newton polynomial
    private static double[] calculateCoefficients(double[] x, double[] y) {
        int n = x.length;
        double[] coefficients = new double[n];

        // Initialize the coefficients with the y-values
        for (int i = 0; i < n; i++) {
            coefficients[i] = y[i];
        }

        // Calculate the divided differences
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                coefficients[j] = (coefficients[j] - coefficients[j - 1]) / (x[j] - x[j - i]);
            }
        }

        return coefficients;
    }

    // Method to evaluate the Newton polynomial at a given x-value
    public static double evaluateNewtonPolynomial(double[] x, double[] coefficients, double xVal) {
        double result = coefficients[coefficients.length - 1];
        for (int i = coefficients.length - 2; i >= 0; i--) {
            result = result * (xVal - x[i]) + coefficients[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        double[] x = {5, 10, 15, 20, 25, 30, 35, 40};
        double[] y = {40, 30, 25, 40, 18, 20, 22, 15};

        //interpolation value
        double xVal = 0;

        //output array
        double start = 5;
        double end = 40;

        // Calculate coefficients
        double[] coefficients = calculateCoefficients(x, y);

        // Evaluate the Newton polynomial at a specific x-value
        System.out.println("Nilai interpolasi pada 5<=x<=40 adalah:");
        for(xVal = start; xVal <= end; xVal++) {
            System.out.print("x = " + xVal + " -> ");
            System.out.println(evaluateNewtonPolynomial(x, coefficients, xVal));
        }
    }
}
