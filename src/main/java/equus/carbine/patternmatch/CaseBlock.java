package equus.carbine.patternmatch;

public interface CaseBlock<S> extends Matcher<S> {

  void accept(S subject);
}