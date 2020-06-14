package etc;

public class RecursionSolution {

    private static int factorial(int i) {
        if(i == 1) {
            return i;
        } else {
            return i * factorial(i - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("factorial(5) = " + factorial(5));
        System.out.println("factorial(4) = " + factorial(4));
        System.out.println("factorial(3) = " + factorial(3));
        System.out.println("factorial(2) = " + factorial(2));
        System.out.println("factorial(1) = " + factorial(1));
    }

}
