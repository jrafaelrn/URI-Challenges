import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Resolução do Desafio 2674 - URI (Super Primos: Ativar! / Super Primes: Engage!)
// Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2674
// Acesso: 02/07/2021
// Créditos Desafio: Hamilton José Brumatto, UESC
// Créditos Código: José Rafael R. Nascimento


class Main {  

    public static void main(String[] args) throws IOException {

        //	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
        InputStreamReader ir = new InputStreamReader(System.in);   
        BufferedReader in = new BufferedReader(ir);      
        
        while (in.ready()){
        
            // Captura os numeros da linha
            String linha = in.readLine();
            String[] numerosString = linha.split(" ");
            ArrayList<Integer> numerosCompletos = new ArrayList<>();


            // Converte o array de entrada para Array INT
            for(int i = 0; i < numerosString.length; i++)
                if(numerosString[i] != "")
                    numerosCompletos.add(Integer.parseInt(numerosString[i]));


            // Para cada numero no Array de Numeros Completos
            for(int i = 0; i < numerosCompletos.size(); i++){
                
                String[] numerosIndividuais_String = numerosCompletos.get(i).toString().split("");
                ArrayList<Integer> numerosIndividuais = new ArrayList<>();;

                // Quebra os numeros individualmente
                for(int j = 0; j < numerosIndividuais_String.length; j++)
                    if (!numerosIndividuais_String[j].equals(""))   
                        numerosIndividuais.add(Integer.parseInt(numerosIndividuais_String[j]));

                            
                //Calcula e imprime o resultado
                boolean resultadoNumeroCompleto = ehPrimo(numerosCompletos.get(i));
                boolean resultadoTodosNumeros = saoPrimos(numerosIndividuais);

                if (resultadoNumeroCompleto && resultadoTodosNumeros)
                    System.out.println("Super");
                else 
                    if (resultadoNumeroCompleto)
                        System.out.println("Primo");
                    else
                        System.out.println("Nada");

            }

        }

        //EOF
        in.close();

    }