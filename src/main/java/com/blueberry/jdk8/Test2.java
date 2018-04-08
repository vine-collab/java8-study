package com.blueberry.jdk8;

/**
 * @author hekai
 * @create 2018-04-08 下午7:22
 */
@FunctionalInterface
interface MyInterface {

    void test();


    @Override
    String toString();
}


public class Test2 {
    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("yyyy");
            }
        });

        System.out.println("----------");

        test2.myTest(() -> System.out.println("xxxx"));

        System.out.println("----------");

        MyInterface myInterface = () -> {
            System.out.println("hello");
        };System.out.println("----------");

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);

    }
}
