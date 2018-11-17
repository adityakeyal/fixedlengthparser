package com.adityak.parser.common;

import com.adityak.parser.exception.ParserException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Cootract for a parser used to Parse an incoming file and return a List of T
 */
public interface Parser<T> {

    /**
     * Primary contract API.
     * Read a file and return a Collection of T
     * @param input
     * @return
     */
    List<T> parse(InputStream input) throws FileNotFoundException, ParserException;



}
