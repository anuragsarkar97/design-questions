package io.gojek.parkinglot.executor;

/**
 * @param <A> String -> argument type
 * @param <B> return parking lot type -> null
 */
public interface ExecutorInterface<A, B>  {

    public B execute(A argument) throws Exception;

}
