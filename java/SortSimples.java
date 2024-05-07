import java.io.IOException;
import java.util.*; 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class SortSimples {
    static int[] arr = new int[3];
 
    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
 
    public static void main(String[] args) throws IOException {
        int a = 0, b = 0, c = 0;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        
        a = arr[0];
        b = arr[1];
        c = arr[2];
        
        for(int i = 0; i < (arr.length-1); i++){
            int menor = i;
            for(int j = (i+1); j < arr.length; j++){
                if(arr[menor] > arr[j]){
                    menor = j;
                }
            }
            swap(i, menor);
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}