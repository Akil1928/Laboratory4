package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void testAddCoursesToDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(new Course("IF-3001", "Algoritmos y Estructuras de Datos", 4));
        list.add(new Course("IF-4001", "Sistemas Operativos", 4));
        list.add(new Course("IF-2000", "Programación 1", 4));
        list.add(new Course("IF-3000", "Programación 2", 4));
        list.add(new Course("IF-4000", "Arquitectura", 3));
        list.add(new Course("IF-5000", "Redes", 3));
        list.add(new Course("IF-5100", "Bases de Datos", 4));
        list.add(new Course("IF-4101", "Lenguajes app Comerciales", 4));
        list.add(new Course("IF-3100", "Sistemas de Información", 3));

        try {
            System.out.println("Recorriendo lista de cursos:");
            for (int i = 1; i <= list.size(); i++) {
                System.out.println(list.getNode(i).data);
            }
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("\n¿Existe Informática Aplicada, Id=IF-6201?" + list.containsById("IF-6201"));
            System.out.println("¿Existe Algoritmos y Estructuras de Datos, Id=IF-3001?" + list.containsById("IF-3001"));
            System.out.println("¿Existe Sistemas Operativos, Id=IF-4001?" + list.containsById("IF-4001"));
            System.out.println("¿Existe Análisis y Diseño de Sistemas, Id=IF-6100?" + list.containsById("IF-6100"));
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("\n");
            for (int i = 1; i <= list.size(); i++) {
                System.out.println("The element in position " + i + " is: " +
                        list.getNode(i).data);
            }
        } catch (ListException e) {
            throw new RuntimeException(e);
        }

        try {
            Course course1 = new Course("IF-3001", "Algoritmos y Estructuras de Datos", 4);
            Course course2 = new Course("IF-6100", "Análisis y Diseño de Sistemas", 4);
            System.out.println("\nEl curso Algoritmos y Estructuras de Datos Id=IF-3001 se encuentra en la posición:" +
                    list.indexOf(course1));
            System.out.println("Análisis y Diseño de Sistemas con Id=IF-6100 se encuentra en la posición: " +
                    list.indexOf(course2));
        } catch (ListException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n");
        try {
            list.sort();
            System.out.println("Lista ordenada por nombre:");
            System.out.println(list);
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        try {
            list.remove(new Course("IF-5000", "Redes", 3));
            list.remove(new Course("IF-5100","Bases de Datos", 4));

            System.out.println("\nLos cursos con Id= IF-5000, IF-5100 han sido suprimidos");
            System.out.println(list);
        } catch (ListException e) {
            throw new RuntimeException(e);
        }

    }





    void test() {
        DoublyLinkedList list = new DoublyLinkedList();
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
            System.out.println("Removed first item: "+list.removeFirst());
            System.out.println("List size: "+list.size());
            System.out.println(list);
            System.out.println("Removed first item: "+list.removeFirst());
            System.out.println("List size: "+list.size());
            /*for (int i = 0; i < 6 ; i++) {
                list.removeFirst();
            }*/
            for (int i = 0; i < 50; i++) {
                list.add(util.Utility.random(50));
            }
            System.out.println(list);

            for (int i = 0; i <10 ; i++) {
                int value = util.Utility.random(50);
                System.out.println(
                        list.contains(value)
                                ? "The element ["+value+"] exists in the list. " +
                                "Index: "+list.indexOf(value)
                                :"The element ["+value+" does not exist in the list"
                );

                //probamos remove
                if(list.contains(value)){
                    list.remove(value);
                    System.out.println("The element ["+value+"] has been deleted");
                }
            }

            System.out.println(list);
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
    }
}
