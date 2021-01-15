package com.epam.chain.service;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;

public interface SentenceServiceInterface {
    Component deleteSentenceLessSize(Component text, int sentenceSize);
    public Component findSentenceWithBigWord(Composite text);
}
