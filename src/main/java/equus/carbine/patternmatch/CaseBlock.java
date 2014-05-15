package equus.carbine.patternmatch;

public interface CaseBlock<S> {

  boolean matchAndAccept(S subject);
}
