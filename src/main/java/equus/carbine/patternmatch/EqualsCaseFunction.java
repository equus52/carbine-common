package equus.carbine.patternmatch;

import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class EqualsCaseFunction<S, R> implements CaseFunction<S, R> {
  @Nonnull
  S matchValue;
  @Nonnull
  Function<S, R> consumer;

  @Override
  public Result<R> matchAndApply(@Nullable S subject) {
    if (matchValue.equals(subject)) {
      return Result.of(consumer.apply(subject));
    }
    return Result.ofFalse();
  }

}
