package io.gojek.parkinglot.validator;

/**
 * @param <A>
 * @param <B>
 * @param <C>
 */
public interface ValidationInterface<A, B, C> {

    public B  validate(A instruction);

    public C validate(B argument, A... instructions);
}
