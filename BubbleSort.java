package sort;

/**
 * Created by liqiushi on 2/14/14.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] randomIntegers = {6, 3, 2, 8, 4, 1, 7, 9, 5, 2, 3, 10, 9, 20};

        bubbleSort(randomIntegers);

        for (int val : randomIntegers)
            System.out.print(val + " ");
    }

    private static void bubbleSort(int[] randomIntegers) {
        boolean flag = true;
        for (int i = 0; i < randomIntegers.length && flag; i++) {
            flag = false;
            for (int j = 1; j < randomIntegers.length - i; j++) {
                if (randomIntegers[j - 1] > randomIntegers[j]) {
                    swap(randomIntegers, j - 1, j);
                    flag = true;
                }
            }
        }
    }

    private static void swap(int[] randomIntegers, int i, int j) {
        int temp = randomIntegers[i];
        randomIntegers[i] = randomIntegers[j];
        randomIntegers[j] = temp;
    }
}
