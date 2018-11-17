package com.adityak.parser.fixedlength;

import com.adityak.parser.common.Parser;
import com.adityak.parser.common.configuration.FileConfiguration;
import com.adityak.parser.common.configuration.ItemConfiguration;
import com.adityak.parser.exception.ParserException;
import com.adityak.parser.exception.ValidationException;
import org.apache.commons.beanutils.BeanUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Need to add a transformer
 * Need to add a validator
 * @param <T>
 */
public class FixedLengthParser<T> implements Parser<T> {


    private FileConfiguration<T> fileConfiguration;


    public List<T> parse(InputStream input) throws ParserException {


        List<T> listOfParsedObjects = new LinkedList<T>();


        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String currentLine = null;
            int lineNo = 0;
            String headerLine = null;
            while( (currentLine = reader.readLine()) !=null){
                lineNo++;

                if(lineNo==fileConfiguration.getHeaderLineNo()){
                    headerLine = currentLine;
                    continue;
                }

                if(lineNo>=fileConfiguration.getDataLineNo()){
                    final T processedObject = processLine(headerLine, currentLine);
                    listOfParsedObjects.add(processedObject);

                }

                
            }




        } catch (Exception e) {
            e.printStackTrace();
            throw new ParserException();
        }

        return listOfParsedObjects;
    }

    private T processLine(String headerLine, String currentDataLine) throws IllegalAccessException, InstantiationException, InvocationTargetException, ValidationException {

        T newRow = fileConfiguration.getTargetClazz().newInstance();

        //read the header


        for (ItemConfiguration itemConfiguration : fileConfiguration.getHeaderConfiguration()) {
            String itemValue = headerLine.substring(itemConfiguration.getPositionIndex(), itemConfiguration.getEndPositionIndex() );
            itemValue = itemConfiguration.removePadding(itemValue);
            if(itemConfiguration.getFieldName()!=null){
                BeanUtils.setProperty(newRow , itemConfiguration.getFieldName(),itemConfiguration.getConvertedValue(itemValue));
            }
        }



        //read the detail
        for (ItemConfiguration itemConfiguration : fileConfiguration.getDetailConfiguration()) {
            String itemValue = currentDataLine.substring(itemConfiguration.getPositionIndex(), itemConfiguration.getEndPositionIndex());
            itemValue = itemConfiguration.removePadding(itemValue);
            BeanUtils.setProperty(newRow , itemConfiguration.getFieldName(),itemConfiguration.getConvertedValue(itemValue));
        }





        return newRow;


    }

    public void setFileConfiguration(FileConfiguration fileConfiguration) {
        this.fileConfiguration = fileConfiguration;
    }
}
