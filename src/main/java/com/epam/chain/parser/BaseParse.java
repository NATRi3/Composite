package com.epam.chain.parser;

import com.epam.chain.entity.Component;
import com.epam.chain.exception.ParserException;

import java.util.List;

public interface BaseParse {
    public List<Component> parse(String s) throws ParserException;
}
