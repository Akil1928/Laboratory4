package domain;

public class Node {
    public Object data;
    public  Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;//Puntero al siguiente nodo es nulo por default
    }

}
