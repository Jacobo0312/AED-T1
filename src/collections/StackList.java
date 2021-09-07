package collections;

public class StackList<E> implements IStackList<E> {

    private Node<E> top;

    public StackList() {
        this.top = null;
    }

    public void push(E value) {
        if (top == null) {
            top = new Node<E>(value);
        } else {
            Node<E> node = new Node<>(value);
            node.setPrevius(top);
            top = node;
        }
    }

    public Node<E> pop() {

        Node<E> temp = top;
        if (top.getPrevius() != null) {
            top = top.getPrevius();
        } else {
            top = null;
        }
        return temp;
    }

    public E top() {
        return top.getItem();
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }
}
