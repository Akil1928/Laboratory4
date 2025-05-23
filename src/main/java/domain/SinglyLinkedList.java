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

    }

    @Override
    public void remove(Object element) throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is emply");
        //Caso 1
        if(util.Utility.compare(first.data, element) == 0)
            first = first.next;
        //caso 2 el eleento esta al medio o al final
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
            throw  new ListException("Singly Linked List is emply");
        Object value = first.data;
        first = first.next;
        return value;
    }

    @Override
    public Object removeLast() throws ListException {
        return null;
    }

    @Override
    public void sort() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");


        for(int i = 1; i <= size(); i++){
            for(int j = 1; j <= size()-i; j++){
                Student student1 = (Student)getNode(j).data;
                Student student2 = (Student)getNode(j+1).data;

                if(student1.getName().compareTo(student2.getName()) > 0){

                    Object temp = getNode(j).data;
                    getNode(j).data = getNode(j+1).data;
                    getNode(j+1).data = temp;
                }
            }
        }
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
        return null;
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        return null;
    }

    @Override
    public Object getNext(Object element) throws ListException {
        return null;
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Node aux = first;
        int i = 1; //position of the first node
        while(aux != null){
            if(util.Utility.compare(i, index) == 0){
                return aux;
            }
            i++;
            aux = aux.next; //move to next node
        }
        return null;
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
    public boolean findNames(String name) throws ListException {
        if (isEmpty()) {
            throw new ListException("La lista está vacía");
        }

        Node current = first;

        while (current != null) {
            Student student = (Student) current.data;
            if (student.getName().equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }

        return false;
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
}
