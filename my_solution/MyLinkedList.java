package my_solution;

public class MyLinkedList<T> implements MyList<T> {

    private static class MyNode<T> {
        T data;
        MyLinkedList.MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        MyNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void add(T item) {
        MyLinkedList.MyNode<T> newNode = new MyLinkedList.MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        MyLinkedList.MyNode<T> newNode = new MyLinkedList.MyNode<>(item);
        MyNode<T> currentNode = head;
        for (int i = 0; currentNode != null; i++, currentNode = currentNode.next) {
            if (i == index) {
                currentNode.prev.next = newNode;
                newNode.prev = currentNode.prev;
                newNode.next = currentNode;
                newNode.next.prev = newNode;
                length++;
                return;
            }
        }
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        MyNode<T> currentNode = head;
        for (int i = 0; currentNode != null; i++, currentNode = currentNode.next) {
            if (i == index) {
                if (currentNode.prev == null) {
                    head = currentNode.next;
                    head.prev = null;
                } else {
                    currentNode.prev.next = currentNode.next;
                }
                if (currentNode.next == null) {
                    tail = currentNode.prev;
                    tail.next = null;
                } else {
                    currentNode.next.prev = currentNode.prev;
                }
                length--;
                return currentNode.data;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public T get(int index) {
        MyNode<T> currentNode = head;
        for (int i = 0; currentNode != null; i++, currentNode = currentNode.next) {
            if (i == index) {
                return currentNode.data;
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        MyNode<T> currentNode = head;
        for (int i = 0; currentNode != null; i++, currentNode = currentNode.next) {
            if (currentNode.data.equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> currentNode = tail;
        for (int i = length - 1; currentNode != null; i--, currentNode = currentNode.prev) {
            if (currentNode.data.equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        MyNode<T> p = head, p2;
        T temp;
        if (head != null) {
            while (p != null) {
                p2 = p.next;
                while (p2 != null) {
                    if (((Comparable) p.data).compareTo(p2.data) > 0) {
                        temp = p.data;
                        p.data = p2.data;
                        p2.data = temp;
                    }
                    p2 = p2.next;
                }
                p = p.next;
            }
        }
    }

    @Override
    public String toString() {
        String r = "";
        MyNode<T> p = head;
        while (p != null) {
            r += p.data.toString() + ", ";
            p = p.next;
        }
        return r;
    }
}
