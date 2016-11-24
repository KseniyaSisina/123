import java.util.*;
class HeapSort {
    public static int heapSize;

    public static void heapSort(int a[]) {

// строим кучу
        buildHeap(a);

// пока куча не пустая
        while (heapSize > 1) {

// меняем последний элемент кучи с первым
            swap(a, 0, heapSize - 1);

// уменьшаем размер кучи, т.е. убираем из рассмотрения последний, уже отсортированный элемент
            heapSize--;

// перестраиваем кучу
            heapify(a, 0);
        }
    }
    
// функция получает на вход массив (неотсортированное полное бинарное дерево), который должна преобразовать в кучу
    public static void buildHeap(int a[]) {

// изначально размер кучи равен размеру массива
        heapSize = a.length;

// начинаем перестраивать кучу с середины (поскольку у элементов, стоящих правее середины, детей нет)
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

// функция получает на вход массив, который она должна преобразовать в кучу (для элемента с i-м номером)
    public static void heapify(int[] a, int i) {
        
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
            swap(a, i, largest);
            
// перестраиваем дерево относительно бывшего максимального
            heapify(a, largest);
        }
    }

// функция получает на вход массив и индексы тех его элементов, которые должна поменять местами
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }



    public static void main(String[] args) {
        int a[];
        a = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        heapSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}