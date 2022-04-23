package my_solution;

public class MyStack<T> {

    private final MyLinkedList<T> list = new MyLinkedList<T>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        return list.remove(list.size() - 1);
    }

    public T peak() {
        return list.get(list.size() - 1);
    }

    public int search(T item) {
        return list.indexOf(item);
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
