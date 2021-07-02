import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// Resolução do Desafio 3059 - URI (Pares de Números / Pairs of Numbers)
// Link: https://www.urionlinejudge.com.br/judge/pt/problems/view/3059
// Acesso: 02/07/2021
// Créditos Desafio: !!Não informado no URI!! :/
// Créditos Código: José Rafael R. Nascimento



class Main {

  public static void main(String[] args) throws IOException {

	//	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
	InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(ir);        


	//	DECLARAÇÃO E ATRIBUIÇÃO DAS VARIAVEIS PRINCIPAIS
	int tamanho, somaMinima, somaMaxima, resultado;
	String[] configuracoes, vetorDados;
	
	configuracoes = in.readLine().split(" ");
	vetorDados = in.readLine().split(" ");
       
    tamanho = Integer.parseInt(configuracoes[0]);
    somaMinima = Integer.parseInt(configuracoes[1]);
	somaMaxima = Integer.parseInt(configuracoes[2]);
	resultado = 0;


	//	VALIDA AS RESTRICOES
	if (tamanho <= 1000 && tamanho >= 2 && somaMinima <= 2000 && somaMinima >= -2000 && somaMaxima <= 2000 && somaMaxima >= -2000){
		resultado = getTotalPares(tamanho, somaMinima, somaMaxima, vetorDados);
	}

	System.out.println(resultado);	

  }


  private static int getTotalPares(int tamanho, int minimo, int maximo, String[] vetorDados){

	  int parcelaA, parcelaB, soma, totalPares;
	  totalPares = 0;

	//	FAZ DOIS LOOP'S ENCADEADOS PARA PERCORRER TODOS AS POSSIBILIDADES
	  for (int i = 0; i < tamanho; i++){

		  parcelaA = Integer.parseInt(vetorDados[i]);

		  for(int j = i+1; j < tamanho; j++){

			  parcelaB = Integer.parseInt(vetorDados[j]);
			  soma = parcelaA + parcelaB;

			// VALIDACAO FINAL PARA INCREMENTO DO RESULTADO
			  if (soma >= minimo && soma <= maximo)
				  totalPares++;

		  }

	  }

	  return totalPares;

  }

}