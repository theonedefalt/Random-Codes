import java.util.Scanner;

public class Batuke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[]tmp;
        input = scanner.nextLine();
        tmp = input.split(" ");

        int N = Integer.parseInt(tmp[0]);
        int F = Integer.parseInt(tmp[1]);
        int C = Integer.parseInt(tmp[1]);

        int[][] matriz = new int[N][N];
        int k = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = k;
                k++;
            }
        }

        for (int i = 0; i < (N*N); i++) {
            
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.println(matriz[i][j]);
        //     }
        // }
    }
}
