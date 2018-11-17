package com.adityak.parser.common.transformer;

import com.adityak.parser.common.Transformer;

import java.math.BigDecimal;

public class BigDecimalTransformer implements Transformer<String, BigDecimal> {

    public BigDecimal transform(String sourceValue) {
        return new BigDecimal(sourceValue);
    }
}
