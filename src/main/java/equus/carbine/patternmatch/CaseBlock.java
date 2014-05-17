package equus.carbine.patternmatch;


public interface CaseBlock<S> extends CaseMatcher<S> {

  void accept(S subject);
}