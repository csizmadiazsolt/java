package com.ezsocsi.textmunger.unittest;


import com.ezsocsi.textmunger.Utils;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UtilsTest {
    private Collections collections;

    @Before
    public void setup() {
        collections = mock(Collections.class);
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        Utils utils = new Utils();
        List<Character> inputWord = TestUtils.stringToCharList("sporadically");

        utils.shuffle(inputWord, 1, 11);

        verify(collections).shuffle(inputWord.subList(1, 11));
    }
}
