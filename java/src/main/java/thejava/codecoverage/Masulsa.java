package thejava.codecoverage;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

public class Masulsa {

    public static void main(String[] args) {
//        ClassLoader classLoader = Masulsa.class.getClassLoader();
//        TypePool typePool = TypePool.Default.of(classLoader);
//
//        try {
//            new ByteBuddy().redefine(
//                    typePool.describe("thejava.codecoverage.Moja").resolve(),
//                    ClassFileLocator.ForClassLoader.of(classLoader)) //이렇게 하면 클래스파일 변경되고, 클래스 블러온다(근데 순서에 너무 의존적이다) 그래서 다른 곳에서 해줘야함!
//                    .method(ElementMatchers.named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//                    .make().saveIn(new File("/Users/zingo/Documents/multi-modules-study/java/out/production/classes/"));
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            new ByteBuddy().redefine(Moja.class)
//                    .method(ElementMatchers.named("pullOut")).intercept(FixedValue.value("Rabbit!"))
//                    .make().saveIn(new File("/Users/zingo/Documents/multi-modules-study/java/out/production/classes/"));
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

        System.out.println(new Moja().pullOut());
    }


}
