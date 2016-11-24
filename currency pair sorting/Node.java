package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */

/*
формируем узел двусвязного списка, который будет хранить всю информацию по валютной паре на конкретную дату и время
 */

public class Node {

    private Pair value;
    private Node next;

    public Node(Pair value) {
        this.value = value;
    }

    public Node(Pair value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Pair getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
