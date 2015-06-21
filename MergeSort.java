package sort;

/**
 * Created by liqiushi on 2/10/14.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] randomIntegers = {6, 3, 2, 8, 4, 1, 7, 9, 5};
//        int[] randomIntegers1 = {6, 6, 6, 6, 6, 6, 6, 6};

        mergeSortRecursively(randomIntegers, 0, randomIntegers.length - 1);

        print(randomIntegers);

        int[] randomIntegers1 = {6, 3, 2, 8, 4, 1, 7, 9, 5};
        mergeSortIterative(randomIntegers1);
        print(randomIntegers1);
    }

    private static void print(int[] randomIntegers) {
        for (int val : randomIntegers)
            System.out.print(val + " ");
        System.out.println();
    }

    private static void mergeSortIterative(int[] randomIntegers) {
        int distance = 1;
        while (distance < randomIntegers.length) {
            int start = 0;
            int end = distance;

            while (end < randomIntegers.length) {
                merge(randomIntegers, start, (start + end) / 2, end);
                end += distance + 1;
                start = end - distance;
            }
            distance *= 2;
        }
    }

    private static void mergeSortRecursively(int[] numbers, int low, int high) {
        if (numbers == null)
            return;

        if (low >= high)
            return;

        int middle = (low + high) / 2;
        mergeSortRecursively(numbers, low, middle);
        mergeSortRecursively(numbers, middle + 1, high);
        merge(numbers, low, middle, high);
    }

    private static void merge(int[] numbers, int low, int middle, int high) {
        int[] temp = new int[numbers.length];
        int counter = 0;

        int left = low;
        int right = middle + 1;

        while (left <= middle && right <= high) {
            if (numbers[left] < numbers[right]) {
                temp[counter] = numbers[left];
                counter += 1;
                left += 1;
            } else {
                temp[counter] = numbers[right];
                counter += 1;
                right += 1;
            }
        }

        while (left <= middle) {
            temp[counter] = numbers[left];
            counter += 1;
            left += 1;
        }

        while (right <= high) {
            temp[counter] = numbers[right];
            counter += 1;
            right += 1;
        }

        counter = 0;
        for (int i = low; i <= high; i++) {
            numbers[i] = temp[counter++];
        }
    }
}
