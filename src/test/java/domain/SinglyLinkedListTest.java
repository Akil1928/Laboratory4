package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void test() {
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
            System.out.println("List size: "+list.size());
            System.out.println("Removed first item "+list.removeFirst());
            System.out.println("List size: "+list.size());
            System.out.println(list);
            System.out.println("Removed first item "+list.removeFirst());
            System.out.println("List size: "+list.size());
            System.out.println(list);
            //for(int i = 0; i< 6 ; i++){
            //    list.removeFirst();
           // }
            for (int i = 0; i < 50; i++) {
                list.add(util.Utility.random(50));


            }
            System.out.println(list);
            for(int i = 0; i< 10 ; i++){
                int value = util.Utility.random(50);
                System.out.println(list.contains(value) ? "The element [ "+ value+ "] exist in the list. index: "+ list.indexOf(value) : "The element dont [ "+ value+ "] exist in the list");
            }
            System.out.println(list);
        } catch (ListException e) {
            throw new RuntimeException(e);
        }

    }
}