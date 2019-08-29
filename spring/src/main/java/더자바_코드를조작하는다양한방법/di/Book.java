package 더자바_코드를조작하는다양한방법.di;

import 더자바_코드를조작하는다양한방법.annotation.MyAnnotation;

@MyAnnotation(name = "hello")
public class Book {

    @MyAnnotation(name = "test name c")
    private static final String C = "BOOK";

    private static String B = "BOOK";

    @MyAnnotation(name = "test name a")
    private String a = "a";

    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }
}
