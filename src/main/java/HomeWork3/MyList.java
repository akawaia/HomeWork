package HomeWork3;

import java.util.*;
//        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать сколько раз встречается каждое слово.
//        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
//        искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//        (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

public class MyList {
    private static final String[] ARR = {"Bred", "Jumba", "Matumba", "Garry","Alex", "Potter", "Sara", "Alex", "Logan", "Jack", "Alex", "Lara", "Garry", "Alex", "Alex"};
    private static final List<String> LIST = new ArrayList<>(Arrays.asList(ARR));
    private static final List<String> LIST_FOR_COUNT = new ArrayList<>();


    public static void main(String[] args) {

       MainSolve.mainSolveFirstTask(LIST, LIST_FOR_COUNT);
        PhoneBook.mainBook("Kroft");
    }



}



