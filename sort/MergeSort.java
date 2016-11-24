import java.util.*;
 
public class MergeSort {
 
//на вход функции поступает неотсортированный целочисленный массив a
    public static void mergeSort(int[] a) {

//массив, состоящий из одного элемента, можно считать упорядоченным. Пока массив не упорядочен, выполняем:
        if (a.length > 1) {

//в массив left помещаем левую половину массива
            int[] left = leftHalf(a);

//в массив right помещаем правую половину массива
            int[] right = rightHalf(a);
 
//рекурсивно сортируем левую половину
            mergeSort(left);

//рекурсивно сортируем правую половину
            mergeSort(right);

//сливаем отсортированные левую и правую половину в один массив
            merge(a, left, right);
        }
    }
 

//на вход функции поступает сортируемый массив а, левую половину которого копируем 
    public static int[] leftHalf(int[] a) {

//размер массива, который мы получим на выходе, size1 - равен половине входного массива
        int size1 = a.length / 2;
        int[] left = new int[size1];

//в новый массив запишем элементы входного массива из левой его половины 
        for (int i = 0; i < size1; i++) {
            left[i] = a[i];
        }

//получаем копию левой половины сортируемого массива а
        return left;
    }

//на вход функции поступает сортируемый массив аб правую половину которого копируем  
    public static int[] rightHalf(int[] a) {

//size1 - индекс элемента массива а, начиная с которого мы копируем его элементы 
        int size1 = a.length / 2;

//размер массива, который мы получим на выходе,  - size2
        int size2 = a.length - size1;
        int[] right = new int[size2];

//в новый массив запишем элементы входного массива из правой его половины 
        for (int i = 0; i < size2; i++) {
            right[i] = a[i + size1];
        }

//получаем копию правой половины сортируемого массива а
        return right;
    }
 

//на вход функции поступает левая (left) и правая (right) части, которые затем сливаются в один массив (result)
    public static void merge(int[] result, int[] left, int[] right) {

//i1 - счетчик для массива left
        int i1 = 0;

//i2 - счетчик для массива right  
        int i2 = 0; 

//i - счетчик для результирующнго массива
        for (int i = 0; i < result.length; i++) {

//выполняем проверку на случай, если все элементы правой половины уже записаны в результирующий массив или 
//еще остались незаписанные элементы в обеих частях, причем текущий элемент левой части меньше текущего элемента правой части
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {

//в этом случае записываем элемент из левой части в результирующий массив и берем из левой половины следующий
                result[i] = left[i1]; 
                i1++;

//в противном случае (т.е. либо когда элементы в левой части закончились, 
//либо когда текущий элемент левой части больше текущего элемента правой части) делаем то же самое с правой частью
            } else {
                result[i] = right[i2]; 
                i2++;
            }
        }
    }

    public static void main(String[] args) {
        int a[];
        a = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {            
            a[i] = scanner.nextInt();
        }

        mergeSort(a);
        
        for (int i = 0; i < a.length; i++) {            
            System.out.print(a[i] + " ");
        }
    }
}