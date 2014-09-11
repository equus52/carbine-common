package equus.carbine.util;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;

public class GenericsUtilsTest {

  @Test
  public void testPrivateConstractor() {
    TestUtils.privateConstractor(GenericsUtils.class).newInstance();
  }

  @SuppressWarnings("unused")
  @Test
  public void testCast() {
    Object obj = "";
    String str = GenericsUtils.cast(obj);
  }

  @Test
  public void test_instanseOf() {
    {
      Number num = BigDecimal.ONE;
      Optional<BigDecimal> o = GenericsUtils.instanseOf(num, BigDecimal.class);
      o.ifPresent(b -> System.out.println(b.toPlainString()));
      assertTrue(o.isPresent());
    }
    {
      Object num = 1;
      Optional<BigDecimal> o = GenericsUtils.instanseOf(num, BigDecimal.class);
      o.ifPresent(b -> fail());
    }
  }
}
