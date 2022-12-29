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

        bubble(a);
        
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");



    
    }

    public static void bubble(int[] a){
        boolean sorted = true;
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 0; j < a.length - 1 - i; j++){
                if (a[j] > a[j+1]){
                    swap(a, j, j+1);
                    sorted = false;
                }
            }
            if (sorted){
                break;
            }
        }
    }

    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
}
