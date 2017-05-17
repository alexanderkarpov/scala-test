package coursera.algorithms.course1.week3;

import java.util.Arrays;

/**
 * Created by alexander on 5/17/17.
 */
public class QuickSortJava {

    public static void main(String... args) {
        int[] a = {3, 8, 2, 5, 1, 4, 7, 6};
        partition(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a) {

        if(a.length <= 1) return;

        partition(a, 0, a.length - 1);


    }


    public static void partition(int[] a, int l, int r) {
        int p = a[l];
        int i = l + 1;
        for (int j = l + 1; j <= r; j++) {
            if (a[j] < p) {
                swap(a, j, i);
                i++;
            }
        }

        swap(a, l, i - 1);
    }


    public static void partition2(int[] a, int pivot) {

    }

    private static void swap(int[] a, int i, int j) {
        int buf = a[i];
        a[i] = a[j];
        a[j] = buf;
    }

}
