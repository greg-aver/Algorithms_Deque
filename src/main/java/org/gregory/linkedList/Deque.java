package org.gregory.linkedList;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Deque<T> {
    private LinkedList<T> list;

    public Deque() {
        list = new LinkedList<T>();
    }

    private LinkedList<T> getList() {
        return list;
    }

    public void addFront(T item)
    {
        getList().addFirst(item);
    }

    public void addTail(T item)
    {
        getList().addLast(item);
    }

    public void addTail(T... valArray) {
        for (T val : valArray) {
            addTail(val);
        }
    }

    public T removeFront()
    {
        T val = null;

        try{
            val = getList().removeFirst();
        } catch(NoSuchElementException e) {
            return null;
        }
        return val;
    }

    public T removeTail()
    {
        T val = null;

        try{
            val = getList().removeLast();
        } catch(NoSuchElementException e) {
            return null;
        }
        return val;
    }

    public int size()
    {
        return getList().size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deque that = (Deque) o;
        return Objects.equals(this.getList(), that.getList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Deque = ");

        ListIterator<T> iter = getList().listIterator();
        while (iter.hasNext()) {
            builder.append((T) iter.next());
        }
        return builder.toString();
    }
}
