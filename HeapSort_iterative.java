package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liqiushi on 6/12/14.
 */
// build min heap
public class HeapSort_iterative {
    public static void main(String[] args) {
        List<Integer> val = new ArrayList<Integer>();
        val.addAll(Arrays.asList(9, 12, 17, 30, 50, 20, 60, 65, 4, 19));

        System.out.println("before heap build : " + val.toString());
        build(val);
        System.out.println("after heap build : " + val.toString());
        System.out.println();

        System.out.println("before insert : " + val.toString());
        insert(val, 2);
        System.out.println("after insert : " + val.toString());
        System.out.println();

        System.out.println("before delete : " + val.toString());
        delete(val, val.size());
        System.out.println("after delete : " + val.toString());
        System.out.println();

        val.clear();
        val.addAll(Arrays.asList(9, 12, 17, 30, 50, 20, 60, 65, 4, 19));


        System.out.println("before heap build : " + val.toString());
        build(val);
        System.out.println("after heap build : " + val.toString());
        System.out.println();

        System.out.println("before heap sort : " + val.toString());
        heapSort(val);
        System.out.println("after heap sort : " + val.toString());
        System.out.println();
    }

    private static void insert(List<Integer> val, int n) {
        val.add(n);
        int parent;
        for (int i = val.size() - 1; i > 0; i = (i - 1) / 2) {
            parent = (i - 1) / 2;

            if (val.get(parent) < n)
                break;

            swap(val, parent, i);
        }
    }

    // i is the index of current code, index of left child is i * 2 + 1, right child is i * 2 + 2
    // startIdx : the index to start fixDown down of the heap
    // fixSize  : the size of the heap
    // i is the start index
    private static void fixDown(List<Integer> val, int startIdx, int fixSize) {
        int childIdx = startIdx * 2 + 1;
        if (childIdx > fixSize)
            return;

        while (childIdx < fixSize) {
            if (childIdx + 1 < fixSize && val.get(childIdx + 1) < val.get(childIdx))
                childIdx += 1;

            if (val.get(childIdx) > val.get(startIdx))
                break;

            swap(val, startIdx, childIdx);

            startIdx = childIdx;
            childIdx = childIdx * 2 + 1;
        }
    }

    private static void delete(List<Integer> val, int fixSize) {
        swap(val, 0, fixSize - 1);
        fixDown(val, 0, fixSize - 1);
    }

    private static void build(List<Integer> val) {
        for (int i = val.size() / 2 - 1; i >= 0; i--) {
            fixDown(val, i, val.size());
        }
    }

    private static void heapSort(List<Integer> val) {
        for (int i = val.size(); i > 0; i--) {
            delete(val, i);
        }
    }

    private static void swap(List<Integer> val, int i, int j) {
        int temp = val.get(i);
        val.set(i, val.get(j));
        val.set(j, temp);
    }
}
