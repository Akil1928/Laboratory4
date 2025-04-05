package domain;

public class SinglyLinkedList implements List{
    private Node first;//Apuntador al inicio de la lista

    //Contructor
    public SinglyLinkedList(){
        this.first =null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is emply");
        int counter = 0;
        Node aux = first;//Mueve aux a nodo siguiente
        while(aux.next!= null){
            counter ++;
            aux = aux.next;
        }
        return counter;
    }

    @Override
    public void clear() {
        this.first = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is emply");
        Node aux= first;
        while(aux!= null){
            if(util.Utility.compare(aux.data, element) == 0) return true;//Ya lo encontro
            aux = aux.next;//Mover aux al siguiente node
        }
        return false;//Singnifica que no encontro el elemento
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if(isEmpty())
            first = newNode;
        else{
            Node aux = first;//Mueve aux a nodo siguiente
            while(aux.next!= null){
                aux = aux.next;
            }
            //Sale del while cuando aux esta en el ultimo node
            aux.next = newNode;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if(isEmpty())
            first = newNode;
        else
            newNode.next = first;
        first = newNode;
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {
        if (!(element instanceof Comparable))
            throw new IllegalArgumentException("Element must implement Comparable");

        Node newNode = new Node(element);
        if (isEmpty() || ((Comparable)element).compareTo(first.data) < 0) {
            addFirst(element);
            return;
        }

        Node current = first;
        Node previous = null;

        while (current != null && ((Comparable)element).compareTo(current.data) > 0) {
            previous = current;
            current = current.next;
        }

        newNode.next = current;
        previous.next = newNode;
    }

    @Override
    public void remove(Object element) throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is emply");
        //Caso 1
        if(util.Utility.compare(first.data, element) == 0)
            first = first.next;
            //caso 2 el elemento esta al medio o al final
        else{
            Node prev = first;// Nodo anterior
            Node aux = first.next;//Nodo siguiente
            while(aux!= null && !(util.Utility.compare(aux.data, element)== 0)){
                prev = aux;
                aux = aux.next;
            }
            //Se sale cuando alcanza nulo o cuando encuentra el elemento
            if(aux != null && util.Utility.compare(aux.data, element)== 0)
                //Debo desenlazar el nodo
                prev.next = aux.next;
        }

    }

    @Override
    public Object removeFirst() throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is empty");
        Object value = first.data;
        first = first.next;
        return value;
    }

    @Override
    public Object removeLast() throws ListException {
        if (isEmpty())
            throw new ListException("Singly Linked List is empty");

        if (first.next == null) {
            Object data = first.data;
            first = null;
            return data;
        }

        Node prev = first;
        Node current = first.next;

        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        Object data = current.data;
        prev.next = null;
        return data;
    }

    @Override
    public void sort() throws ListException {
        if (isEmpty())
            throw new ListException("Singly Linked List is empty");

        boolean swapped;
        do {
            swapped = false;
            Node current = first;
            Node previous = null;

            while (current != null && current.next != null) {
                try {
                    if (((Comparable) current.data).compareTo(current.next.data) > 0) {
                        Object temp = current.data;
                        current.data = current.next.data;
                        current.next.data = temp;
                        swapped = true;
                    }
                } catch (ClassCastException e) {
                    System.err.println("Error de comparación: Los elementos no son comparables.");
                    System.err.println("Elemento actual: " + current.data.getClass().getName());
                    System.err.println("Elemento siguiente: " + current.next.data.getClass().getName());
                    throw e;
                }
                previous = current;
                current = current.next;
            }
        } while (swapped);
    }

    @Override
    public int indexOf(Object element) throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is emply");
        Node aux = first;
        int index = 1;
        while(aux!=null){
            if(util.Utility.compare(aux.data, element) == 0)return  index;
            index ++;
            aux = aux.next;
        }
        return -1;
    }

    @Override
    public Object getFirst() throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is emply");
        return first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if (isEmpty())
            throw new ListException("Singly Linked List is empty");

        Node aux = first;
        while (aux.next != null) {
            aux = aux.next;
        }
        return aux.data;
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        if (isEmpty())
            throw new ListException("Singly Linked List is empty");

        if (first.data.equals(element))
            throw new ListException("First element has no previous");

        Node prev = first;
        Node current = first.next;

        while (current != null) {
            if (current.data.equals(element))
                return prev.data;
            prev = current;
            current = current.next;
        }
        throw new ListException("Element not found in list");
    }


    @Override
    public Object getNext(Object element) throws ListException {
        if (isEmpty())
            throw new ListException("Singly Linked List is empty");

        Node current = first;

        while (current != null && current.next != null) {
            if (current.data.equals(element))
                return current.next.data;
            current = current.next;
        }
        throw new ListException("Element not found or is last element");
    }
    @Override
    public Node getNode(int index) throws ListException {
        if (isEmpty())
            throw new ListException("Singly Linked List is empty");

        if (index < 0)
            throw new ListException("Index cannot be negative");

        int currentIndex = 0;
        Node aux = first;

        while (aux != null) {
            if (currentIndex == index)
                return aux;
            aux = aux.next;
            currentIndex++;
        }
        throw new ListException("Index out of bounds");
    }
    @Override
    public String toString() {
        if(isEmpty()) return "Singly Linked List is emply";
        String result = "Singly Linked List Content \n";
        Node aux = first;//Aux para moverme en la lista
        while(aux!=null){
            result+=aux.data+ " \n";
            aux =aux.next;//Mueve al siguiente nodo
        }
        return result;

    }

    public int countNames(String name) throws ListException {
        if (isEmpty()) {
            throw new ListException("La lista está vacía");
        }

        int count = 0;
        Node current = first;

        while (current != null) {
            Student student = (Student) current.data;
            if (student.getName().equalsIgnoreCase(name)) {
                count++;
            }
            current = current.next;
        }

        return count;
    }

}
