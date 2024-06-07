import java.util.ArrayList;
import java.util.Scanner;

public class LagrangeMethod {

    // Function to calculate the Lagrange polynomial
    public static double lagrangeInterpolation(double[] x, double[] y, double xVal) {
        double result = 0;

        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term = term * (xVal - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        double[] x = {5, 10, 15, 20, 25, 30, 35, 40};
        double[] y = {40, 30, 25, 40, 18, 20, 22, 15};

        //interpolation value
        double xVal = 0;

        //output array
        double start = 5;
        double end = 40;

        //perform lagrange interpolation
        System.out.println("Nilai interpolasi pada 5<=x<=40 adalah:");
        for(xVal = start; xVal <= end; xVal++) {
            System.out.print("x = " + xVal + " -> ");
            System.out.println(lagrangeInterpolation(x, y, xVal));
        }
    }
}
