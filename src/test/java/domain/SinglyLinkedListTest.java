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
        System.out.println(list);
    }
}