package Person;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        System.out.println("Выберите количество людей:");
        int quantity = new Scanner(System.in).nextInt();
        PersonList myPersonList = new PersonList();
        myPersonList.setAllPerson(quantity);
        System.out.println("Выберите метод сортировки:"+ "\n" + "1 - Пузырьком" + "\n"+ "2 - Вставкой");
        int choice = new Scanner(System.in).nextInt();
        if (choice == 1){
            System.out.println("Случайный список людей");
            myPersonList.printAllPerson(quantity);
            BubbleSorted bubbleSorted = new BubbleSorted();
            System.out.println();
            System.out.println("Список людей отсортированный методом <<Пузырька>> ");
            bubbleSorted.sort(myPersonList.getAllPerson());
            myPersonList.printAllPerson(quantity);
            bubbleSorted.printTimer();
        } else {
            System.out.println("Случайный список людей");
            myPersonList.printAllPerson(quantity);
            InsertSorted insertSorted = new InsertSorted();
            System.out.println();
            System.out.println("Список людей отсортированный методом <<Вставки>> ");
            insertSorted.sort(myPersonList.getAllPerson());
            myPersonList.printAllPerson(quantity);
            insertSorted.printTimer();
        }








    }
}
