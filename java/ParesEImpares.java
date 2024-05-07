import java.io.IOException;
import java.util.Scanner;

public class ParesEImpares{
    public static void swap(int[]arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quicksort(int[] arr, int esq, int dir){
        int i = esq, j = dir;
        int pivo = arr[(esq+dir)/2];
        while (i <= j) {
            while (arr[i] < pivo) i++;
            while (arr[j] > pivo) j--;
            if (i <= j) { swap(arr, i, j); i++; j--; }
        }
        if (esq < j) quicksort(arr, esq, j);
        if (i < dir) quicksort(arr, i, dir);
    }
    public static void reverseQuicksort(int[] arr, int esq, int dir){
        int i = esq, j = dir;
        int pivo = arr[(esq+dir)/2];
        while (i <= j) { 
            while (arr[i] > pivo) i++;
            while (arr[j] < pivo) j--;
            if (i <= j) { swap(arr, i, j); i++; j--; }
        }
        if (esq < j) reverseQuicksort(arr, esq, j);
        
        if (i < dir) reverseQuicksort(arr, i, dir);
    }
    public static void main(String[] args) throws IOException{
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if (n > 1 && n <= (10*10*10*10*10)) {
            int[]arr = new int[n];
            int number = 0, evenIndex = 0, oddIndex = 0;
            for (int i = 0; i < n; i++) {
                number = scanner.nextInt();
                if (number % 2 == 0) { arr[evenIndex++] = number;}
                else{arr[n - 1 - oddIndex++] = number;}
            }

            quicksort(arr, 0, evenIndex-1);
            reverseQuicksort(arr, evenIndex, n-1);
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
        scanner.close();
    }
}
