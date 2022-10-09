public class MyHashMap<T, E>{
    private Node head;
    private Node tail;
    private int size;

    public MyHashMap() {
        this.size = 0;
    }

    private class Node {
        private T key;
        private E value;
        Node next;

        public Node(T key, E value) {
            this.value = value;
            this.key = key;
        }
    }

    public void add(T key, E value) {
        checker(key);
        Node temp = new Node(key, value);
        if (head == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
        size++;
    }

    private void checker(T key){
        if (size == 0){
            return;
        }
        int counter = 0;
        Node current = head;

        for (int i = 0; i <= size; i++) {
            if (key == current.key){
                counter++;
            }
            if (counter == 1){
                throw new IllegalArgumentException();
            }
            if (current.next == null){
                break;
            }
            current = current.next;
        }
    }

    public void remove(T key) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (key == current.key){
                break;
            }
            if (current.key != key){
                if (i == size - 1 && current.next == null){
                    throw new IllegalArgumentException();
                }
            }
            current = current.next;
        }
        while (current.next != null){
            current.key = current.next.key;
            current.value = current.next.value;
            current = current.next;
        }
        tail = current;
        size--;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public E get(T key) {
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (current.key != key){
                if (i == size - 1 && current.next.key == null){
                    throw new IndexOutOfBoundsException();
                }
            }
            if (current.key == key){
                break;
            }
            current = current.next;
        }

        return current.value;
        }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            String result = "[" + head.value;
            Node current = head.next;
            for (int i = 0; i < size - 1; i++) {
                result += ", " + current.value;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
}
