package com.epam.chain.service.impl;

import com.epam.chain.entity.Component;
import com.epam.chain.entity.impl.Composite;
import com.epam.chain.entity.impl.Letter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class LetterServiceTest {
    public static final LetterService service = new LetterService();
    @DataProvider
    public Object[][] getListComponent(){
        List<Component> letters = new ArrayList<>();
        letters.add(new Letter('g'));
        letters.add(new Letter('a'));
        letters.add(new Letter('i'));
        int[] result = new int[]{2,1};
        List<Component> letters1 = new ArrayList<>();
        letters1.add(new Letter('y'));
        letters1.add(new Letter('d'));
        letters1.add(new Letter('s'));
        int[] result1 = new int[]{1,2};
        List<Component> letters2 = new ArrayList<>();
        letters2.add(new Letter('a'));
        letters2.add(new Letter('a'));
        letters2.add(new Letter('a'));
        int[] result2 = new int[]{3,0};
        return new Object[][]{
                { letters, result },
                { letters1, result1 },
                { letters2, result2 }
        };
    }
    @Test(dataProvider = "getListComponent")
    public void testCountVowel(List<Component> letters, int[] result) {
        assertEquals(result[0],service.countVowel(new Composite(letters)));
    }

    @Test(dataProvider = "getListComponent")
    public void testCountConsonant(List<Component> letters, int[] result) {
        assertEquals(result[1],service.countConsonant(new Composite(letters)));
    }
}