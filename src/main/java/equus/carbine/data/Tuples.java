package equus.carbine.data;

public final class Tuples {

    public static <T1> Tuple1<T1> of(final T1 t1) {
        return new Tuple1<T1>() {

            @Override
            public T1 get1() {
                return t1;
            }
        };
    }

    public static <T1, T2> Tuple2<T1, T2> of(final T1 t1, final T2 t2) {
        return new Tuple2<T1, T2>() {

            @Override
            public T1 get1() {
                return t1;
            }

            @Override
            public T2 get2() {
                return t2;
            }
        };
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(final T1 t1, final T2 t2, final T3 t3) {
        return new Tuple3<T1, T2, T3>() {

            @Override
            public T1 get1() {
                return t1;
            }

            @Override
            public T2 get2() {
                return t2;
            }

            @Override
            public T3 get3() {
                return t3;
            }
        };
    }
}
