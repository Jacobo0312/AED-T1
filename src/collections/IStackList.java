package collections;

public interface IStackList<E> {

    public void push(E value);

    public Node<E> pop();

    public E top();

    public boolean isEmpty();
}
