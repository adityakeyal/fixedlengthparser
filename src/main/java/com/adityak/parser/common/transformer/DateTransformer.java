package com.adityak.parser.common.transformer;

import com.adityak.parser.common.Transformer;
import com.adityak.parser.exception.ValidationException;
import sun.security.pkcs.ParsingException;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransformer implements Transformer<String, Date> {

    private String dateFormat = "yyyyMMdd";
    private SimpleDateFormat simpleDateFormat;

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Date transform(String sourceValue) throws ValidationException {

        try {
            return this.simpleDateFormat.parse(sourceValue);
        } catch (ParseException e) {
            throw new ValidationException();
        }
    }

    @PostConstruct
    public void initializeDateFormat(){
        this.simpleDateFormat = new SimpleDateFormat(dateFormat);
    }

}
