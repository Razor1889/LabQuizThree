package com.jwetherell.algorithms.sorts;

import java.util.Random;

/**
 * Quicksort is a sorting algorithm which, on average, makes O(n*log n) comparisons to sort
 * n items. In the worst case, it makes O(n^2) comparisons, though this behavior is
 * rare. Quicksort is often faster in practice than other algorithms. 
 * <p>
 * Family: Divide and conquer.<br> 
 * Space: In-place.<br>
 * Stable: False.<br>
 * <p>
 * Average case = O(n*log n)<br>
 * Worst case = O(n^2)<br>
 * Best case = O(n) [three-way partition and equal keys]<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Quick_sort">Quicksort (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class QuickSort<T extends Comparable<T>> {

    private static final Random RAND = new Random();

    public enum PIVOT_TYPE {
        FIRST, MIDDLE, RANDOM
    }

    public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

    private QuickSort() { }


    public static <T extends Comparable<T>> T[] sort(PIVOT_TYPE pivotType, T[] unsorted) {
        if (unsorted == null || unsorted.length <= 1) {
            return unsorted;
        }
        sort(0, unsorted.length - 1, unsorted, pivotType);
        return unsorted;
    }


    private static <T extends Comparable<T>> void sort(int start, int finish, T[] unsorted, PIVOT_TYPE pivotType) {
        if (start < finish) {
            int pivotIndex = partition(start, finish, unsorted, pivotType);
            sort(start, pivotIndex - 1, unsorted, pivotType);
            sort(pivotIndex + 1, finish, unsorted, pivotType);
        }
    }


    private static <T extends Comparable<T>> int partition(int start, int finish, T[] unsorted, PIVOT_TYPE pivotType) {
        int pivotIndex = getPivot(start, finish, pivotType, unsorted);
        T pivot = unsorted[pivotIndex];
        swap(pivotIndex, finish, unsorted);

        int i = start - 1;
        for (int j = start; j < finish; j++) {
            if (unsorted[j].compareTo(pivot) <= 0) {
                i++;
                swap(i, j, unsorted);
            }
        }

        swap(i + 1, finish, unsorted);
        return i + 1;
    }


    private static <T extends Comparable<T>> int getPivot(int start, int finish, PIVOT_TYPE pivotType, T[] unsorted) {
        int pivotIndex = 0;

        if (pivotType == PIVOT_TYPE.MIDDLE) {
            pivotIndex = start + (finish - start) / 2;
        } else if (pivotType == PIVOT_TYPE.RANDOM) {
            pivotIndex = RAND.nextInt(finish - start + 1) + start;
        } else {
            pivotIndex = start;
        }

        return pivotIndex;
    }


    private static <T extends Comparable<T>> void swap(int index1, int index2, T[] unsorted) {
        T temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }
}