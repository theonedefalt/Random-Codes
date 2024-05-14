import java.util.Scanner;

/**
 * 1. Criar variaveis
 * 2. Ler entradas
 * 3. Preencher a matriz
 * 4. Encontrar calculo da espiral
 * 5. Percorrer uma matriz "fantasma" com o tamanho dobrado da matriz original
 * 6. Colocar os valores passados na matriz em um vetor quando o indice estiver
 * entre 0 e N-1
 * 7. Criar um contador para cada vez que passar por um elemento da matriz
 * original
 * 8. Exibir resultados
 */
public class Batuke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // variaveis
        String input;
        String[] tmp;
        input = scanner.nextLine();
        tmp = input.split(" ");
        int N = Integer.parseInt(tmp[0]);
        int F = Integer.parseInt(tmp[1]);
        int C = Integer.parseInt(tmp[2]);
        int count = 0;
        int[][] matriz = new int[N][N];
        int[] arr = new int[(N * N)];
        int k = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = k;
                k++;
            }
        }
        int index = 0;
        // primeira posicao
        if ((F >= 0 && F < N) && (C >= 0 && C < N)) {
            arr[index++] = matriz[F][C];
            count++;
        }
        boolean positivo = true;
        for (int i = 0; index < (N * N); i++) {
            if (positivo) {
                // direita
                for (int j = 0; j < (i + 1); j++) {
                    C++;
                    if ((F >= 0 && F < N) && (C >= 0 && C < N)) {
                        arr[index++] = matriz[F][C];
                        count++;
                    }
                }
            } else {
                // esquerda
                for (int j = 0; j < (i + 1); j++) {
                    C--;
                    if ((F >= 0 && F < N) && (C >= 0 && C < N)) {
                        arr[index++] = matriz[F][C];
                        count++;
                    }
                }
            }
            if (positivo) {
                // baixo
                for (int j = 0; j < (i + 1); j++) {
                    F++;
                    if ((F >= 0 && F < N) && (C >= 0 && C < N)) {
                        arr[index++] = matriz[F][C];
                        count++;
                    }
                }
            } else {
                // cima
                for (int j = 0; j < (i + 1); j++) {
                    F--;
                    if ((F >= 0 && F < N) && (C >= 0 && C < N)) {
                        arr[index++] = matriz[F][C];
                        count++;
                    }
                }
            }

            positivo = positivo ? false : true;
        }

        // for (int i = 0; i < N; i++) {
        // for (int j = 0; j < N; j++) {
        // System.out.println(matriz[i][j]);
        // }
        // }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(count);
        scanner.close();
    }
}
