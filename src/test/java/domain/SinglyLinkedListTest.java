package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

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


        System.out.println("\n********** Contando nombres: **************\n");

        try {
            System.out.println("Buscamos cuántos Carlos tenemos en la lista: " +
                    list.countNames("Carlos"));

            System.out.println("Buscamos cuántas Maria tenemos en la lista: " +
                    list.countNames("Maria"));

            System.out.println("Buscamos cuántos Pedro tenemos en la lista: " +
                    list.countNames("Pedro"));

            System.out.println("Buscamos cuántas Laura tenemos en la lista: " +
                    list.countNames("Laura"));

        } catch (ListException e) {
            System.out.println("Error: " + e.getMessage());
        }

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


        System.out.println("********** Suprimir estudiantes con Id= 1, 3, 5 **************\n");

        try {
            list.remove(new Student("1", "", 0, ""));
            list.remove(new Student("3", "", 0, ""));
            list.remove(new Student("5", "", 0, ""));

            System.out.println("Lista sin los id= 1,3,5: \n" + (list));

        } catch (ListException e) {
            System.out.println("Error al eliminar estudiantes: " + e.getMessage());
        }


        System.out.println("\n********** Ordenando la lista por nombre: **************\n");
        try {
            list.sort();
            System.out.println("Lista ordenada por nombre:");
            System.out.println(list);
        } catch (ListException e) {
            System.out.println("Error al ordenar la lista: " + e.getMessage());
        }

        System.out.println("********** Posiciones en la lista: **************\n");
        try {

            Student carlos8 = new Student("8", "Carlos", 25, "San Carlos");
            int posCarlos8 = list.indexOf(carlos8) + 1;
            System.out.println("El estudiante Carlos con Id=8 se encuentra en la posicion: " + posCarlos8);


            Student carlos100 = new Student("100", "Carlos", 0, "");
            System.out.println("El estudiante Carlos con Id=100 se encuentra en la posicion: " +
                    (list.indexOf(carlos100) + 1));

        } catch (ListException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("********** Recorrido en la lista: **************\n");

        try {

            for (int i = 1; i <= list.size(); i++) {

                Node node = list.getNode(i-1);
                Student student = (Student) node.data;
                System.out.println("El elemento en la posición " + i + " es: " +
                        "ID=" + student.getId() +
                        ", Nombre=" + student.getName() +
                        ", Edad=" + student.getAge() +
                        ", Ciudad=" + student.getAddress());
            }
        } catch (ListException e) {
            System.out.println("Error al acceder a la lista: \n" + e.getMessage());
        }

        System.out.println("\n********** Existen?: **************\n");

        try {
            System.out.println("¿Existe Pedro, Id=20? " + (list.contains(new Student("20", "Pedro", 0, "")) ? "true" : "false"));
            System.out.println("¿Existe Paula, Id=4? " + (list.contains(new Student("4", "Paula", 0, "")) ? "true" : "false"));
            System.out.println("¿Existe Carlos, Id=5? " + (list.contains(new Student("5", "Carlos", 0, "")) ? "true" : "false"));
            System.out.println("¿Existe Carlos, Id=8? " + (list.contains(new Student("8", "Carlos", 0, "")) ? "true" : "false"));
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("Traversing the list using getNode(i):");
            for (int i = 1; i <= list.size(); i++) {
                System.out.println("The element in position " + i + " is: " +
                        list.getNode(i).data);
            }
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        try {
            Student student1 = new Student("8", "Carlos", 25, "San Carlos");
            Student student2 = new Student("100");
            System.out.println("The student Carlos with Id=8 is in position: " +
                    list.indexOf(student1));
            System.out.println("The student Carlos with Id=100 is in position: " +
                    list.indexOf(student2));
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n********** Ordenando la lista por nombre: **************\n");
        try {
            list.sort();
            System.out.println("Lista ordenada por nombre:");
            System.out.println(list);
        } catch (ListException e) {
            System.out.println("Error al ordenar la lista: " + e.getMessage());
        }
        try {
            list.remove(new Student("1"));
            list.remove(new Student("3"));
            list.remove(new Student("5"));
            System.out.println("Students with Id=1, 3, 5 have been removed");
        } catch (ListException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list);

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
