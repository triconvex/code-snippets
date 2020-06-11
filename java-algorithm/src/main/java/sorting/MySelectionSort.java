package sorting;

import java.util.Arrays;

public class MySelectionSort {

    static void mySelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minimumIndex = i;
            for (int j = i; j < array.length; j++) {
                if(array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            if(minimumIndex != i) {
                swap(array, i, minimumIndex);
            }
        }
    }

    static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 6, 13, 24, 8, 44, 54, 21, 36};
        System.out.println("array = " + Arrays.toString(array));
        mySelectionSort(array);
        System.out.println("sorted array = " + Arrays.toString(array));
    }

}
