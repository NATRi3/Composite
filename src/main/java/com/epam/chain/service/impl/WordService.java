package com.epam.chain.service.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Letter;
import com.epam.chain.entity.impl.Punctuation;
import com.epam.chain.service.WordServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class WordService implements WordServiceInterface {
    public static final Logger logger = LogManager.getLogger(WordService.class);

    @Override
    public int findAllSameWord(Component text, String findWord) {
        int result = 0;
        List<Component> list = text.getList();
        if(list.get(list.size()-1).getClass().equals(Letter.class)||
                list.get(list.size()-1).getClass().equals(Punctuation.class)) {
            StringBuilder wordSB = new StringBuilder();
            for (Component component:list){
                if(component.getClass().equals(Letter.class)){
                    wordSB.append(component.toString());
                }
            }
            String word = String.valueOf(wordSB);
            if(word.length()==findWord.length()) {
                if(word.equals(findWord)){
                    result++;
                }
            }
        }else {
            for(Component component1: list) {
                result+=findAllSameWord(component1, findWord);
            }
        }
        return result;
    }
}
