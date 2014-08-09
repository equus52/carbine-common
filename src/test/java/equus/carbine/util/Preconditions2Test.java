package equus.carbine.util;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import com.google.common.collect.Lists;

public class Preconditions2Test {

  @Test
  public void testPrivateConstractor() {
    TestUtils.privateConstractor(Preconditions2.class).newInstance();
  }

  @Test
  public void testNotEmptyString() {
    {
      String str = "a";
      Preconditions2.checkNotEmpty(str);
    }
    try {
      String str = "";
      Preconditions2.checkNotEmpty(str);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      String str = null;
      Preconditions2.checkNotEmpty(str);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyStringString() {
    {
      String str = "a";
      Preconditions2.checkNotEmpty(str, "");
    }
    try {
      String str = "";
      Preconditions2.checkNotEmpty(str, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      String str = null;
      Preconditions2.checkNotEmpty(str, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyCollectionOfQ() {
    {
      Collection<String> col = Lists.newArrayList("a");
      Preconditions2.checkNotEmpty(col);
    }
    try {
      Collection<String> col = Lists.newArrayList();
      Preconditions2.checkNotEmpty(col);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      Collection<String> col = null;
      Preconditions2.checkNotEmpty(col);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyCollectionOfQString() {
    {
      Collection<String> col = Lists.newArrayList("a");
      Preconditions2.checkNotEmpty(col, "");
    }
    try {
      Collection<String> col = Lists.newArrayList();
      Preconditions2.checkNotEmpty(col, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      Collection<String> col = null;
      Preconditions2.checkNotEmpty(col, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyShortArray() {
    {
      short[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      short[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      short[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyShortArrayString() {
    {
      short[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      short[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      short[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyIntArray() {
    {
      int[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      int[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      int[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyIntArrayString() {
    {
      int[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      int[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      int[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyLongArray() {
    {
      long[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      long[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      long[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyLongArrayString() {
    {
      long[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      long[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      long[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyFloatArray() {
    {
      float[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      float[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      float[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyFloatArrayString() {
    {
      float[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      float[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      float[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyDoubleArray() {
    {
      double[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      double[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      double[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyDoubleArrayString() {
    {
      double[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      double[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      double[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyByteArray() {
    {
      byte[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      byte[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      byte[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyByteArrayString() {
    {
      byte[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      byte[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      byte[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyCharArray() {
    {
      char[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      char[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      char[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyCharArrayString() {
    {
      char[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      char[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      char[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyObjectArray() {
    {
      Object[] array = { 1 };
      Preconditions2.checkNotEmpty(array);
    }
    try {
      Object[] array = {};
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      Object[] array = null;
      Preconditions2.checkNotEmpty(array);
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

  @Test
  public void testNotEmptyObjectArrayString() {
    {
      Object[] array = { 1 };
      Preconditions2.checkNotEmpty(array, "");
    }
    try {
      Object[] array = {};
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(true);
    }
    try {
      Object[] array = null;
      Preconditions2.checkNotEmpty(array, "");
      fail();
    } catch (NullPointerException e) {
      assertTrue(true);
    }
  }

}
