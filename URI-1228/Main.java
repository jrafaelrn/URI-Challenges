import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Resolução do Desafio 1228 - URI (Grid de Largada / Start Grid)
// Link: https://www.urionlinejudge.com.br/judge/pt/problems/view/1228
// Acesso: 02/07/2021
// Créditos Desafio: Maratona de Programação da SBC 
// Créditos Código: José Rafael R. Nascimento


class Main {    
    
    //	DECLARAÇÃO E ATRIBUIÇÃO DAS VARIAVEIS PRINCIPAIS
    static int[] largadas, chegadas;
    static int numeroCompetidores, totalUltrapassagens;
    static String ordemLargada, ordemChegada;
    static ArrayList<Integer> resultados = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {

        //	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);        


        // LOOP PARA VALIDAR TODAS AS LINHAS DO ARQUIVO E RESTRIÇÕES
        while (in.ready()) {

            numeroCompetidores = Integer.parseInt(in.readLine());

            if (numeroCompetidores <= 24 && numeroCompetidores >= 2){
                
                ordemLargada = in.readLine();
                ordemChegada = in.readLine();
                largadas = new int[numeroCompetidores];
                chegadas = new int[numeroCompetidores];

                resultados.add(getUltrapassagens(ordemLargada, ordemChegada));

            }
            else{
                in.readLine();
                in.readLine();
            }

        }


        for(int resultado : resultados)
            System.out.println(resultado);

        //EOF
        in.close();

    }



    // METODO QUE OBTEM A RESPOSTA
    public static int getUltrapassagens(String ordemLargadaCompleta, String ordemChegadaCompleta){

        totalUltrapassagens = 0;
        int competidorChegou;
        String[] ordemLargadaOrganizada = ordemLargadaCompleta.split(" ");
        String[] ordemChegadaOrganizada = ordemChegadaCompleta.split(" ");


        for(int i = 0; i < numeroCompetidores; i++){
            largadas[i] = Integer.parseInt(ordemLargadaOrganizada[i]);
            chegadas[i] = Integer.parseInt(ordemChegadaOrganizada[i]);
        }


        for(int i = 0; i < numeroCompetidores; i++){

            competidorChegou = chegadas[i];
            
            for(int j = i; j < numeroCompetidores ; j++){

                if (largadas[j] == competidorChegou && j != i){
                    int destino = j-1 < 0 ? numeroCompetidores-1 : j-1;

                    trocarPosicoesLargadas(j, destino);
                    j -= 2;
                }
                
            }

           
        }

        return totalUltrapassagens;
    }





    private static void trocarPosicoesLargadas(int x, int y){

        int temp = largadas[x];
        largadas[x] = largadas[y];
        largadas[y] = temp;
        
        totalUltrapassagens++;

    }



}