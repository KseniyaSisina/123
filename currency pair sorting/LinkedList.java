package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */

/*
создаем связный список - структуру данных, хранящую информацию по валютным парам за период исследования
 */

public class LinkedList {

    private Node top;
    private Node last;
    private Node current;
    private int count;

    public Node getTop() {
        return this.top;
    }
    public int getCount() { return this.count; }

//добавление узла в начало списка (чтобы не пролистывать весь список каждый раз, когда добавляем узел)
    public void addToBegin(Pair value) {
        Node newNode = new Node(value);
        if (top == null) {
            this.top = newNode;
            this.last = newNode;
        } else {
            newNode.setNext(this.top);
            this.top = newNode;
        }
        this.count++;
    }

//добавление узла в конец списка
    public void addToEnd(Pair value) {
        Node newNode = new Node(value);
        if (top == null) {
            this.top = newNode;
            this.last = newNode;
        } else {
            Node current = this.top;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.count++;
    }

//удаление узла из списка
    public void remove(Pair value) {
        if (this.top.getValue() == value) {
            this.top = this.top.getNext();
            this.count--;
        } else {
            Node current = this.top;
            int i = 0;
            while ((i < this.count - 1) && current.getNext().getValue() != value) {
                current = current.getNext();
                i++;
            }
            if (current.getNext() == null) {
                return;
            }
            current.setNext(current.getNext().getNext());
            this.count--;
        }
    }

//слияние списков
    public void union(LinkedList newList) {
        if (this.last == null) {
            this.top = newList.top;
            this.last = newList.last;
            return;
        }
        this.last.setNext(newList.top);
        this.last = newList.last;
    }

//возвращение следующего узла из списка
    public Pair getCurrentValue() {
        if (current == null) {
            current = this.top;
            return current.getValue();
        }
        Node temp = current.getNext();
        current = current.getNext();
        if (temp == null) {
            return null;
        }

        return temp.getValue();
    }

//удаление узлов из списка с повторяющимся временем и датой свечи - установление биективного соотношения
    public void elimination() {
        Node current = this.top;
        while (current != null) {
            if ((current.getValue().getDate() == current.getNext().getValue().getDate()) & (current.getValue().getTime() == current.getNext().getValue().getTime())) {
                remove(current.getNext().getValue());
            }
            current = current.getNext();
        }
    }

}


