package com.adityak.parser.common;

import com.adityak.parser.exception.ValidationException;

import java.text.ParseException;

public interface Transformer<S,T> {

    /**
     * Transform the source value and return the transformed value
     *
     * @param sourceValue
     * @return
     */
    public T transform(S sourceValue) throws ValidationException;
}
