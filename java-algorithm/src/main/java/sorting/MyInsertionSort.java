package sorting;

import java.util.Arrays;

public class MyInsertionSort {

    static void myInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int position = i; // 1번 인덱스를 temp로 잡고
            int temp = array[i];
            while(position > 0 && array[position - 1] > temp) {
                // 기준값 좌측의 인덱스들을 검증하여, 기준값보다 큰 경우에 우측으로 1씩 쉬프트
                // 기준값 왼쪽은 이미 정렬이 보장된 상태
                // 기준값보다 작은 값을 만나면 기준값을 해당 인덱스 앞에 삽입해준다
                array[position] = array[position - 1];
                position--;
            }
            array[position] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 6, 13, 24, 8, 44, 54, 21, 36};
        System.out.println("array = " + Arrays.toString(array));
        myInsertionSort(array);
        System.out.println("sorted array = " + Arrays.toString(array));
    }

}
