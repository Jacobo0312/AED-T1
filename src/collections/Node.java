package collections;

public class Node<E> {

    private Node<E> next;
    private Node<E> previous;
    private E item;

    public Node(E item) {
        this.item = item;
        this.next = null;
        this.previous = null;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previus) {
        this.previous = previus;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return getItem()+"";
    }

}
