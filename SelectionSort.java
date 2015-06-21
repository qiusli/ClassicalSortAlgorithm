package sort;

/**
 * Created by liqiushi on 2/14/14.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] randomIntegers = {6, 3, 2, 8, 4, 1, 7, 9, 5, 2, 3, 10, 9, 20};
//        int[] randomIntegers1 = {6, 6, 6, 6, 6, 6, 6, 6};

        selectionSort(randomIntegers);

        for (int val : randomIntegers)
            System.out.print(val + " ");
    }

    private static void selectionSort(int[] randomIntegers) {
        int minIndex;
        for (int i = 0; i < randomIntegers.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < randomIntegers.length; j++) {
                if (randomIntegers[minIndex] > randomIntegers[j]) {
                    minIndex = j;
                }
            }
            swap(randomIntegers, i, minIndex);
        }
    }

    private static void swap(int[] randomIntegers, int i, int index) {
        int temp = randomIntegers[i];
        randomIntegers[i] = randomIntegers[index];
        randomIntegers[index] = temp;
    }
}
