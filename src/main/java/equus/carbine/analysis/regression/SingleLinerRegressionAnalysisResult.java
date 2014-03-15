package equus.carbine.analysis.regression;

import lombok.Value;

@Value
public class SingleLinerRegressionAnalysisResult {

    double intercept;

    double slope;

    /** r ^ 2 : r (coefficient of correlation) */
    double r2;

    long sampleNumber;

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return this.getClass().getName() + " [intercept=" + intercept + ", r2=" + r2 + ", sampleNumber=" + sampleNumber
                        + ", slope=" + slope + "]";
    }

    /**
     * Calculate y from x.
     * 
     * @param x x
     * @return y
     */
    public double calcY(final double x) {
        return intercept + slope * x;
    }

    /**
     * Calculate x from y.
     * 
     * @param y y
     * @return x
     */
    public double calcX(final double y) {
        return (y - intercept) / slope;
    }
}
