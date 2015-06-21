package sort;

/**
 * Created by liqiushi on 2/14/14.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] val = {6, 3, 2, 8, 4, 1, 7, 9, 5, 2, 3, 10, 9, 20};
        heapSort(val);

        for (int num : val)
            System.out.print(num + " ");
    }

    private static void heapSort(int[] val) {
        for (int i = val.length / 2 - 1; i >= 0; i--) {
            buildHeap(val[i], i, val, val.length - 1);
        }

        for (int i = 0; i < val.length - 1; i++) {
            swap(val, val.length - 1 - i, 0);
            buildHeap(val[0], 0, val, val.length - 2 - i);
        }
    }

    private static void buildHeap(int rootValue, int rootIndex, int[] val, int end) {
        int childIndex = (rootIndex + 1) * 2 - 1;
        if (childIndex < end && val[childIndex] < val[childIndex + 1])
            childIndex += 1;

        if (childIndex <= end && rootValue < val[childIndex]) {
            val[rootIndex] = val[childIndex];
            buildHeap(rootValue, childIndex, val, end);
        } else {
            val[rootIndex] = rootValue;
        }
    }

    private static void swap(int[] randomIntegers, int i, int i1) {
        int temp = randomIntegers[i];
        randomIntegers[i] = randomIntegers[i1];
        randomIntegers[i1] = temp;
    }
}
