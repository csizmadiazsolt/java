package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ListUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class QuickSortTest {
    private QuickSort quickSort;
    private ListUtils listUtils;

    @Before
    public void setup() {
        listUtils = mock(ListUtils.class);
        quickSort = new QuickSort(listUtils);

        doCallRealMethod().when(listUtils).swap(anyList(), anyInt(), anyInt());
    }

    @Test
    public void returns_correct_sorted_list() {
        List<Integer> input = Arrays.asList(3, 6, 77, 2, 8);
        List<Integer> expected = Arrays.asList(2, 3, 6, 8, 77);

        List<Integer> sortedInput = quickSort.quickSort(input);

        assertEquals(expected, input);
        assertEquals(expected, sortedInput);

        verify(listUtils, times(6)).swap(anyList(), anyInt(), anyInt());
    }
}
