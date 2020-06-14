package search;

public class QuickSelect {

    static int quickSelect(int[] array, int rank) {
        return quickSelect(array, rank, 0, array.length - 1);
    }

    static int quickSelect(int[] array, int rank, int left, int right) {
        if (left >= right) {
            return array[left];
        }
        int pivot = partition(array, left, right);

        if (rank < pivot) {
            return quickSelect(array, rank, left, pivot - 1);
        }
        if (rank > pivot) {
            return quickSelect(array, rank, pivot + 1, right);
        }
        return array[pivot];
    }

    static int partition(int[] array, int left, int right) {
        int pivot = right;
        right--;

        while (true) {
            while (array[left] < array[pivot]) {
                left++;
            }
            while (array[right] > array[pivot]) {
                right--;
            }
            if (left >= right) {
                swap(array, left, pivot);
                break;
            } else {
                swap(array, left, right);
            }
        }
        return left;
    }

    static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 12, 14, 3, 22, 51, 43, 9};

        System.out.println("quickSelect(arr, 0) = " + quickSelect(arr, 0));
        System.out.println("quickSelect(arr, 1) = " + quickSelect(arr, 1));
        System.out.println("quickSelect(arr, 2) = " + quickSelect(arr, 2));
        System.out.println("quickSelect(arr, 3) = " + quickSelect(arr, 3));
    }

}
