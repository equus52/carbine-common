package equus.carbine.patternmatch;


public interface CaseFunction<S, R> extends CaseMatcher<S> {

  R apply(S subject);

}
