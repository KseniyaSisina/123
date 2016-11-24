package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */

/*
устанавливаем взаимно-однозначное соотношение между валютными парами
 */
public class Bijection {

    public void bijection(LinkedList a, LinkedList b) {
        a.elimination();
        b.elimination();
        Node current_a = a.getTop();
        Node current_b = b.getTop();
        while (current_a != null) {
            while (current_b != null) {
                if ((current_a.getValue().getDate() == current_b.getValue().getDate()) & (current_a.getValue().getTime() == current_b.getValue().getTime())) {
                    current_a.getValue().setBijectionFlag(true);
                    current_b.getValue().setBijectionFlag(true);
                    break;
                }
                current_b = current_b.getNext();
            }
            current_a = current_a.getNext();
        }
        current_a = a.getTop();
        while (current_a != null) {
            if (current_a.getValue().getBijectionFlag() == false) {
                a.remove(current_a.getValue());
            }
            current_a = current_a.getNext();
        }
        while (current_b != null) {
            if (current_b.getValue().getBijectionFlag() == false) {
                b.remove(current_b.getValue());
            }
            current_b = current_b.getNext();
        }
    }
}
