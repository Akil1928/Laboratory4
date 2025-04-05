package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void test1(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(new Student("1", "Maria", 20, "Cartago"));
        list.add(new Student("2", "Carlos", 22, "San Jose"));
        list.add(new Student("3", "Laura", 20, "Paraiso"));
        list.add(new Student("4", "Paula", 18, "Turrialba"));
        list.add(new Student("5", "Carlos", 21, "Limon"));
        list.add(new Student("6", "Fabiana", 19, "Paraiso"));
        list.add(new Student("7", "Maria", 23, "Guanacaste"));
        list.add(new Student("8", "Carlos", 25, "San Carlos"));
        list.add(new Student("9", "Laura", 20, "Turrialba"));
        list.add(new Student("10", "Pedro", 24, "Heredia"));
        System.out.println(list);
        try {
            System.out.println(list.contains(new Student("20")) ? "Exists in the list" : "Does not exists");
            System.out.println(list.contains(new Student("4")) ? "Exists in the list" : "Does not exists");
            System.out.println(list.contains(new Student("5")) ? "Exists in the list" : "Does not exists");
            System.out.println(list.contains(new Student("8")) ? "Exists in the list" : "Does not exists");
        } catch (ListException e) {
            throw new RuntimeException(e);
        }

    }
    void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(20);

        list.addFirst(10);
        list.addFirst(30);
        list.addFirst(50);
        list.addFirst(40);
        list.add(70);
        list.add(5);
        System.out.println(list);
        try {
            System.out.println("List size: " + list.size());
            System.out.println("Removed first item " + list.removeFirst());
            System.out.println("List size: " + list.size());
            System.out.println(list);
            System.out.println("Removed first item " + list.removeFirst());
            System.out.println("List size: " + list.size());
            System.out.println(list);
            //for(int i = 0; i< 6 ; i++){
            //    list.removeFirst();
            // }
            for (int i = 0; i < 50; i++) {
                list.add(util.Utility.random(50));


            }
            System.out.println(list);
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(50);
                System.out.println(list.contains(value) ? "The element [ " + value + "] exist in the list. index: " + list.indexOf(value) : "The element dont [ " + value + "] exist in the list");

                if(list.contains(value)){
                    list.remove(value);
                    System.out.println("The element[" + value + "] has been deleted");


                }
            }

            System.out.println(list);
        } catch (ListException e) {
            throw new RuntimeException(e);
        }

    }
}