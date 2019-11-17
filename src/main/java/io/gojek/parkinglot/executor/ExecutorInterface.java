package io.gojek.parkinglot.executor;

public interface ExecutorInterface<A, B>  {

    public B execute(A argument) throws Exception;

}
