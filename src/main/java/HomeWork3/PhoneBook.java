package HomeWork3;

import java.util.ArrayList;
import java.util.List;

//        2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//        В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get()
//        искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
//        (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.


public class PhoneBook {
    private static final List<People> phoneBook = new ArrayList<>();

    public static void mainBook (String surname) {
        peopleList();
        get(surname);
    }

    private static void peopleList() {
        phoneBook.add(new People("Kroft","+7985345"));
        phoneBook.add(new People("Loft","+79853451"));
        phoneBook.add(new People("Kroft","+79853452"));
        phoneBook.add(new People("Soft","+79853453"));
        phoneBook.add(new People("Schwarzenegger","+79853454"));
        phoneBook.add(new People("Schwarzenegger","+79853455"));
    }

    private static void get(String surname) {
        for (People people : phoneBook) {
            if (people.getSurname().equals(surname)) {
                System.out.printf(people.getPhoneNumber() + "- %s\n",surname);
            }
        }


        
    }

}
