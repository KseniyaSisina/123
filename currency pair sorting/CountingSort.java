package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */
import java.util.*;

public class CountingSort {
    //на вход функции подается неотсортированный целочисленный массив а
    public static void countingSort(double[] a, double[] b) {

//заводим вспомогательный массив helper, в который будем записывать отсортированные элементы массива а
        double[] helper1 = new double[a.length];
        double[] helper2 = new double[a.length];

//определяем диапазон значений, которые принимают элементы массива а
        double min = a[0];
        double max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            } else if (a[i] > max) {
                max = a[i];
            }
        }

//заводим массив частот встречаемости элементов (сначала заполним его различными значениями из диапазона от min до max)
        int[] counts = new int[(int)max - (int)min + 1];
        for (int i = 0;  i < a.length; i++) {
            counts[(int)a[i] - (int)min]++;
        }

//перестроим массив частот (теперь counts[i] показывает, сколько раз i-й элемент встречается в массиве а)
        counts[0]--;
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

//запишем (с конца) во вспомогательный массив элементы массива а по убыванию их частот
        for (int i = a.length - 1; i >= 0; i--) {
            helper1[counts[(int)a[i] - (int)min]--] = a[i];
            helper2[counts[(int)a[i] - (int)min]--] = b[i];
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = helper1[i];
            b[i] = helper2[i];
        }

    }

    public static void main(String[] args) {
        //подключаем счетчик;
        Date t=new Date();
        //x и y - массивы валютных пар, получаем их из файла
        double[] x;
        double[] y;
        //countingSort(x, y);
        Date s=new Date();
        System.out.println(s.getTime()-t.getTime());
    }
}
