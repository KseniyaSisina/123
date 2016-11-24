import java.util.*;
 
public class BucketSort{
 
    public static void sort(int[] a, int maxVal) {
        int [] bucket = new int[maxVal + 1];
 
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }
 
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
 
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++] = i;
            }
        }
    }

    public static int maximal(int[] a) {
        int max = a[0];
        int maxi = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxi = i;
            }
        }
        return max;
    }
 
    public static void main(String[] args) {
        int a[];
        a = new int[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {      
            a[i] = scanner.nextInt();
        }
        
        int maxVal = maximal(a);
 
        sort(a, maxVal);
        for (int i = 0; i < a.length; i++) {      
            System.out.print(a[i] + " ");
        }
    }
}