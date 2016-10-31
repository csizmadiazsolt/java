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

    @Before
    public void setup() {
        ListUtils listUtils = mock(ListUtils.class);
        quickSort = new QuickSort(listUtils);

        List<Integer> input1 = Arrays.asList(3, 6, 77, 2);
        List<Integer> input2 = Arrays.asList(2, 6, 77, 3);
        List<Integer> input3 = Arrays.asList(2, 3, 77, 6);
        List<Integer> output = Arrays.asList(2, 3, 6, 77);

        when(listUtils.swap(input1, 0, 3)).thenReturn(input2);
        when(listUtils.swap(input2, 1, 3)).thenReturn(input3);
        when(listUtils.swap(input3, 2, 3)).thenReturn(output);
    }

    @Test
    public void returns_correct_sorted_list() {
        List<Integer> input = Arrays.asList(3, 6, 77, 2);
        List<Integer> expected = Arrays.asList(2, 3, 6, 77);

        List<Integer> sortedInput = quickSort.quickSort(input);

        assertEquals(expected, sortedInput);
    }
}
