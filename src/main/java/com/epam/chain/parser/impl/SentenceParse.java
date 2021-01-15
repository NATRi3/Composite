package com.epam.chain.parser.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;
import com.epam.chain.exception.ParserException;
import com.epam.chain.parser.BaseParse;
import com.epam.chain.util.Split;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SentenceParse implements BaseParse {
    public static final Logger logger = LogManager.getLogger(SentenceParse.class);
    private final static String SENTENCE_REGEX ="[!|?|.{1-3}]\\s";
    private BaseParse parse;
    public SentenceParse(BaseParse parse){
        this.parse = parse;
    }
    @Override
    public List<Component> parse(String dataString) throws ParserException {
        System.out.println(dataString);
        List<Component> result = new ArrayList<>();
        for (String element: Split.splitIncludingDelimiters(SENTENCE_REGEX,dataString)) {
            if (parse == null) {
                throw new ParserException("ParseSentence exception");
            } else {
                result.add(new Composite(parse.parse(element)));
            }
        }
        return result;
    }
}
