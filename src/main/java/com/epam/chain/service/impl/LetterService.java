package com.epam.chain.service.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.service.LetterServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LetterService implements LetterServiceInterface {
    public static final Logger logger = LogManager.getLogger(LetterService.class);
    @Override
    public int countVowel(Component component) {
        int result = 0;
        for(int i = 0;i<component.size();i++){
            try{
                result+=countVowel(component.getChild(i));
            }catch (UnsupportedOperationException e){
                if(component.size()==1){
                    result +=isVowel(component.toString());
                }
            }
        }
        return result;
    }
    private int isVowel(String s) {
        String vowels = "AaEeQqYyUuIiOoJj";
        if (s.length() == 1) {
            if (vowels.contains(s)) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int countConsonant(Component component) {
        int result = 0;
        for(int i = 0;i<component.size();i++){
            try{
                result+=countConsonant(component.getChild(i));
            }catch (UnsupportedOperationException e){
                if(component.size()==1){
                    result +=isConsonant(component.toString());
                }
            }
        }
        return result;
    }
    private int isConsonant(String s) {
        String consonant = "BbCcDdFfGgHhJjKkLlMmNnPpQqRrSsTtVvWwXxZz";
        if (s.length() == 1) {
            if (consonant.contains(s)) {
                return 1;
            }
        }
        return 0;
    }
}
