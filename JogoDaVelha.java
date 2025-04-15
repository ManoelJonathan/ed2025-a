
import java.util.Scanner;

public class JogoDaVelha {

    Scanner scannner = new Scanner(System.in);

    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int tabuleiro[][];
    protected int jogador;
    public int tamanho;

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int valor (int i , int j){
       return tabuleiro[i][j];
    }

    public JogoDaVelha() {
        System.out.println("Informe o tamanho do tabuleiro");
        this.setTamanho(scannner.nextInt());
        this.tabuleiro = new int [tamanho][tamanho];
        limpaTabuleiro();
    }

    public void limpaTabuleiro() {
        for(int i = 0; i< tamanho;i++) {
            for (int j=0; j<tamanho; j++) {
                tabuleiro[i][j]=VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i<0||i>tamanho||j<0||j>tamanho){
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j]!=VAZIO) throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j]=jogador;
        jogador = -jogador;
    }

    public boolean eVencedor(int marca) {
        for (int i = 0; i < tamanho; i++) {
            int sLinha = 0;
            int sColuna = 0;
            for (int j = 0; j < tamanho; j++) {
                sLinha += tabuleiro[i][j];
                sColuna += tabuleiro[j][i];
            }
            if (sLinha == marca * tamanho || sColuna == marca * tamanho) {
                return true;
            }
        }

        int sDiagonalP = 0;
        int sDiagonalS = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (i == j) {
                    sDiagonalP += tabuleiro[i][j];
                }
                if (i + j == 2) {
                    sDiagonalS += tabuleiro[i][j];
                }
            }
        }

        if (sDiagonalP == marca * tamanho || sDiagonalS == marca * tamanho) {
            return true;
        }

        return false;
    }



    public int vencedor() {
        if (eVencedor(X)){
            return 1;
        }else if (eVencedor(O)){
            return -1;
        }else{
            return 0;
        }
    }

    
    public String toString() {
        /** Implementar o método to String que deve retornar
         * uma string com o tabuleiro do jogo da velha com as peças
         * nas posições corretas.
         */
        String retorno = "";
        for (int i=0; i<tamanho;i++){
            for (int j=0; j<tamanho; j++){
                if(tabuleiro[i][j]==X) {
                    retorno += ("X");
                } else if (tabuleiro[i][j]==O) {
                    retorno += ("O");
                } else {
                    retorno += (" ");
                }
                if (j < tamanho - 1){
                    retorno += ("|");
                }
            }
            //System.out.println();
            if (i< tamanho - 1){
                retorno += ("\n");
                retorno += ("-".repeat(tamanho * 2 -1));
                retorno += ("\n");
            }

        }   
        return retorno;
    }
}