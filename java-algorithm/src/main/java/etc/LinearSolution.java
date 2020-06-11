package etc;

import java.util.Arrays;

public class LinearSolution {

    static boolean hasDuplicateValue(int[] array) {
        int steps = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                steps++;
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        System.out.println("steps O(N2)= " + steps);
        return false;
    }

    static boolean hasDuplicateValueWithLinearSolution(int[] array) {
        int steps = 0;
        int max = Arrays.stream(array).max().orElseThrow(IllegalArgumentException::new);
        boolean[] existValues = new boolean[max + 1];

        for (int i = 0; i < array.length; i++) {
            steps++;
            if(!existValues[i]) {
                existValues[i] = true;
            } else {
                System.out.println("steps O(N) = " + steps);
                return true;
            }
        }
        System.out.println("steps O(N) = " + steps);
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        hasDuplicateValue(array);
        hasDuplicateValueWithLinearSolution(array);
    }

}
