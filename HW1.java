/*
                                Задание
1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
3. Вставить элемент в список в первой позиции.
4. Извлечь элемент (по указанному индексу) из заданного списка.
5. Обновить определенный элемент списка по заданному индексу.
6. Удалить третий элемент из списка.
7. Поиска элемента в списке по строке.
8. Создать новый список и добавить в него несколько елементов первого списка.
9. Удалить из первого списка все элементы отсутствующие во втором списке.
10. Сортировка списка.
11. Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
*/





import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class HW {
    public static void main(String[] args) {
        run_ex1();
        run_ex2();
        run_ex3();
        run_ex4();
        run_ex5();
        run_ex6();
        run_ex7();
        run_ex8();
        run_ex9_1();
        run_ex9_2();
        run_ex10();
        run_ex11();

    }
    public static void printAL(ArrayList a){
        a.forEach(i-> System.out.print(i+"    "));
        System.out.println();
    }

    public static ArrayList L5_array(){
        ArrayList arr = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            arr.add(new Random().nextInt( 10));
        return arr;
    }

    public static ArrayList const_array(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Первый"); arr.add("Второй"); arr.add("Третий");
        arr.add("Четвёртый"); arr.add("Пятый"); arr.add(1, "Шестой");
        arr.add("Нулевой");
        return arr;
    }

    private static void run_ex1(){
        System.out.println("Add on list and go to desktop:");
        ArrayList<Integer> col1 = L5_array();
        printAL(col1);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex2(){
        System.out.println("Итерация элементов и добавление \"!\":");
        ArrayList<String> col1 = new ArrayList<>();
        col1.add("red");
        col1.add("orange");
        col1.add("yellow");
        col1.add("green");
        col1.add("cyan");
        col1.add("blue");
        col1.add("violet");
        col1.forEach(i-> System.out.print(i+"!  "));
        System.out.println("\n---------------------------------------------------------------------------------------");
    }

    private static void run_ex3() {
        System.out.println("Вставка элементов на позицию 1:");
        ArrayList<Integer> col1 = L5_array();
        printAL(col1);
        col1.add(0, 15);
        System.out.println("15 элементов вперёд...");
        printAL(col1);
        System.out.println("---------------------------------------------------------------------------------------");
        }

    private static void run_ex4(){
        System.out.println("Извлечение по индексу");
        ArrayList<Integer> col1 = L5_array();
        printAL(col1);
        Object[] a = col1.toArray();
        System.out.println("Обратимся ко второму элементу");
        System.out.print(a[1].toString());
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex5(){
        System.out.println("Обновление элемента списка ");
        ArrayList<Integer> col1 = L5_array();
        printAL(col1);
        System.out.println("Поставим 15 на 3ю позицию");
        col1.set(2,15);
        printAL(col1);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex6(){
        System.out.println("Удаление элементов по индексу ");
        ArrayList<Integer> col1 = L5_array();
        printAL(col1);
        System.out.println("Удалим 3й элемент:");
        col1.remove(2);
        printAL(col1);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex7(){
        System.out.println("Поиск элемета по значению");
        ArrayList<String> ranks = const_array();
        printAL(ranks);
        System.out.println("Второго");
        for (int i = 0; i < ranks.toArray().length; i++) {
            if (ranks.toArray()[i].toString() == "Второй")
                System.out.println("Индекс Второго: " + i);
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex8(){
        System.out.println("Создание нового списка из исходного");
        ArrayList<Integer> arr1 = L5_array();
        ArrayList<Integer> arr2 = L5_array();
        System.out.println("Исходный список:");
        printAL(arr1);
        arr1.remove(1); arr1.remove(3);
        System.out.println("Новый спсок:");
        arr1.addAll(arr2);
        printAL(arr1);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex9_1(){
        System.out.println("Удаление из первого списка всех элементов отсутствующие во втором списке");
        System.out.println("Частное решение с учётом особенности задания списка");
        ArrayList arr1 = L5_array();
        ArrayList arr2 = L5_array();
        System.out.println("1й и 2й списки:");
        printAL(arr1);
        printAL(arr2);
        ArrayList arrD = new ArrayList<>();
        int start = -10;
        for (int i = 0; i < 21; i++) {
            arrD.add(start);
            start+=1;
        }
        arrD.removeAll(arr2);
        arr1.removeAll(arrD);
        System.out.println("Итоговый список");
        printAL(arr1);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex9_2(){
        System.out.println("Удаление из 1го списка всех элементов отсутствующие во 2ом списке");
        System.out.println("Общее решение");
        ArrayList<Integer> arr1 = L5_array();
        ArrayList<Integer> arr2 = L5_array();
        System.out.println("1й и 2й списки:");
        printAL(arr1);
        printAL(arr2);
        for (int i = 0; i < arr1.toArray().length; i++)
            if (!arr2.contains(arr1.toArray()[i]))
            {
                arr1.remove(i);
                i--;
            }
        if (arr1.toArray().length != 0)
        {
            System.out.println("Итоговый список");
            printAL(arr1);
        }
        else
            System.out.println("Итоговый список пуст");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex10(){
        System.out.println("Сортировка списка");
        ArrayList<Integer> arr = L5_array();
        Comparator<Integer> comp = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        printAL(arr);
        arr.sort(comp);
        printAL(arr);
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void run_ex11(){
        System.out.println("Сравнение ArrayList'a и LinkedList'a");
        long start;
        long end;
        ArrayList<Integer> arrayList = L5_array();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(new Random().nextInt(10));
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++)
            arrayList.add(0,new Random().nextInt(10));
        end=System.currentTimeMillis();
        int aL = (int) (end-start);

        start=System.currentTimeMillis();
        for (int i = 0; i < 1000; i++)
            linkedList.add(0,new Random().nextInt(10));
        end=System.currentTimeMillis();
        int lL = (int) (end-start);

        System.out.println("Время ArrayList'a: "+aL);
        System.out.println("Время LinkedList'a: "+lL);
        System.out.println("---------------------------------------------------------------------------------------");
    }
}