package com.ezsocsi.textmunger;


import com.ezsocsi.utils.ListUtils;
import com.ezsocsi.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MungerTest {
    private Munger munger;

    @Before
    public void setup() {
        ListUtils listUtils = mock(ListUtils.class);
        munger = new Munger(listUtils);

        doCallRealMethod().when(listUtils).shuffle(anyList(), anyInt(), anyInt());
    }

    @Test
    public void munger_returns_correct_munged_word() {
        String generatedOutput = munger.munge("granite");

        int letterCounter = generatedOutput.indexOf('g') + generatedOutput.indexOf('r')
                + generatedOutput.indexOf('a') + generatedOutput.indexOf('n') + generatedOutput.indexOf('i')
                + generatedOutput.indexOf('t') + generatedOutput.indexOf('e');

        assertEquals(21, letterCounter);
    }

    @Test
    public void munger_returns_correct_munged_sentence() {
        String generatedOutput = munger.munge("Brooklyn Heights, isn't it nice?");

        long numberOf_Bs = TestUtils.countOccurrences(generatedOutput, 'B');
        long numberOf_rs = TestUtils.countOccurrences(generatedOutput, 'r');
        long numberOf_os = TestUtils.countOccurrences(generatedOutput, 'o');
        long numberOf_ks = TestUtils.countOccurrences(generatedOutput, 'k');
        long numberOf_ls = TestUtils.countOccurrences(generatedOutput, 'l');
        long numberOf_ys = TestUtils.countOccurrences(generatedOutput, 'y');
        long numberOf_ns = TestUtils.countOccurrences(generatedOutput, 'n');
        long numberOf_Spaces = TestUtils.countOccurrences(generatedOutput, ' ');
        long numberOf_Hs = TestUtils.countOccurrences(generatedOutput, 'H');
        long numberOf_es = TestUtils.countOccurrences(generatedOutput, 'e');
        long numberOf_is = TestUtils.countOccurrences(generatedOutput, 'i');
        long numberOf_gs = TestUtils.countOccurrences(generatedOutput, 'g');
        long numberOf_hs = TestUtils.countOccurrences(generatedOutput, 'h');
        long numberOf_ts = TestUtils.countOccurrences(generatedOutput, 't');
        long numberOf_ss = TestUtils.countOccurrences(generatedOutput, 's');
        long numberOf_comas = TestUtils.countOccurrences(generatedOutput, ',');
        long numberOf_Apostrophes = TestUtils.countOccurrences(generatedOutput, '\'');
        long numberOf_cs = TestUtils.countOccurrences(generatedOutput, 'c');
        long numberOf_QuestionMarks = TestUtils.countOccurrences(generatedOutput, '?');

        long sum = numberOf_Apostrophes + numberOf_Bs + numberOf_cs + numberOf_comas + numberOf_es + numberOf_gs
                + numberOf_hs + numberOf_Hs + numberOf_is + numberOf_ks + numberOf_ls + numberOf_ns + numberOf_os
                + numberOf_rs + numberOf_Spaces + numberOf_ss + numberOf_ts + numberOf_ys + numberOf_QuestionMarks;

        assertEquals(32, sum);
    }
}