package com.epam.chain.service;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;

public interface WordServiceInterface {
    int findAllSameWord(Component component, String s);
}
