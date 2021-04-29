package HomeWork3;

import java.util.List;

//        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать сколько раз встречается каждое слово.

public class MainSolve {

    public static void mainSolveFirstTask(List<String> LIST, List<String> LIST_FOR_COUNT) {
        LIST.sort(String::compareTo);
        for (int i = 0; i < LIST.size(); i++) {
            if (i != LIST.lastIndexOf(LIST.get(i))) {
                LIST_FOR_COUNT.add(LIST.get(i));
                LIST.remove(LIST.lastIndexOf(LIST.get(i)));
                i--;
            }
        }
        for (int i = 0; i < LIST_FOR_COUNT.size(); i++) {
            if (LIST_FOR_COUNT.indexOf(LIST_FOR_COUNT.get(i)) == i) {
                int b = LIST_FOR_COUNT.lastIndexOf(LIST_FOR_COUNT.get(i)) - LIST_FOR_COUNT.indexOf(LIST_FOR_COUNT.get(i)) + 2;
                outputInformation(LIST_FOR_COUNT.get(i),b);
            }
        }
        System.out.println("Other name don`t repeats.");
        System.out.println(LIST);
    }

    private static void outputInformation(String name, int repeatNumbers) {
        System.out.printf("Name %s repeats %d times.\n", name, repeatNumbers);
    }

}
