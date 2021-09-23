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
            node.setPrevious(top);
            top = node;
        }
    }

    public Node<E> pop() {

        Node<E> temp = top;
        if (top.getPrevious() != null) {
            top = top.getPrevious();
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


    public String toString(){

        String message="";
        message+=top.getItem().toString();
        Node <E> temp=top;
        while (temp.getPrevious() !=null) {
            temp=temp.getPrevious();
            message+=temp.getItem().toString();
            
        }
        return message;

    }
}
