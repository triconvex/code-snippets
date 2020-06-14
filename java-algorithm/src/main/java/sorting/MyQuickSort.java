package sorting;

import java.util.Arrays;

public class MyQuickSort {

    static void myQuickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
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
            if(left >= right) {
                // 양 포인터가 겹쳐지면 피봇을 기준으로 좌우측 정렬이 완료됨
                // 이 시점에 array[left]는 array[pivot]보다 큰 값, 고로 pivot의 우측에 위치해야함
                // 그래서 pivot과 left값을 서로 바꿔서 정렬하면
                // array[pivot]보다 작음 - array[pivot] - array[pivot]보다 큼
                swap(array, left, pivot);
                break;
            } else {
                //양 포인터가 만나지 않았다면 양포인터의 값을 서로 바꿔서 정렬
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
        int[] array = {1, 3, 2, 4, 6, 13, 24, 8, 44, 54, 21, 36};
        System.out.println("array = " + Arrays.toString(array));
        myQuickSort(array);
        System.out.println("sorted array = " + Arrays.toString(array));
    }

}
