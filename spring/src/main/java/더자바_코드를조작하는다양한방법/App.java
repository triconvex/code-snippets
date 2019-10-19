package 더자바_코드를조작하는다양한방법;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> animalClass = Class.forName("더자바_코드를조작하는다양한방법.Animal");

        Constructor<?> constructor = animalClass.getConstructor(null);
        Animal animal = (Animal) constructor.newInstance();

        Constructor<?> stringConstructor = animalClass.getConstructor(String.class);
        Animal stringAnimal = (Animal) stringConstructor.newInstance("dog");

        Field a = Animal.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "AAAAA");
        System.out.println(a.get(null));

        Field b = Animal.class.getDeclaredField("b");
        b.setAccessible(true);
        System.out.println(b.get(animal));
        b.set(animal, "BBBBB");
        System.out.println(b.get(animal));

        Method c = Animal.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(animal);

        Method sum = Animal.class.getDeclaredMethod("sum", int.class, int.class);
        System.out.println(sum.invoke(animal, 3, 5));
    }

}
