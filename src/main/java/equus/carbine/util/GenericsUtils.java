package equus.carbine.util;

import java.util.List;

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
}
