package io.gojek.parkinglot.validator;

public interface ValidationInterface<A, B, C> {

    public B  validate(A instruction);


    public C validate(B argument, A... instructions);
}
