package collections;

public class Node<E> {

    private Node<E> next;
    private Node<E> previus;
    private E item;

    public Node(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevius() {
        return previus;
    }

    public void setPrevius(Node<E> previus) {
        this.previus = previus;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "{" + getItem();
    }

}
