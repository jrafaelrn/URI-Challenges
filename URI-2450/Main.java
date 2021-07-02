import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Resolução do Desafio 2450 - URI (Matriz Escada / Matrix Ladder)
// Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2450
// Acesso: 02/07/2021
// Por: OBI - Olimpíada Brasileira de Informática 2014
// Créditos Código: José Rafael R. Nascimento


class Main {  

    public static void main(String[] args) throws IOException {

        //	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
        InputStreamReader ir = new InputStreamReader(System.in);    
        BufferedReader in = new BufferedReader(ir);      

        // Tamanho da Matriz
        String[] tamanho = in.readLine().split(" ");
        int linhas = Integer.parseInt(tamanho[0]);
        int colunas = Integer.parseInt(tamanho[1]);
        
        
        // Preenche a Matriz
        int[][] matriz = new int[linhas][colunas];
        for(int i = 0; i < linhas; i++){
            
            String[] numeros = in.readLine().split(" ");
            
            for (int j = 0; j < colunas; j++)
                matriz[i][j] = Integer.parseInt(numeros[j]);

        }
            
        //Obtem e imprime o resultado
        String resultado = ehEscada(matriz);       
        System.out.println(resultado);


        //EOF
        in.close();

    }


    static int[] inicioDegrau;

    // METODO QUE OBTEM A RESPOSTA 
    public static String ehEscada (int[][] matriz) {                   

        inicioDegrau = new int[matriz.length];

        // Preenche o inicio de cada linha
        for (int linha = 0; linha < matriz.length; linha++)          
            inicioDegrau[linha] = posicaoPrimeiroLinha(matriz[linha]);
        
        return valida(inicioDegrau, matriz);

    }


    // Metodo que retorna a poiscao do primeiro elemento na lista diferente de zero
    public static int posicaoPrimeiroLinha(int[] linha){

        for (int i = 0; i < linha.length; i++){
            if (linha[i] != 0)
                return i;
        }

        return 0;

    }


    // Metodo geral para validar as regras do desafio
    public static String valida(int[] inicios, int[][] matriz){

        // Para cada linha...
        for (int i = 0; i < inicios.length; i++){

            int inicioAtual = inicios[i];
            //System.out.println("Avaliando inicio atual da linha " + i + " = " + inicioAtual);              

            //Percorre as colunas abaixo
            for (int j = i+1; j < matriz.length; j++){
                
                int numAbaixo = matriz[j][inicioAtual];
                if (numAbaixo != 0) return "N";               

            }

            // Percorre a esquerda
            for (int k = inicioAtual-1; k >= 0; k--){

                int numEsquerda = matriz[i][k];
                if (numEsquerda != 0) return "N";

            }

        }


        // Valida linhas zeradas
        int soma = 0;

        for (int i = 0; i < matriz.length; i++){

            soma = somaLinha(matriz[i]);

            if (soma == 0 && i < matriz.length-1){

                int somaAbaixo = somaLinha(matriz[i+1]);
                if (somaAbaixo != 0) return "N";

            }

        }

        return "S";

    }

    
    // Metodo que recebe uma linha e devolve a soma total dos itens
    public static int somaLinha(int[] linha){

        int total = 0;

        for (int x : linha)
            total += x;

        return total;

    }



}


