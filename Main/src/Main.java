import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * 3. Большая задача:
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов
 * и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 * которую подадут в compare в качестве параметра, true - если их веса равны,
 * false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки
 * в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
 * соответственно в текущей коробке фруктов не остается,
 * а в другую перекидываются объекты, которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
 */


public class Main {

    public static void main(String[] args) {

        //1
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arr2 = {"A", "B", "C", "D"};
        exchange(arr1, 1, 4);
        exchange(arr2, 0, 2);

        //2
        String[] arrayOfStrings = {"A", "B", "C", "D", "E", "F", "G"};
        asList(arrayOfStrings);

        //3
        Box<Orange> orange1 = new Box<>();
        Box<Orange> orange2 = new Box<>();
        Box<Apple> apple1 = new Box<>();
        Box<Apple> apple2 = new Box<>();
        System.out.println("Task3");

        System.out.println("g. - addFruit():");
        orange1.addFruit(new Orange(), 3);
        orange2.addFruit(new Orange(), 5);
        apple1.addFruit(new Apple(), 3);
        apple2.addFruit(new Apple(), 6);

        System.out.println("'e' - compare(): ");
        System.out.println("Box 1 equals box 3: " + orange1.compare(apple1));
        System.out.println("Box 2 equals box 4: " + orange2.compare(apple2));

        System.out.println("'f' - pourTo(): ");
        System.out.println("Oranges into Box 2");
        orange1.pourTo(orange2);
        System.out.println("Apples into Box 1");
        apple2.pourTo(apple1);

        System.out.println("d. - getWeight(): ");
        System.out.println("Box 1: " + orange1.getWeight());
        System.out.println("Box 2: " + orange2.getWeight());
        System.out.println("Box 3: " + apple1.getWeight());
        System.out.println("Box 4: " + apple2.getWeight());
    }

    public static void exchange(Object[] arr, int n1, int n2) {
        System.out.println("Task1: " + Arrays.toString(arr));
        Object exchange = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = exchange;
        System.out.printf("The result of the exchange: %s%n ", Arrays.toString(arr));
    }

    public static <T> void asList(T[] arr) {
        ArrayList<T> alt = new ArrayList<>(Arrays.asList(arr));
        System.out.printf("Task2 and the result of the conversion : %s%n", alt);
    }
}
