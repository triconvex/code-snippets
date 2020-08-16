//package ps.boj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Collections;
//
//public class Q2751 {
//
//    public static void main(String[] arg) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] numbers = new int[n];
//
//        for(int i = 0; i < n; i++) {
//            String input = br.readLine();
//            numbers[i] = Integer.parseInt(input);
//        }
//
//        Collections.sort();
//
//        quickSort(numbers);
//
//        StringBuilder result = new StringBuilder();
//        for(int number : numbers) {
//            result.append(number).append(System.lineSeparator());
//        }
//
//        System.out.println(result);
//    }
//
//    private static void quickSort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
//    }
//
//    private static void quickSort(int[] arr, int start, int end) {
//        int partition = partition(arr, start, end);
//        if(start < partition - 1) {
//            quickSort(arr, start, partition - 1);
//        }
//        if(partition < end) {
//            quickSort(arr, partition + 1, end);
//        }
//    }
//
//    private static int partition(int[] arr, int start, int end) {
//        int pivot = arr[(start + end) / 2];
//        while(start < end) {
//            while(arr[start] < pivot) {
//                start++;
//            }
//            while(arr[end] > pivot) {
//                end--;
//            }
//            if(start <= end) {
//                swap(arr, start, end);
//                start++;
//                end--;
//            }
//        }
//        return start;
//    }
//
//    private static void swap(int[] arr, int start, int end) {
//        int temp = arr[start];
//        arr[start] = arr[end];
//        arr[end] = temp;
//    }
//
//}