package equus.carbine.util;

import java.util.List;
import java.util.Optional;

public final class GenericsUtils {

  private GenericsUtils() {}

  @SuppressWarnings("unchecked")
  public static <T> T cast(Object obj) {
    return (T) obj;
  }

  @SuppressWarnings("unchecked")
  public static <T> T[] toArray(List<T> list) {
    return (T[]) list.toArray();
  }

  public static <S, T extends S> Optional<T> instanseOf(S obj, Class<T> clazz) {
    if (clazz.isInstance(obj)) {
      return Optional.ofNullable((T) obj);
    } else {
      return Optional.empty();
    }
  }
}
