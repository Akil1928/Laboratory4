package domain;

public class SinglyLinkedList implements List{
private Node firts;//Apuntador al inicio de la lista

    //Contructor
    public SinglyLinkedList(){
        this.firts=null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty())
            throw  new ListException("Singly Linked List is emply");
        int counter = 0;
        Node aux = firts;//Mueve aux a nodo siguiente
        while(aux.next!= null){
            counter ++;
            aux = aux.next;
        }
        return counter;
    }

    @Override
    public void clear() {
this.firts = null;
    }

    @Override
    public boolean isEmpty() {
        return firts == null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
        return false;
    }

    @Override
    public void add(Object element) {
Node newNode = new Node(element);
if(isEmpty())
    firts = newNode;
else{
    Node aux = firts;//Mueve aux a nodo siguiente
    while(aux.next!= null){

    }
    //Sale del while cuando aux esta en el ultimo node
    aux.next = newNode;
}
    }

    @Override
    public void addFirst(Object element) {
Node newNode = new Node(element);
        if(isEmpty())
            firts = newNode;
        else
            newNode.next = firts;
        firts = newNode;
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

    }

    @Override
    public Object removeFirst() throws ListException {
        return null;
    }

    @Override
    public Object removeLast() throws ListException {
        return null;
    }

    @Override
    public void sort() throws ListException {

    }

    @Override
    public int indexOf(Object element) throws ListException {
        return 0;
    }

    @Override
    public Object getFirst() throws ListException {
        return null;
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
        return null;
    }

    @Override
    public String toString() {
        String result = "Singly Linked List Content \n";
        Node aux = firts;//Aux para moverme en la lista
        while(aux!=null){
            result+=aux.data+ " ";
            aux =aux.next;//Mueve al siguiente nodo
        }
        return result;

    }
}
