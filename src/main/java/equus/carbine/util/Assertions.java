package equus.carbine.util;

import java.util.Optional;

public final class Assertions {
  private Assertions() {}

  public static <T> T assertPresent(Optional<T> optional) {
    if (!optional.isPresent()) {
      throw new NullPointerException();
    }
    return optional.get();
  }
}
