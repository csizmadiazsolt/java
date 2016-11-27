package com.ezsocsi.diguice;


import com.ezsocsi.utils.ListUtils;
import com.ezsocsi.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MungerTest {
    private Munger munger;

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
        ListUtils listUtils = mock(ListUtils.class);
        munger = new Munger(listUtils);

        doReturn(WORD_FRAGMENTATION_SHUFFLED).when(listUtils).shuffle(WORD_FRAGMENTATION, 1, 12);

        doReturn(WORD_SOME_SHUFFLED).when(listUtils).shuffle(WORD_SOME, 1, 3);
        doReturn(WORD_TEXT_SHUFFLED).when(listUtils).shuffle(WORD_TEXT, 1, 3);
        doReturn(WORD_FOR).when(listUtils).shuffle(WORD_FOR, 1, 2);
        doReturn(WORD_EXAMPLE_SHUFFLED).when(listUtils).shuffle(WORD_EXAMPLE, 1, 6);
    }

    @Test
    public void munger_returns_correct_munged_word() {
        String expectedOutput = "figmenattraon";
        assertEquals(expectedOutput, munger.munge("fragmentation"));
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        String expectedOutput = "smoe txet for eaxmple";
        assertEquals(expectedOutput, munger.munge("some text for example"));
    }
}