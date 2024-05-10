import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Jaspion {
        private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

    public static String readLine() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != 13) {
                    s += tmp;
                }
            } while (tmp != '\n');
        } catch (IOException ioe) {
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static String readString() {
        String s = "";
        char tmp;
        try {
            do {
                tmp = (char) in.read();
                if (tmp != '\n' && tmp != ' ' && tmp != 13) {
                    s += tmp;
                }
            } while (tmp != '\n' && tmp != ' ');
        } catch (IOException ioe) {
            System.out.println("lerPalavra: " + ioe.getMessage());
        }
        return s;
    }

    public static int readInt() {
        int i = -1;
        try {
            i = Integer.parseInt(readString().trim());
        } catch (Exception e) {
        }
        return i;
    }

    public static String replaceAll(String oldString, String newString, String string){
        StringBuilder result = new StringBuilder(string);
        int index = 0;
        while ((index = result.indexOf(oldString, index)) != - 1) {
            result.replace(index, index + oldString.length(), newString);
            index += oldString.length();
        }
        return result.toString();
    }
    
    
    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(readLine());

        for (int i = 0; i < T; i++) {
            String nums = readLine();
            String[] numsSplit = nums.split(" ");
            int M = 0, N = 0;
            M = Integer.parseInt(numsSplit[0]);
            N = Integer.parseInt(numsSplit[1]); 

            HashMap<String, String> hashMap = new HashMap<String, String>();

            for (int index = 0; index < M; index++) {
                String japones = readString();
                String portugues = readLine();
                hashMap.put(japones, portugues);
            }
            String[] linhas = new String[N];
            for (int j = 0; j < N; j++) {
                linhas[j] = readLine();
            }

            for (int j = 0; j < N; j++) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    if (linhas[j].contains(entry.getKey())) {
                        linhas[j] = replaceAll(entry.getKey(), entry.getValue(), linhas[j]);
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                System.out.println(linhas[j]);
            }
            System.out.println();
        }
    }
}