package my_solution;

public class MyQueue<T> {

    private final MyLinkedList<T> list = new MyLinkedList<T>();

    public void add(T item) {
        list.add(item);
    }

    public T poll() {
        return list.remove(0);
    }

    public T peak() {
        return list.get(0);
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
