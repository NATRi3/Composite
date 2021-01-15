package com.epam.chain.parser.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Letter;
import com.epam.chain.entity.impl.Punctuation;
import com.epam.chain.exception.ParserException;
import com.epam.chain.parser.BaseParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LetterParse implements BaseParse {
    public static final Logger logger = LogManager.getLogger(LetterParse.class);
    public LetterParse(){

    }
    @Override
    public List<Component> parse(String dataString) throws ParserException {
        System.out.println(dataString);
        List<Component> result = new ArrayList<>();
        for (char element: dataString.toCharArray()) {
            if (Pattern.matches("\\w",element+"")) {
                result.add(new Letter(element));
            }else {
                result.add(new Punctuation(element));
            }
        }
        return result;
    }
}
