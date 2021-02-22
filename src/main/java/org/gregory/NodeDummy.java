package org.gregory;

public class NodeDummy extends Node {
    public NodeDummy() {
        super(null);
        setNext(this);
        setPrev(this);
    }
}
