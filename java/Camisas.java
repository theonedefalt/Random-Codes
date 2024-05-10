import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Aluno {
    private String nome;
    private String cor;
    private String tamanho;

    public Aluno() {
        this.nome = "";
        this.cor = "";
        this.tamanho = "";
    }

    public Aluno(String nome, String cor, String tamanho) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}

/**
 * Camisas
 */
public class Camisas {
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

    public static void main(String[] args) throws IOException {
        int N = 0;
        N = readInt();
        while (N != 0 && N <= 60) {
            List<Aluno> alunos = new ArrayList<Aluno>();
            for (int j = 0; j < (N); j++) {
                String nome = "", cor = "", tamanho = "";
                nome = readLine();
                cor = readString();
                tamanho = readString();
                alunos.add(new Aluno(nome, cor, tamanho));
            }
            Collections.sort(alunos, new Comparator<Aluno>() {
                @Override
                public int compare(Aluno aluno1, Aluno aluno2) {
                    if (!aluno1.getCor().equals(aluno2.getCor())) {
                        return aluno1.getCor().compareTo(aluno2.getCor());
                    } else if (!aluno1.getTamanho().equals(aluno2.getTamanho())) {
                        return aluno2.getTamanho().compareTo(aluno1.getTamanho());
                    } else {
                        return aluno1.getNome().compareTo(aluno2.getNome());
                    }
                }
            });
            for (Aluno a : alunos) {
                System.out.println(a.getCor() + " " + a.getTamanho() + " " + a.getNome());
            }
            System.out.println();
            N = readInt();
        }
    }
}
