package sorting;

import java.util.Arrays;

public class MyBubbleSort {

    static void myBubbleSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    static void myBubbleSort2(int[] array) {
        int unsortedIndex = array.length - 1;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unsortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    sorted = false;
                    swap(array, i, i + 1);
                }
            }
            unsortedIndex--;
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
        myBubbleSort2(array);
        System.out.println("sorted array = " + Arrays.toString(array));
    }

}