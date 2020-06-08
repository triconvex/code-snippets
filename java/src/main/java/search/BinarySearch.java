package search;

public class BinarySearch {

    static int myBinarySearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (value == array[mid]) {
                return mid;
            }
            if (value < array[mid]) {
                right = mid - 1;
            }
            if (value > array[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("myBinarySearch(arr, 0) = " + myBinarySearch(arr, 0));
        System.out.println("myBinarySearch(arr, 8) = " + myBinarySearch(arr, 8));
        System.out.println("myBinarySearch(arr, 9) = " + myBinarySearch(arr, 9));
        System.out.println("myBinarySearch(arr, 10) = " + myBinarySearch(arr, 10));
    }

}
