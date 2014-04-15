package equus.carbine.data;

import lombok.Value;

@Value
public class Tuple2<T1, T2> {

    T1 value1;

    T2 value2;
}
