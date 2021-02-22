package org.gregory;

public class Node<T> {
    private T value;
    private Node next;
    private Node prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }

    public Node(Node prev, T value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
