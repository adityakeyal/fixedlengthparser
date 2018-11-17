package com.adityak.parser.common.configuration;

import com.adityak.parser.Validator;
import com.adityak.parser.common.Transformer;
import com.adityak.parser.common.transformer.BigDecimalTransformer;
import com.adityak.parser.common.transformer.DateTransformer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Holder Item used to store the configuration item information
 */
public class ItemConfiguration {


    /**
     *
     */
    private int position;

    /**
     *
     */
    private int length;

    /**
     *
     */
    private String fieldName;

    /**
     * Can be of type :
     * char : String
     * number : BigDeceimal
     */
    private String type;

    /**
     * Applicable for number types.
     * X,Y - X digits followed by Y digits for decimal
     *  Used only when there is no decimal separator in the content
     *
     */
    private  String format;
    /**
     * ' ' (space) for type char
     *  '0' for type number
     */
    private char paddingChar;

    private List<Validator> validators;



    private Transformer transformer;




    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public char getPaddingChar() {
        return paddingChar;
    }

    public void setPaddingChar(char paddingChar) {
        this.paddingChar = paddingChar;
    }

    public int getEndPosition() {
        return this.getPosition()+this.getLength();
    }

    public String removePadding(String itemValue) {

        throw new NotImplementedException();

    }

    public Object getConvertedValue(String itemValue) {
        throw new NotImplementedException();
    }

    public void setValidators(List<Validator> validators) {
        this.validators = validators;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    @PostConstruct
    public void initialize(){

        //add a chained transformer allowing to provide one input as another's output
        if(this.transformer==null){


            if("number".equalsIgnoreCase(this.getType())){

                // move this into some enum and create a factory out of the same
                this.transformer = new BigDecimalTransformer();

                //add special handling for the format if specified

            }

            if("date".equalsIgnoreCase(this.getType())){
                // move this into some enum and create a factory out of the same
                this.transformer = new DateTransformer();

                //add special handling for the format if specified
            }



        }

    }
}
