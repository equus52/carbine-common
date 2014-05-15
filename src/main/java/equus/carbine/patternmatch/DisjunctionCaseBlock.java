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
  public boolean matchAndAccept(@Nullable S subject) {
    for (S matchValue : matchValues) {
      if (matchValue.equals(subject)) {
        consumer.accept(subject);
        return true;
      }
    }
    return false;
  }

}
