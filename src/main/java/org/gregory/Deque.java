package org.gregory;

public class Deque<T> {

    private NodeDummy nodeDummy;

    public Deque() {
        this.nodeDummy = new NodeDummy();
    }

    private NodeDummy getNodeDummy() {
        return nodeDummy;
    }

    public void addTail(T item) {
        Node<T> nodeInsert = new Node<>(item);

        getNodeDummy().getPrev().setNext(nodeInsert);
        nodeInsert.setNext(getNodeDummy());
        nodeInsert.setPrev(getNodeDummy().getPrev());
        getNodeDummy().setPrev(nodeInsert);
    }

    public void addFront(T item) {
        Node<T> nodeInsert = new Node<>(item);

        getNodeDummy().getNext().setPrev(nodeInsert);
        nodeInsert.setNext(getNodeDummy().getNext());
        nodeInsert.setPrev(getNodeDummy());
        getNodeDummy().setNext(nodeInsert);

    }

    public void addTail(T... valArray) {
        for (T val : valArray) {
            addTail(val);
        }
    }

    public T removeTail() {
        Node nodeTail = getNodeDummy().getPrev();
        getNodeDummy().getPrev().getPrev().setNext(getNodeDummy());
        getNodeDummy().setPrev(getNodeDummy().getPrev().getPrev());
        return (T) nodeTail.getValue();
    }

    public T removeFront() {
        Node nodeFront = getNodeDummy().getNext();
        getNodeDummy().getNext().getNext().setPrev(getNodeDummy());
        getNodeDummy().setNext(getNodeDummy().getNext().getNext());
        return (T) nodeFront.getValue();
    }

    public int size() {
        int i = 0;
        Node index = this.getNodeDummy().getNext();
        while (index != getNodeDummy()) {
            i++;
            index = index.getNext();
        }
        return i;
    }
    
        public static boolean palindrome(String str) {
        Deque<Character> dequeChar = new Deque<>();

        for (int i = 0; i < str.length(); i++) {
            dequeChar.addTail(str.charAt(i));
        }

        Node nodeFront = dequeChar.getNodeDummy().getNext();
        Node nodeTail = dequeChar.getNodeDummy().getPrev();

        for (int i = 0; i < (str.length() / 2) + 1; i++) {
            dequeChar.addTail(str.charAt(i));

            if (nodeFront.getValue() != nodeTail.getValue()) {
                return false;
            }
            nodeFront = nodeFront.getNext();
            nodeTail = nodeTail.getPrev();
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deque that = (Deque) o;

        Node nodeThis = this.getNodeDummy().getNext();
        Node nodeThat = that.getNodeDummy().getNext();

        if (nodeThat == that.getNodeDummy() ^ nodeThis == this.getNodeDummy()) {
            return false;
        }

        while (nodeThat != that.getNodeDummy() && nodeThis != this.getNodeDummy()) {
            if (!nodeThat.getValue().equals(nodeThis.getValue())) {
                return false;
            }
            nodeThat = nodeThat.getNext();
            nodeThis = nodeThis.getNext();
        }

        nodeThat = that.getNodeDummy().getPrev();
        nodeThis = this.getNodeDummy().getPrev();

        while (nodeThat != that.getNodeDummy() && nodeThis != this.getNodeDummy()) {
            if (!nodeThat.getValue().equals(nodeThis.getValue())) {
                return false;
            }
            nodeThat = nodeThat.getPrev();
            nodeThis = nodeThis.getPrev();
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Deque = ");
        Node node = this.getNodeDummy().getNext();
        while (node != getNodeDummy()) {
            builder.append((T) node.getValue());
            node = node.getNext();
        }
        return builder.toString();
    }

}
