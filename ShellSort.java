package sort;

/**
 * Created by liqiushi on 2/14/14.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] randomIntegers = {6, 3, 2, 8, 4, 1, 7, 9, 5, 2, 3, 10, 9, 20};
//        int[] randomIntegers1 = {6, 6, 6, 6, 6, 6, 6, 6};

        shellSort(randomIntegers);

        for (int num : randomIntegers)
            System.out.print(num + " ");
    }

    private static void shellSort(int[] randomIntegers) {
        int distance = randomIntegers.length / 2;

        while (distance >= 1) {
            for (int i = distance; i < randomIntegers.length; i += distance) {
                int valueToSort = randomIntegers[i];
                int j = i;
                while (j > 0 && randomIntegers[j - distance] > valueToSort) {
                    randomIntegers[j] = randomIntegers[j - distance];
                    j -= distance;
                }
                randomIntegers[j] = valueToSort;
            }
            distance /= 2;
        }
    }
}
