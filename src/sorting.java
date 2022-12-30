import java.util.Random;
import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        
        Random r = new Random();
        int size = r.nextInt(20);
        int [] a = new int[size];

        for (int i = 0; i < a.length; i++)
            a[i] = r.nextInt(100);

        a[0] = 0;
        
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println(" ");

        //bubbleSort(a);
        //selectSort(a);
        //insertionSort(a);
        //a = mergeSort(a);
        //quickSort(a, 0, a.length - 1);
        heapSort(a);
        

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }


    public static void heapSort(int[] a) {
        buildMaxHeap(a);
        for (int i = a.length - 1; i > 0; i--){
            swap(a, 1, i);
            downHeap(a, 1, i);
        }
        
        
    }

    public static void buildMaxHeap(int[] a) {
        for (int i = a.length / 2; i > 0; i--){
            downHeap(a, i, a.length - 1);
        }   
    }

    public static void downHeap(int[] a, int i, int until) {
        int max = i;

        if (2 * i < a.length && 2 * i < until && a[i] < a[2 * i]){
            max = 2 * i;
        }
        if (2 * i + 1 < a.length && 2 * i + 1 < until && a[max] < a[2 * i + 1]){
            max = 2 * i + 1;
        }
        if (max != i){
            swap(a, i, max);
            downHeap(a, max, until);
        }
        
    }


    public static void quickSort(int[] a, int low, int high){
        if (low >= high){
            return;
        }
        int p = partition(a, low, high);
        quickSort(a, low, p-1);
        quickSort(a, p + 1, high);
    }

    public static int partition(int[] a, int low, int high){

        int p = a[high];
        int wall = low - 1;

        for (int i = low; i <= high; i++){
            if (a[i] <= p){
                wall++;
                swap(a, wall, i);
            }
        }
        return wall;
    }

    public static int[] mergeSort(int[] a){
        if (a.length == 1){
            return a;
        }
        int[] b = mergeSort(Arrays.copyOfRange(a, 0, a.length / 2));
        int[] c = mergeSort(Arrays.copyOfRange(a, a.length / 2, a.length));
        
        return merge(b, c);
    }

    public static void insertionSort(int[] a) {
        int j;
        for (int i = 0; i < a.length; i++){
            j = i;
            while (j > 0 && a[j] < a[j - 1]){ //switch to > and it sorts it in descending
                swap(a, j, j-1);
                j--;
            }
        }
    }

    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 0; j < a.length - 1 - i; j++){
                if (a[j] > a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
    }

    public static void selectSort(int[] a){
        int curMinIndex;
        for (int i = 0; i < a.length - 1; i++){
            curMinIndex = i;
            for (int j = i; j < a.length; j++){
                if (a[curMinIndex] > a[j]){
                    curMinIndex = j;
                }
            }
            swap(a, i, curMinIndex);
        }
    }

    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static int[] merge(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < a.length || j < b.length){
            if (i == a.length){
                c[k] = b[j];
                j++;
            }
            else if (j == b.length){
                c[k] = a[i];
                i++;
            }
            else if (a[i] < b[j]){
                c[k] = a[i];
                i++;
            }
            else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        return c;

    }
}
