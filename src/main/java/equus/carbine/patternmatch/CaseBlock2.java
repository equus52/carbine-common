package equus.carbine.patternmatch;

public interface CaseBlock2<S1, S2> extends CaseMatcher2<S1, S2> {

  void accept(S1 subject1, S2 subject2);
}