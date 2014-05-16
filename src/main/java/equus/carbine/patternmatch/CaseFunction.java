package equus.carbine.patternmatch;

import javax.annotation.Nullable;

import lombok.Value;

public interface CaseFunction<S, R> {

  Result<R> matchAndApply(@Nullable S subject);

  @Value
  public static class Result<R> {
    @SuppressWarnings("rawtypes")
    static Result RESULT_FALSE = new Result<>(false, null);

    boolean match;

    R returnValue;

    public static <R> Result<R> of(R returnValue) {
      return new Result<>(true, returnValue);
    }

    @SuppressWarnings("unchecked")
    public static <R> Result<R> ofFalse() {
      return RESULT_FALSE;
    }
  }
}
