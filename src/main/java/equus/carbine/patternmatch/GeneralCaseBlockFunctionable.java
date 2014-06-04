package equus.carbine.patternmatch;

public interface GeneralCaseBlockFunctionable<S> extends CaseBlockable<S, S>, CaseFunctionable<S, S> {

  @Override
  default S convert(S subject) {
    return subject;
  }
}
