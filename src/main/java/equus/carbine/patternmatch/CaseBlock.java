package equus.carbine.patternmatch;

public interface CaseBlock<T> {

  boolean matchAndAccept(T subject);
}
