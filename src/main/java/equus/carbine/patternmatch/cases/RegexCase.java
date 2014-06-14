package equus.carbine.patternmatch.cases;

import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;
import equus.carbine.patternmatch.NoConvertCase;

@Value
public class RegexCase implements NoConvertCase<String> {
  @Nonnull
  Pattern pattern;

  @Override
  public boolean match(@Nullable String subject) {
    return pattern.matcher(subject).find();
  }

}
