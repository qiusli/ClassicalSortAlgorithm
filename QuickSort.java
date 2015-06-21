package sort;

/**
 * Created by liqiushi on 2/12/14.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] randomIntegers = {6, 3, 2, 8, 4, 1, 7, 9, 5, 2, 3, 10, 9, 20};
        quickSort(randomIntegers, 0, randomIntegers.length - 1);

        for (int num : randomIntegers)
            System.out.print(num + " ");
    }

    private static void quickSort(int[] randomIntegers, int low, int high) {
        if (low >= high)
            return;

        int pivot = partition(randomIntegers, low, high);

        quickSort(randomIntegers, low, pivot - 1);
        quickSort(randomIntegers, pivot + 1, high);
    }

    private static int partition(int[] randomIntegers, int low, int high) {
        int pivot = randomIntegers[low];
        int tempLow = low;

        while (low < high) {
            while (low < high && randomIntegers[high] >= pivot)
                high -= 1;

            while (low < high && randomIntegers[low] <= pivot)
                low += 1;

            if (low < high)
                swap(randomIntegers, low, high);
        }

        swap(randomIntegers, tempLow, high);
        return high;
    }

    private static void swap(int[] randomIntegers, int low, int high) {
        int temp = randomIntegers[low];
        randomIntegers[low] = randomIntegers[high];
        randomIntegers[high] = temp;
    }
}
