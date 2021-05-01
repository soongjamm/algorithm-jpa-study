package test;

import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void staticOrder() {
        System.out.println(MyClass.value);
        MyClass aClass = new MyClass();
        System.out.println("aClass = " + aClass);
    }

    static class MyClass {
        static int value = 1;

        static {
            System.out.println("value = " + value);
            value=3;
            System.out.println(value);
        }

        public MyClass() {
            value = 2;
            System.out.println(value);
        }
    }
}
