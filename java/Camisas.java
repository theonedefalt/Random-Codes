import java.io.IOException;

class Aluno{
    private String nome;
    private String cor;
    private String tamanho;

    public Aluno(){
        this.nome = "";
        this.cor = "";
        this.tamanho = "";
    }

    public Aluno(String nome, String cor, String tamanho){
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

    public static void swap(Aluno[] alunos, int i, int j){
        Aluno tmp = alunos[i];
        alunos[i] = alunos[j];
        alunos[j] = tmp;
    }
    public static void selecao(Aluno[] alunos, int n){
        for (int i = 0; i < (n-1); i++) {
            int menor = i;
            for (int j = (i+1); j < n; j++) {
                if ((alunos[j].getCor().compareTo(alunos[menor].getCor()) < 0 || (alunos[j].getCor().compareTo(alunos[menor].getCor()) == 0
                && alunos[j].getTamanho().compareTo(alunos[menor].getTamanho()) > 0) || (alunos[j].getTamanho().compareTo(alunos[menor].getTamanho()) == 0 
                && alunos[j].getNome().compareTo(alunos[menor].getNome()) < 0))) {
                    menor = j;
                }
            }
            swap(alunos, i, menor);
        }
    }
    public static void main(String[] args) throws IOException{
        int N = MyIO.readInt();
        while (N != 0 && N <= 60) {
            Aluno[] alunos = new Aluno[N];
            for (int j = 0; j < (N); j++) {
                String nome = "", cor = "", tamanho = "";
                nome = MyIO.readLine();
                cor = MyIO.readString();
                tamanho = MyIO.readString();
                alunos[j] = new Aluno(nome, cor, tamanho);
            }
            selecao(alunos, N);
            for (int i = 0; i < N; i++) {
                System.out.println(alunos[i].getCor() + " " + alunos[i].getTamanho() + " " + alunos[i].getNome());
            }
            System.out.println();
            N = MyIO.readInt();
        }
    }
}