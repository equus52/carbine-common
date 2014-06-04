package equus.carbine.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

import org.junit.Test;

import equus.carbine.exception.OverFlowException;

public class Math2Test {

  private double[] getDoubleArray(int count) {

    double[] values = new double[count];
    for (int i = 0; i < values.length; i++) {
      values[i] = i;
    }
    return values;
  }

  private List<Double> getDoubleList(int count) {

    List<Double> values = new ArrayList<Double>();
    for (int i = 0; i < count; i++) {
      values.add(Double.valueOf(i));
    }
    return values;
  }

  @Test
  public void testPrivateConstractor() {
    TestUtils.privateConstractor(Math2.class).newInstance();
  }

  @Test
  public void testSumDoubleArray0() {

    int count = 100000;
    double[] values = getDoubleArray(count);
    double actual = Math2.sum(values);
    double expected = ((double) count + 1) * count / 2;
    assertEquals(expected, actual, expected * 0.0001);
  }

  @Test
  public void testSumDoubleArray1() {

    int count = 0;
    double[] values = getDoubleArray(count);
    double actual = Math2.sum(values);
    double expected = 0.0;
    assertEquals(expected, actual, expected * 0.000001);
  }

  @Test
  public void perfSumDoubleArray() {

    int count = 100000;
    final double[] values = getDoubleArray(count);
    int roop = 10;
    double actual = TestUtils.getMilliTime(new Runnable() {

      @Override
      public void run() {
        Math2.sum(values);
      }
    }, roop);
    System.out.println("equus.carbine.util.MathUtil.sum(double[]) actual time is " + actual / roop + "(ms)");
    double actual2 = TestUtils.getMilliTime(new Runnable() {

      @Override
      public void run() {
        DoubleStream.of(values).sum();
      }
    }, roop);
    System.out.println("equus.carbine.util.MathUtil.sum(double[]) actual2 time is " + actual2 / roop + "(ms)");
    double expected = TestUtils.BASIS_TIME;
    assertTrue(actual < expected);
  }

  @Test
  public void testSumListOfDouble() {

    int count = 100000;
    List<Double> values = getDoubleList(count);
    double actual = Math2.sum(values);
    double expected = (double) count * count / 2;
    assertEquals(expected, actual, expected * 0.0001);
  }

  // @Test
  // public void perfSumListOfDouble() {
  //
  // int count = 100000;
  // final List<Double> values = getDoubleList(count);
  // int roop = 10;
  // double actual = TestUtil.getMilliTime(new Runnable() {
  //
  // @Override
  // public void run() {
  // MathUtil.sum(values);
  // }
  // }, roop);
  // System.out.println("equus.carbine.util.MathUtil.sum(List<Double>) actual time is " + actual / roop + "(ms)");
  // double expected = TestUtil.BASIS_TIME * 3;
  // assertTrue(actual < expected);
  // }

  @Test
  public void testAverageDoubleArray() {

    int count = 100000;
    double[] values = getDoubleArray(count);
    double actual = Math2.average(values);
    double expected = (double) count / 2;
    assertEquals(expected, actual, expected * 0.0001);
  }

  // @Test
  // public void perfAverageDoubleArray() {
  //
  // int count = 100000;
  // final double[] values = getDoubleArray(count);
  // int roop = 10;
  // double actual = TestUtil.getMilliTime(new Runnable() {
  //
  // @Override
  // public void run() {
  // MathUtil.average(values);
  // }
  // }, roop);
  // System.out.println("equus.carbine.util.MathUtil.average(double[]) actual time is " + actual / roop + "(ms)");
  // double expected = TestUtil.BASIS_TIME;
  // assertTrue(actual < expected);
  // }

  @Test
  public void testAverageListOfDouble() {

    int count = 100000;
    List<Double> values = getDoubleList(count);
    double actual = Math2.average(values);
    double expected = (double) count / 2;
    assertEquals(expected, actual, expected * 0.0001);
  }

  // @Test
  // public void perfAverageListOfDouble() {
  //
  // int count = 100000;
  // final List<Double> values = getDoubleList(count);
  // int roop = 10;
  // double actual = TestUtil.getMilliTime(new Runnable() {
  //
  // @Override
  // public void run() {
  // MathUtil.average(values);
  // }
  // }, roop);
  // System.out.println("equus.carbine.util.MathUtil.average(List<Double>) actual time is " + actual / roop + "(ms)");
  // double expected = TestUtil.BASIS_TIME * 3;
  // assertTrue(actual < expected);
  // }

  @Test
  public void testPower() {

    {
      double actual = Math2.power(2, 10);
      double expected = 1024.0;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      double actual = Math2.power(2, -10);
      double expected = 1.0 / 1024.0;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      double actual = Math2.power(2, 20);
      double expected = 1024.0 * 1024.0;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      double actual = Math2.power(3, 10);
      double expected = 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      double actual = Math2.power(0, 10);
      double expected = 0;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      double actual = Math2.power(5, 0);
      double expected = 1;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      double actual = Math2.power(-2, 10);
      double expected = 1024.0;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      double actual = Math2.power(-2, 11);
      double expected = 1024.0 * -2;
      assertEquals(expected, actual, expected * 0.000001);
    }
    {
      try {
        Math2.power(1, -1000000000);
        fail();
      } catch (IllegalArgumentException e) {
        assertTrue(true);
      }
    }
    {
      try {
        Math2.power(1, 1000000000);
        fail();
      } catch (IllegalArgumentException e) {
        assertTrue(true);
      }
    }
    {
      try {
        Math2.power(99999999, 99999999);
        fail();
      } catch (OverFlowException e) {
        assertTrue(true);
      }
    }
    {
      try {
        Math2.power(99999999, -99999999);
        fail();
      } catch (OverFlowException e) {
        assertTrue(true);
      }
    }
  }

  // @Test
  // public void perfPower() {
  //
  // int roop = 1000;
  // double actual = TestUtil.getMilliTime(new Runnable() {
  //
  // @Override
  // public void run() {
  // MathUtil.power(1.0, 999999999);
  // }
  // }, roop);
  // System.out.println("equus.carbine.util.MathUtil.power(double, int) actual time is " + actual / roop + "(ms)");
  // double expected = TestUtil.BASIS_TIME;
  // assertTrue(actual < expected);
  // }
}
