package com.epam.chain.service.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;
import com.epam.chain.entity.impl.Letter;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class SentenceServiceTest {
    public static Composite composite;

    @DataProvider
    public Object[][] getListComponent(){
        return new Object[][]{
                { 5, 1 },
                { 4, 2 },
                { 3, 5 }
        };
    }
    @BeforeMethod
    public void setSentence() {
        String[][] sentences = new String[][]{
                {"lol", "lol", "lol", "kek", "kek", "chebureck"},
                {"kek", "kek", "olol"},
                {"kek", "kek", "lol"},
                {"kek", "kek", "sus"},
                {"lol", "kek", "kek", "drd"},
        };
        List<Component> paragraph = new ArrayList<>();
        for (String[] words : sentences) {
            List<Component> sentence = new ArrayList<>();
            for (String word : words) {
                List<Component> listWord = new ArrayList<>();
                char[] letters = word.toCharArray();
                for (char letter : letters) {
                    listWord.add(new Letter(letter));
                }
                sentence.add(new Composite(listWord));
            }
            paragraph.add(new Composite(sentence));
        }
        List<Component> list = new ArrayList<Component>();
        list.add(new Composite(paragraph));
        List<Component> list1 = new ArrayList<Component>();
        list1.add(new Composite(list));
        composite = new Composite(list1);
    }
    @AfterMethod
    public void clearSentence(){
        composite = null;
    }
    @Test(dataProvider = "getListComponent")
    public void testDeleteSentenceLessSize(int size, int expected) {
        SentenceService sentenceService = new SentenceService();
        assertEquals(sentenceService.deleteSentenceLessSize(composite,size).getChild(0).getChild(0).size(),expected);
    }

    @Test
    public void testFindSentenceWithBigWord() {
        SentenceService sentenceService = new SentenceService();
        assertEquals(sentenceService.findSentenceWithBigWord(composite),composite.getChild(0).getChild(0).getChild(0));
    }
}