package equus.carbine.patternmatch;

import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class DisjunctionCaseBlock<S> implements CaseBlock<S> {
  @Nonnull
  List<S> matchValues;
  @Nonnull
  Consumer<S> consumer;

  @Override
  public boolean match(@Nullable S subject) {
    for (S matchValue : matchValues) {
      if (matchValue.equals(subject)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void accept(S subject) {
    consumer.accept(subject);
  }

}
