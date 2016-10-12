package com.ezsocsi.textmunger.unittest;


import com.ezsocsi.textmunger.Munger;
import com.ezsocsi.textmunger.Utils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MungerTest {
    private Utils utils;

    private final List<Character> WORD_FRAGMENTATION = TestUtils.stringToCharList("fragmentation");
    private final List<Character> WORD_FRAGMENTATION_SHUFFLED = TestUtils.stringToCharList("figmenattraon");

    private final List<Character> WORD_SOME = TestUtils.stringToCharList("some");
    private final List<Character> WORD_SOME_SHUFFLED = TestUtils.stringToCharList("smoe");
    private final List<Character> WORD_TEXT = TestUtils.stringToCharList("text");
    private final List<Character> WORD_TEXT_SHUFFLED = TestUtils.stringToCharList("txet");
    private final List<Character> WORD_FOR = TestUtils.stringToCharList("for");
    private final List<Character> WORD_EXAMPLE = TestUtils.stringToCharList("example");
    private final List<Character> WORD_EXAMPLE_SHUFFLED = TestUtils.stringToCharList("eaxmple");

    @Before
    public void setup() {
        utils = mock(Utils.class);

        when(utils.shuffle(WORD_FRAGMENTATION, 1, 12)).thenReturn(WORD_FRAGMENTATION_SHUFFLED);

        when(utils.shuffle(WORD_SOME, 1, 3)).thenReturn(WORD_SOME_SHUFFLED);
        when(utils.shuffle(WORD_TEXT, 1, 3)).thenReturn(WORD_TEXT_SHUFFLED);
        when(utils.shuffle(WORD_FOR, 1, 2)).thenReturn(WORD_FOR);
        when(utils.shuffle(WORD_EXAMPLE, 1, 6)).thenReturn(WORD_EXAMPLE_SHUFFLED);
    }

    @Test
    public void munger_returns_correct_munged_word() {
        Munger munger = new Munger(utils);
        String expectedOutput = "figmenattraon";

        assertEquals(expectedOutput, munger.munge("fragmentation"));
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        Munger munger = new Munger(utils);
        String expectedOutput = "smoe txet for eaxmple";

        assertEquals(expectedOutput, munger.munge("some text for example"));
    }
}