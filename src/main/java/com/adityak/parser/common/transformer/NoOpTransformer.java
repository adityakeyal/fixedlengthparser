package com.adityak.parser.common.transformer;

import com.adityak.parser.exception.ValidationException;

public class NoOpTransformer implements com.adityak.parser.common.Transformer {
    public Object transform(Object sourceValue) throws ValidationException {

        return sourceValue;
    }
}
