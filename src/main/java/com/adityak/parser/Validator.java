package com.adityak.parser;

import com.adityak.parser.exception.ParserException;

/**
 * Special Validator that ca be attached to any field item for validation
 *
 * @param <S>
 */
public interface Validator<S> {

    void validate(S sourceValue) throws ParserException;

}
