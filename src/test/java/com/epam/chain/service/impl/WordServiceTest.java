package com.epam.chain.service.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;
import com.epam.chain.entity.impl.Letter;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WordServiceTest {

    public static Composite composite;

    @DataProvider
    public Object[][] getComponent(){
        return new Object[][]{
                {"lol",1 },
                {"kek",2 },
                {"chebureck",1 }
        };
    }
    @BeforeMethod
    public void setSentence(){
        String[] words = new String[]{
                "lol","kek","kek","chebureck"
        };
        List<Component> sentence = new ArrayList<>();
        for(String word: words) {
            List<Component> listWord = new ArrayList<>();
            char[] letters = word.toCharArray();
            for(char letter:letters) {
                listWord.add(new Letter(letter));
            }
            sentence.add(new Composite(listWord));
        }
        composite = new Composite(sentence);
    }
    @AfterMethod
    public void clearSentence(){
        composite = null;
    }
    @Test(dataProvider = "getComponent")
    public void testFindAllSameWord(String findWord, int valueWord) {
        WordService service = new WordService();
        assertEquals(valueWord,service.findAllSameWord(composite, findWord));
    }
}