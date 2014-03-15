package equus.carbine.util;

import java.util.Collection;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

import equus.carbine.exception.OverFlowException;

public final class Math2 {

    private Math2() {}

    /**
     * Get sum.
     * 
     * @param values values
     * @return sum
     */
    public static double sum(double[] values) {
        Preconditions.checkNotNull(values);
        int size = values.length;
        if (size == 0) {
            return 0.0;
        }
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Get sum.
     * 
     * @param values values
     * @return sum
     */
    public static double sum(Collection<? extends Number> values) {
        return sum(Doubles.toArray(values));
    }

    /**
     * Get average.
     * 
     * @param values values
     * @return average
     */
    public static double average(double[] values) {
        Preconditions2.checkNotEmpty(values);
        double sum = sum(values);
        int size = values.length;
        return sum / size;
    }

    /**
     * Get average.
     * 
     * @param values values
     * @return average
     */
    public static double average(Collection<? extends Number> values) {
        return average(Doubles.toArray(values));
    }

    /**
     * Returns <tt>value<sup>n</sup></tt>.
     * <p>
     * The parameter {@code n} must be in the range -999999999 through 999999999, inclusive.
     * 
     * @param value value
     * @param n power to raise value to.
     * @return <tt>value<sup>n</sup></tt>
     */
    public static double power(double value, int n) {
        if (n < -999999999 || n > 999999999) {
            throw new IllegalArgumentException("Unsupported argument power value: " + n);
        }
        if (0 <= n) {
            return powerPositive(value, n);
        } else {
            return 1.0 / powerPositive(value, n * -1);
        }
    }

    private static double powerPositive(double value, int n) {
        double ret = 1;
        int unit = 4;
        if (n <= unit) {
            for (int i = 0; i < n; i++) {
                ret = ret * value;
                if (ret == Double.POSITIVE_INFINITY || ret == Double.NEGATIVE_INFINITY) {
                    throw new OverFlowException("reached double infinity. power with value:" + value + ", n:" + n);
                }
            }
            return ret;
        }
        ret = power(value, n / unit);
        ret = power(ret, unit);
        ret = ret * power(value, n % unit);
        return ret;
    }
}
