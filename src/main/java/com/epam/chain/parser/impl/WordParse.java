package com.epam.chain.parser.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;
import com.epam.chain.exception.ParserException;
import com.epam.chain.parser.BaseParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class WordParse implements BaseParse {
    public static final Logger logger = LogManager.getLogger(WordParse.class);
    private final static String WORD_REGEX =" ";
    private BaseParse parse;
    public WordParse(BaseParse parse){
        this.parse = parse;
    }
    @Override
    public List<Component> parse(String dataString) throws ParserException {
        System.out.println(dataString);
        List<Component> result = new ArrayList<>();
        for (String element: dataString.split(WORD_REGEX)) {
            if (parse == null) {
                throw new ParserException("WordParse exception");
            } else {
                result.add(new Composite(parse.parse(element)));
            }
        }
        return result;
    }
}
