package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ListUtilsTest {
    private Collections collections;

    @Before
    public void setup() {
        collections = mock(Collections.class);
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        ListUtils utils = new ListUtils();
        List<Character> inputWord = TestUtils.stringToCharList("sporadically");

        utils.shuffle(inputWord, 1, 11);

        Mockito.verify(collections).shuffle(inputWord.subList(1, 11));
    }
}
