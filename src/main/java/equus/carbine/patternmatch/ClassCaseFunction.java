package equus.carbine.patternmatch;

import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class ClassCaseFunction<S, T extends S, R> implements CaseFunction<S, R> {
  @Nonnull
  Class<T> matchClass;
  @Nonnull
  Function<T, R> function;

  @SuppressWarnings("unchecked")
  @Override
  public Result<R> matchAndApply(@Nullable S subject) {
    if (matchClass.isInstance(subject)) {
      return Result.of(function.apply((T) subject));
    }
    return Result.ofFalse();
  }

}
