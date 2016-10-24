package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.AssertJUnit.assertEquals;

public class ListUtilsTest {
    private Collections collections;
    private ListUtils listUtils;

    @Before
    public void setup() {
        listUtils = new ListUtils();
        collections = mock(Collections.class);
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        List<Character> inputWord = TestUtils.stringToCharList("sporadically");

        listUtils.shuffle(inputWord, 1, 11);

        verify(collections).shuffle(inputWord.subList(1, 11));
    }
}
