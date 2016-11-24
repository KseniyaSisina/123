package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */
import java.util.*;

public class HeapSort {
    public static int heapSize;

    public static void heapSort(double[] a, double[] b) {

// строим кучу
        buildHeap(a, b);

// пока куча не пустая
        while (heapSize > 1) {

// меняем последний элемент кучи с первым
            swap(a, b, 0, heapSize - 1);

// уменьшаем размер кучи, т.е. убираем из рассмотрения последний, уже отсортированный элемент
            heapSize--;

// перестраиваем кучу
            heapify(a, b, 0);
        }
    }

    // функция получает на вход массив (неотсортированное полное бинарное дерево), который должна преобразовать в кучу
    public static void buildHeap(double[] a, double[] b) {

// изначально размер кучи равен размеру массива
        heapSize = a.length;

// начинаем перестраивать кучу с середины (поскольку у элементов, стоящих правее середины, детей нет)
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, b, i);
        }
    }

    // функция получает на вход массив, который она должна преобразовать в кучу (для элемента с i-м номером)
    public static void heapify(double[] a, double[] b, int i) {

// индекс левого сына
        int left = 2 * i + 2;

// индекс правого сына
        int right = 2 * i + 1;

// предполагаем, что родитель - имеет наибольшее значение (largest - индекс максимального)
        int largest = i;

// если есть левый сын и он больше - то ему присваиваем идекс largest
        if (left < heapSize && a[i] < a[left]) {
            largest = left;
        }

// если есть правый сын и он больше, левого и родителя - то ему присваиваем идекс largest
        if (right < heapSize && a[largest] < a[right]) {
            largest = right;
        }

// если индекс родительской вершины - не максимальный, то меняем местами родительский и максимальный элемент
        if (i != largest) {
            swap(a, b, i, largest);

// перестраиваем дерево относительно бывшего максимального
            heapify(a, b, largest);
        }
    }

    // функция получает на вход массив и индексы тех его элементов, которые должна поменять местами
    public static void swap(double[] a, double[] b, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;

        double m = b[i];
        b[i] = b[j];
        b[j] = m;
    }

    public static void main(String[] args) {
        //подключаем счетчик;
        Date t=new Date();
        //x и y - массивы валютных пар, получаем их из файла
        double[] x;
        double[] y;
        //heapSort(x, y);
        Date s=new Date();
        System.out.println(s.getTime()-t.getTime());
    }
}
