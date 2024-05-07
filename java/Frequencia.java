import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Frequencia {
    public static void swap(int[]arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selecao(int[]arr, int n){
        for (int i = 0; i < (n-1); i++) {
            int menor = i;
            for (int j = (i+1); j < n; j++) {
                if (arr[menor] > arr[j]) {
                    menor = j;
                }
            }
            swap(arr, i, menor);
        }
    }

    public static int getMaior(int[]arr){
        int maior = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maior < arr[i]) {
                maior = arr[i];
            }
        }
        return maior;
    }
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] arr = new int[N];

        // ler entradas
        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();
            arr[i] = number;
        }

        int maior = getMaior(arr);
        int[]count = new int[maior+1];

        // contagem de valores
        for (int i = 0; i < N; i++) {
            count[arr[i]]++; 
        }

        int[] ordenado = new int[N];
        // iniciar hashSet
        HashSet<Integer> hashSet = new HashSet<>();
        int ordenadoSize = 0;
        for (int i = 0; i < N; i++) {
            // se nao for repetido adicionar ao ordenado
            if (!hashSet.contains(arr[i])) {
                ordenado[ordenadoSize++] = arr[i];
                hashSet.add(arr[i]);
            }
        }
        // ordenar
        selecao(ordenado, ordenadoSize);
        
        // exibir resultado
        for (int i = 0; i < ordenadoSize; i++) {
            System.out.println(ordenado[i] + " aparece "+ count[ordenado[i]] +" vez(es)");
        }

        scanner.close();
    }
}
