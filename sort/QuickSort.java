import java.util.*;

class QuickSort {

//на вход функции поступает сортируемый массив а, его левая граница start и правая граница left
    public static void quickSort(int[] a, int start, int end) {

//если начало и конец массива встретились, функция заканчивает работу        
        if (start >= end) {
            return;
        }

//i - счетчик пробега по массиву от начала
        int i = start;

//j - счетчик пробега по массиву от конца
        int j = end;

//p - позиция опорного элемента
        int p = start - (start - end) / 2;

//пока не дошли до конца
        while (i < j) {

//пока мы еще левее, чем опорный элемент, и текущий элемент меньше опорного, идем вправо
            while (i < p && a[i] <= a[p]) {
                i++;
            }

//пока мы еще правее, чем опорный элемент, и текущий элемент больше опорного, идем влево
            while (j > p && a[j] >= a[p]) {
                j--;
            }

//если элемент справа от опорного меньше него, а слева от опорного - больше, меняем их местами
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;

//переприсваиваем текущую позицию опорного элемента
                if (i == p) {
                    p = j;
                } else {
                    p = i;
                }
            }
        }

//выполняем рекурсивную сортировку левой части массива (относительно опорного элемента)
        quickSort(a, start, p);

//выполняем рекурсивную сортировку правой части массива (относительно опорного элемента)
        quickSort(a, p + 1, end);
    }

    public static void main(String[] args) {
        int a[];
        a = new int[7];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        quickSort(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}