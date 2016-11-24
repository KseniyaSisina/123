package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */
import java.util.*;

public class BubbleSort {

    public void sort(LinkedList a, LinkedList b) {
        if (a.getCount() > 1) {
            for (int i = 0; i < a.getCount(); i++) {
                Node current_a = a.getTop();
                Node current_b = b.getTop();
                Node next_a = a.getTop().getNext();
                Node next_b = b.getTop().getNext();
                for (int j = 0; j < a.getCount() - 1; j++) {
                    if (current_a.getValue().getVol() > next_a.getValue().getVol()) {
                        swap(current_a, next_a);
                        swap(current_b, next_b);
                    }
                    current_a = next_a;
                    current_b = next_b;
                    next_a = next_a.getNext();
                    next_b = next_b.getNext();
                }
            }
        }
    }

    private void swap(Node a, Node b) {
        Node temp = a;
        a = b;
        b = temp;
    }
}