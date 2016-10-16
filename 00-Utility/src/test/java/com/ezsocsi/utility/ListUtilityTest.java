package com.ezsocsi.utility;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ListUtilityTest {
    private Collections collections;

    @Before
    public void setup() {
        collections = mock(Collections.class);
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        ListUtility utils = new ListUtility();
        List<Character> inputWord = TestUtility.stringToCharList("sporadically");

        utils.shuffle(inputWord, 1, 11);

        Mockito.verify(collections).shuffle(inputWord.subList(1, 11));
    }
}
