package equus.carbine.data;

public final class Tuples {

    public static <T1, T2> Tuple<T1, T2> of(T1 value1, T2 value2) {
        return new Tuple<T1, T2>(value1, value2);
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 value1, T2 value2, T3 value3) {
        return new Tuple3<T1, T2, T3>(value1, value2, value3);
    }
}
