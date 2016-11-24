import java.util.*;

class BubbleSort {

//на вход функции поступает неотсортированный целочисленный массив а 
	public static void bubbleSort(int[] a) {

// unsorted - длина неотсортированной части массива
		int unsorted = a.length - 1;

//при помощи счетчика i совершаем проходы по массиву
		for (int i = 0; i < a.length - 1; i++) {

//для каждого i-го элемента счетчик j пробегает массив от начала и до конца неотсортированной части 			
			for (int j = 0; j < unsorted; j++) {

//если последующий элемент больше текущего (т.е. того, с которым мы пробегаем по массиву), то меняем их местами 
				if (a[j] > a[j+1]) {

//здесь мы меняем значения(!) элементов
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}

//после того, как i-й элемент "всплыл", уменьшаем длину неотсортированной части массива на 1 и идем в начало массива за следующим
			unsorted--;
		}
	}

	public static void main(String[] args) {
		int a[];
		a = new int[10];
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < a.length; i++) {			
			a[i] = scanner.nextInt();
		}

		bubbleSort(a);

		for (int i = 0; i < a.length; i++) {			
			System.out.print(a[i] + " ");
		}
	}
}