package one;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static class ArrayList2<E> extends ArrayList {
        public void add(E[] array){
            for (int i = 0; i < array.length; i++) {
                super.add(array[i]);
            }
        }
    }//task2

    public static void main(String[] args) {
        task2();
        task3();
        //Task1
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"} ;
        swap(arr1,1,4);
        swap(arr2,0,2);

    }
    public static void swap(Object[] arr, int n1, int n2){
        Object sw = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=sw;
        System.out.println("\n" + "Task1 result: "+Arrays.toString(arr)+"\n================================");
    }
    private static void task2() {
        String[] strings = new String[10];
        Integer[] integers = new Integer[10];

        initStr(strings);
        initInt(integers);

        ArrayList2<String> stringsList = new ArrayList2<>();
        ArrayList2<Integer> integersList = new ArrayList2<>();

        stringsList.add(strings);
        integersList.add(integers);
        System.out.println("\n" + "Task2" + "\n================================");

        System.out.println(stringsList.toString());
        System.out.println(integersList.toString());
    }
    private static void initInt(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i;
        }
    }

    private static void initStr(String[] str) {
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf((char)(i + 97));
        }
    }
    private static void task3() {
        System.out.println("\n" + "Task3" + "\n================================");
        Box<Apple> boxForApple1 = new Box<>();
        Box<Apple> boxForApple2 = new Box<>();
        Box<Orange> boxForOrange = new Box<>();

        for (int i = 0; i < 25; i++) {
            boxForApple1.add(new Apple());
        }

        System.out.println("Вес первой коробки с яблоками - " + boxForApple1.getWeight());

        for (int i = 0; i < 50; i++) {
            boxForApple2.add(new Apple());
        }

        System.out.println("Вес второй коробки с яблоками - " + boxForApple2.getWeight());
        System.out.println("Пересыпаем яблоки в одну коробку");
        boxForApple1.intersperseIn(boxForApple2);

        for (int i = 0; i < 50; i++) {
            boxForOrange.add(new Orange());
        }
        System.out.println("Вес коробки с апельсинами - " + boxForOrange.getWeight());

        System.out.println("Ящики имеют одинаковый вес - " + boxForApple2.compare(boxForOrange));
    }
}
