package equus.carbine.patternmatch;

public interface CaseFunction2<S1, S2, R> extends CaseMatcher2<S1, S2> {

  R apply(S1 subject1, S2 subject2);

}
