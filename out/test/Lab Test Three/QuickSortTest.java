import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.jwetherell.algorithms.sorts.QuickSort;
class QuickSortTest {

    @Test
    void testSortUnsortedArray() {
        Integer[] input = {5, 3, 8, 6, 2};
        Integer[] expected = {2, 3, 5, 6, 8};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result, "Failed to sort a standard array");
    }

    @Test
    void testSortAlreadySortedArray() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result, "Failed to sort a sorted array");
    }

    @Test
    void testSortEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result, "Failed to sort an empty array.");
    }

    @Test
    void testSortSingleElement() {
        Integer[] input = {7};
        Integer[] expected = {7};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result, "Failed to sort a single element array.");
    }

    @Test
    void testSortDescendingArray() {
        Integer[] input = {9, 7, 5, 3, 1};
        Integer[] expected = {1, 3, 5, 7, 9};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result, "Failed to sort a descending array.");
    }

    @Test
    void testSortArrayWithDuplicates() {
        Integer[] input = {5, 3, 8, 6, 3, 2, 5};
        Integer[] expected = {2, 3, 3, 5, 5, 6, 8};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.RANDOM, input);
        assertArrayEquals(expected, result, "Failed to sort an array with duplicates.");
    }

    @Test
    void testSortWithMiddlePivot() {
        Integer[] input = {5, 3, 8, 6, 2};
        Integer[] expected = {2, 3, 5, 6, 8};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.MIDDLE, input);
        assertArrayEquals(expected, result, "Failed to sort with middle pivot.");
    }

    @Test
    void testSortWithFirstPivot() {
        Integer[] input = {5, 3, 8, 6, 2};
        Integer[] expected = {2, 3, 5, 6, 8};
        Integer[] result = QuickSort.sort(QuickSort.PIVOT_TYPE.FIRST, input);
        assertArrayEquals(expected, result, "Failed to sort with first element pivot.");
    }
}
