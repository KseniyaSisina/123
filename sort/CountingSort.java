import java.util.*;
 
public class CountingSort{

//на вход функции подается неотсортированный целочисленный массив а
	public static int[] sort(int[] a) { 

//заводим вспомогательный массив helper, в который будем записывать отсортированные элементы массива а  
		int[] helper = new int[a.length];

//определяем диапазон значений, которые принимают элементы массива а
		int min = a[0];
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			} else if (a[i] > max) {
				max = a[i];
			}
		}

//заводим массив частот встречаемости элементов (сначала заполним его различными значениями из диапазона от min до max)
		int[] counts = new int[max - min + 1];
		for (int i = 0;  i < a.length; i++) {
			counts[a[i] - min]++;
		}

//перестроим массив частот (теперь counts[i] показывает, сколько раз i-й элемент встречается в массиве а) 
		counts[0]--;
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i-1];
		}

//запишем (с конца) во вспомогательный массив элементы массива а по убыванию их частот
		for (int i = a.length - 1; i >= 0; i--) {
			helper[counts[a[i] - min]--] = a[i];
		}
		return helper;
	}
 
	public static void main(String[] args) {
		int a[];
		a = new int[10];
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < a.length; i++) {      
			a[i] = scanner.nextInt();
		}

		int [] sorted = sort(a);

		for (int i = 0; i < a.length; i++) {      
			System.out.print(sorted[i] + " ");
		}
	}
}