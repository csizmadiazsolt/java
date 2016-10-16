package com.ezsocsi.textmunger.unittest;


import com.ezsocsi.textmunger.Munger;
import com.ezsocsi.utility.ListUtility;
import com.ezsocsi.utility.TestUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MungerTest {
    private ListUtility listUtility;

    private final List<Character> WORD_FRAGMENTATION = TestUtility.stringToCharList("fragmentation");
    private final List<Character> WORD_FRAGMENTATION_SHUFFLED = TestUtility.stringToCharList("figmenattraon");

    private final List<Character> WORD_SOME = TestUtility.stringToCharList("some");
    private final List<Character> WORD_SOME_SHUFFLED = TestUtility.stringToCharList("smoe");
    private final List<Character> WORD_TEXT = TestUtility.stringToCharList("text");
    private final List<Character> WORD_TEXT_SHUFFLED = TestUtility.stringToCharList("txet");
    private final List<Character> WORD_FOR = TestUtility.stringToCharList("for");
    private final List<Character> WORD_EXAMPLE = TestUtility.stringToCharList("example");
    private final List<Character> WORD_EXAMPLE_SHUFFLED = TestUtility.stringToCharList("eaxmple");

    @Before
    public void setup() {
        listUtility = mock(ListUtility.class);

        when(listUtility.shuffle(WORD_FRAGMENTATION, 1, 12)).thenReturn(WORD_FRAGMENTATION_SHUFFLED);

        when(listUtility.shuffle(WORD_SOME, 1, 3)).thenReturn(WORD_SOME_SHUFFLED);
        when(listUtility.shuffle(WORD_TEXT, 1, 3)).thenReturn(WORD_TEXT_SHUFFLED);
        when(listUtility.shuffle(WORD_FOR, 1, 2)).thenReturn(WORD_FOR);
        when(listUtility.shuffle(WORD_EXAMPLE, 1, 6)).thenReturn(WORD_EXAMPLE_SHUFFLED);
    }

    @Test
    public void munger_returns_correct_munged_word() {
        Munger munger = new Munger(listUtility);
        String expectedOutput = "figmenattraon";

        assertEquals(expectedOutput, munger.munge("fragmentation"));
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        Munger munger = new Munger(listUtility);
        String expectedOutput = "smoe txet for eaxmple";

        assertEquals(expectedOutput, munger.munge("some text for example"));
    }
}
