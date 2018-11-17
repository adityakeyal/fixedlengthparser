package com.adityak.parser;

import com.adityak.parser.exception.ParsingException;

public interface Validator<S> {

    void validate(S sourceValue) throws ParsingException;

}
