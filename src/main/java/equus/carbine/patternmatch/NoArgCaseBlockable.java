package equus.carbine.patternmatch;

import javax.annotation.Nonnull;

public interface NoArgCaseBlockable<S> extends CaseMatcher<S> {

  default CaseBlock<S> block(@Nonnull Block block) {
    return new CaseBlock<S>() {

      @Override
      public boolean match(S subject) {
        return NoArgCaseBlockable.this.match(subject);
      }

      @Override
      public void accept(S subject) {
        block.apply();
      }

    };
  }
}