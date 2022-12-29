import java.util.Random;

public class sorting {
    public static void main(String[] args) {
        
        Random r = new Random();
        int size = r.nextInt(20);
        int [] a = new int[size];

        for (int i = 0; i < a.length; i++)
            a[i] = r.nextInt(100);
        
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println(" ");

        //bubbleSort(a);
        //selectSort(a);
        insertionSort(a);


        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
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
    
}
