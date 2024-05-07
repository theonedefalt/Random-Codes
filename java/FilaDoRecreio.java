import java.io.IOException;
import java.util.Scanner;

public class FilaDoRecreio {

    public static void insercao(int[]arr, int n){
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] < tmp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int M = scanner.nextInt();
            if (M >= 1 && M <= 1000) {
                int[] arr = new int[M];
                int[] ordenado = new int[M];
                for (int j = 0; j < M; j++) {
                    arr[j] = scanner.nextInt();
                    ordenado[j] = arr[j];
                }
                insercao(ordenado, M);
                count = 0;
                for (int j = 0; j < M; j++) {
                    if (arr[j] == ordenado[j]) {
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
        scanner.close();
    }
}
