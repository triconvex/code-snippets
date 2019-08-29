package 더자바_코드를조작하는다양한방법.di;

import 더자바_코드를조작하는다양한방법.annotation.MyAnnotation;

import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class; // 클래스 타입을 가져오는 방법, 1

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass(); // 이미 만들어진 인스턴스에서 getClass 해오는 방법, 2

        Class<?> aClass1 = Class.forName("더자바_코드를조작하는다양한방법.di.Book"); // 클래스 네임을 통해서, 3   스프링이나 어디서 앞과 비슷한 문자열을 본다면, 이런 용도로 쓰일 가능성이 높다

        Arrays.stream(bookClass.getFields()).forEach(System.out::println); // <- 실행하면 d 라는 필드만 찍힌다, getFields <- public 만

        System.out.println("*********************");

        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println); // <- 모든 필드

        System.out.println("*********************");

        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch(IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("*********************");

        //필드뿐만 아니라, 메서드와 생성자, 인스터페이스도 가능하며
        //상위 클래스의 내용까지도 가져올 수 있다


        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if(a instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.name());
                }
            });
        });
    }

    /**
     * Book.class 로딩이 끝나면 힙 영역에 올라간다(클래스를 로딩만 해도 인스턴스가 만들어짐)
     */

}
