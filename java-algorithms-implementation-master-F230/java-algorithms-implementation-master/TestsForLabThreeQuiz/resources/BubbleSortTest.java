
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.jwetherell.algorithms.sorts.BubbleSort;

class BubbleSortTest {

    @Test
    void testSortAscendingOrder() {
        Integer[] input = {5, 3, 8, 6, 2};
        Integer[] expected = {2, 3, 5, 6, 8};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result, "Bubble sort failed for ascending order.");
    }

    @Test
    void testSortDescendingOrder() {
        Integer[] input = {5, 3, 8, 6, 2};
        Integer[] expected = {8, 6, 5, 3, 2};
        Integer[] result = BubbleSort.sort(input);
        assertFalse(result[0] == expected[0]);
    }

    @Test
    void testSortEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result, "Bubble sort failed for an empty array.");
    }

    @Test
    void testSortSingleElement() {
        Integer[] input = {7};
        Integer[] expected = {7};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result, "Bubble sort failed for a single-element array.");
    }

    @Test
    void testSortAlreadySortedArray() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Integer[] result = BubbleSort.sort(input);
        assertArrayEquals(expected, result, "Bubble sort failed for an already sorted array.");
    }
}
