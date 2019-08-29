package 더자바_코드를조작하는다양한방법;

public class Animal {

    public static String A = "A";

    private String b = "b";

    public Animal() {
    }

    public Animal(String b) {
        this.b = b;
    }

    private void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }

}
