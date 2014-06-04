package equus.carbine.patternmatch;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

public interface CaseBlockable<S, T> extends CaseMatcher<S> {

  default CaseBlock<S> block(@Nonnull Consumer<T> consumer) {
    return new CaseBlock<S>() {

      @Override
      public boolean match(S subject) {
        return CaseBlockable.this.match(subject);
      }

      @Override
      public void accept(S subject) {
        consumer.accept(convert(subject));
      }

    };
  }

  T convert(S subject);

}