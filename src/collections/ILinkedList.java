package collections;

public interface ILinkedList<E> {

    public Node<E> getHead();

    public Node<E> getTail();

    public int size();

    public void setSize(int size);

    public void add(E e);

    public int indexOf(E e);

    public E get(int index);

    public Node<E> getNode(int index);

    public void remove(int index);

    public boolean isEmpty();

}
