package com.adityak.parser.common;

public interface Transformer<S,T> {

    /**
     * Transform the source value and return the transformed value
     *
     * @param sourceValue
     * @return
     */
    public T transform(S sourceValue);
}
