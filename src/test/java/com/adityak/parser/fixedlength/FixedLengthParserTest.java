package com.adityak.parser.fixedlength;

import com.adityak.parser.common.configuration.FileConfiguration;
import com.adityak.parser.common.configuration.ItemConfiguration;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FixedLengthParserTest {

    private FixedLengthParser fixedLengthParser = new FixedLengthParser();

    @org.junit.Test
    public void parse() throws Exception{


        fixedLengthParser.setFileConfiguration(getConfiguration());

        String content = "Header\r\n123456789012345678XXXXXX";


        final List parse = fixedLengthParser.parse(new ByteArrayInputStream(content.getBytes()));
        System.out.println(parse);

    }

    private FileConfiguration getConfiguration() {
        final FileConfiguration fileConfiguration = new FileConfiguration();
        fileConfiguration.setDataLineNo(2);
        fileConfiguration.setHeaderLineNo(1);
        fileConfiguration.setTargetClazz(TestData.class);
        fileConfiguration.setHeaderConfiguration(new ArrayList<ItemConfiguration>());
        fileConfiguration.setDetailConfiguration(new ArrayList<ItemConfiguration>());
        final ItemConfiguration itemConfiguration = new ItemConfiguration();
        itemConfiguration.setFieldName("name");
        itemConfiguration.setLength(10);
        itemConfiguration.setPosition(1);
        itemConfiguration.setType("char");
        itemConfiguration.initialize();
        fileConfiguration.getDetailConfiguration().add(itemConfiguration);

        ItemConfiguration dateConfiguration = new ItemConfiguration();
        dateConfiguration.setFieldName("date");
        dateConfiguration.setLength(8);
        dateConfiguration.setPosition(11);
        dateConfiguration.setType("char");
        dateConfiguration.initialize();
        fileConfiguration.getDetailConfiguration().add(dateConfiguration);


        return fileConfiguration;
    }





}