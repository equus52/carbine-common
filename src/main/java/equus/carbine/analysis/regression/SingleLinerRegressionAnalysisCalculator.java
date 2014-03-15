package equus.carbine.analysis.regression;

import java.util.List;

import equus.carbine.data.Coordinate;
import equus.carbine.util.Math2;
import equus.carbine.util.Preconditions2;

public class SingleLinerRegressionAnalysisCalculator {

    public SingleLinerRegressionAnalysisResult analysis(final List<Coordinate> values) {
        Preconditions2.checkNotEmpty(values);
        int size = values.size();
        double[] x = new double[size];
        double[] y = new double[size];
        for (int i = 0; i < size; i++) {
            Coordinate coordinate = values.get(i);
            x[i] = coordinate.getX();
            y[i] = coordinate.getY();
        }
        double averageX = Math2.average(x);
        double averageY = Math2.average(y);

        double covariation = 0;
        for (int i = 0; i < size; i++) {
            covariation += (x[i] - averageX) * (y[i] - averageY);
        }

        double variationX = 0;
        for (int i = 0; i < size; i++) {
            variationX += Math2.power(x[i] - averageX, 2);
        }

        double slope = covariation / variationX;
        double intercept = averageY - slope * averageX;

        double a = 0.0;
        double b = 0.0;
        for (int i = 0; i < size; i++) {
            a += Math2.power(y[i] - (slope * x[i] + intercept), 2);
            b += Math2.power(y[i] - averageY, 2);
        }
        double r2 = 1.0 - a / b;
        return new SingleLinerRegressionAnalysisResult(intercept, slope, r2, size);
    }
}
