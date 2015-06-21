package sort;

import sun.tools.jar.resources.jar;

/**
 * Created by liqiushi on 2/14/14.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] randomIntegers = {6, 3, 2, 8, 4, 1, 7, 9, 5, 2, 3, 10, 9, 20};
        insertionSort(randomIntegers);

        for (int num : randomIntegers)
            System.out.print(num + " ");
    }

    private static void insertionSort(int[] randomIntegers) {
        for (int i = 1; i < randomIntegers.length; i++) {
            int valueToSort = randomIntegers[i];
            int j = i;
            while (j > 0 && randomIntegers[j - 1] > valueToSort) {
                randomIntegers[j] = randomIntegers[j - 1];
                j -= 1;
            }
            randomIntegers[j] = valueToSort;
        }
    }
}
