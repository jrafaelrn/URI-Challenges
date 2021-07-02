import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;

// Resolução do Desafio 2670 - URI (Máquina de Café/Coffee Machine)
// Por: Maratona de Programação da SBC, ACM ICPC 2017
// Link: https://www.urionlinejudge.com.br/judge/pt/problems/view/2670
// Acesso: 02/07/2021


class Main {  

    public static void main(String[] args) throws IOException {

        //	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);      
        

        //Captura a quantidade de pessoas
        int pessoas1 = Integer.parseInt(in.readLine());
        int pessoas2 = Integer.parseInt(in.readLine());
        int pessoas3 = Integer.parseInt(in.readLine());
        int[] pessoas = new int[] {pessoas1, pessoas2, pessoas3};

        int resultado = calculaMelhorAndar(pessoas);    //Chama metodo para obter resultado

        System.out.println(resultado);

        //EOF
        in.close();

    }



    // METODO QUE OBTEM A RESPOSTA
    public static int calculaMelhorAndar (int[] pessoas){
        
        int melhorTempo = 0;
        int tempoParcial = 0;

        // Loop para testar todos os andares
        for(int andar = 0; andar < 3; andar++){

            tempoParcial = 0;
            
            // Para cada andar, faz a conta do tempo gasto na movimentacao das pessoas
            for(int i = 0; i < 3; i++){

                if (!(andar == i))
                    tempoParcial += Math.abs(pessoas[i] * (i - andar));

            }

            // Atualiza sempre a melhor opcao
            if (melhorTempo == 0 || tempoParcial < melhorTempo)
                melhorTempo = tempoParcial;
        
        }

        // Multiplicado para considerar ida/volta
        return melhorTempo * 2;
           
    }



}
