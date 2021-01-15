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

public class ParagraphParse implements BaseParse{
    public static final Logger logger = LogManager.getLogger(ParagraphParse.class);
    private final static String PARAGRAPH_REGEX = "[\\s]{4}";
    private BaseParse parse;
    public ParagraphParse(BaseParse parse){
        this.parse = parse;
    }
    @Override
    public List<Component> parse(String dataString) throws ParserException {
        List<Component> result = new ArrayList<>();
        for (String element: dataString.split(PARAGRAPH_REGEX)) {
            if (null == parse) {
                throw new ParserException("ParagraphParse exception");
            }
            result.add(new Composite(parse.parse(element)));
        }
        return result;
    }
}
