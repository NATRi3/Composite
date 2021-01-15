package com.epam.chain.service.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;
import com.epam.chain.entity.impl.Letter;
import com.epam.chain.service.SentenceServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SentenceService implements SentenceServiceInterface {
    public static final Logger logger = LogManager.getLogger(SentenceService.class);
    @Override
    public Component deleteSentenceLessSize(Component component, int sentenceSize) {
        for(int i = 0; i< component.size(); i++) {
            System.out.println(i);
            Component child = component.getChild(i);
            int sizeComponent = child.size();
            int sizeChildComponent = child.getChild(child.size() - 1).size();
            if ((child.getChild(sizeComponent - 1).getChild(sizeChildComponent - 1)) instanceof Letter) {
                if (child.size() < sentenceSize) {
                    component.remove(child);
                    i--;
                }
            } else {
                deleteSentenceLessSize(child, sentenceSize);
            }
        }
        return component;
    }
    @Override
    public Component findSentenceWithBigWord(Composite text) {
        int max = 0;
        int indexMaxSent = 0;
        int indexMaxSentPar = 0;
        List<Component> paragraphList = text.getList();
        for (Component par : paragraphList) {
            for(int i = 0; i<par.size();i++){
                for(int j = 0;j<par.getChild(i).size();j++){
                    if(par.getChild(i).getChild(j).size()>max){
                        max = par.getChild(i).getChild(j).size();
                        indexMaxSent = j;
                        indexMaxSentPar = i;
                    }
                }
            }
            return par.getChild(indexMaxSentPar).getChild(indexMaxSent);
        }
        return null;
    }
}
