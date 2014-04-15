package equus.carbine.data;

import lombok.Value;

@Value
public class Tuple3<T1, T2, T3> {

    T1 value1;

    T2 value2;

    T3 value3;
}
