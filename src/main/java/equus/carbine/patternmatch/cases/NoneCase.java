package equus.carbine.patternmatch.cases;

import java.util.Optional;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import equus.carbine.patternmatch.Block;
import equus.carbine.patternmatch.CaseBlock;
import equus.carbine.patternmatch.CaseFunction;
import equus.carbine.patternmatch.CaseMatcher;
import lombok.Value;

@Value
public class NoneCase implements CaseMatcher<Optional<?>> {

  @Override
  public boolean match(@Nonnull Optional<?> subject) {
    return !subject.isPresent();
  }

  public static abstract class NoneCaseBlock implements CaseBlock<Optional<?>> {}

  public NoneCaseBlock block(@Nonnull Block block) {
    return new NoneCaseBlock() {

      @Override
      public boolean match(Optional<?> subject) {
        return NoneCase.this.match(subject);
      }

      @Override
      public void accept(Optional<?> subject) {
        block.apply();
      }
    };
  }

  public static abstract class NoneCaseFunction<R> implements CaseFunction<Optional<?>, R> {}

  public <R> NoneCaseFunction<R> function(@Nonnull Supplier<R> supplier) {
    return new NoneCaseFunction<R>() {

      @Override
      public boolean match(Optional<?> subject) {
        return NoneCase.this.match(subject);
      }

      @Override
      public R apply(Optional<?> subject) {
        return supplier.get();
      }
    };
  }

}
