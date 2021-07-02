import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Resolução do Desafio 1068 - URI (Balanço de Parênteses I / Parenthesis Balance I)
// Link: https://www.urionlinejudge.com.br/judge/pt/problems/view/1068
// Acesso: 02/07/2021
// Créditos Desafio: Neilor Tonin, URI 
// Créditos Código: José Rafael R. Nascimento



class Main {

  public static void main(String[] args) throws IOException {

	//	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
	InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader in = new BufferedReader(ir);        


	//	DECLARAÇÃO E ATRIBUIÇÃO DAS VARIAVEIS PRINCIPAIS
	int contador = 1;
	String formula;
	ArrayList<String> resultados = new ArrayList<>();


	// LOOP PARA VALIDAR TODAS AS LINHAS DO ARQUIVO E RESTRIÇÕES
	while (in.ready()) {

		if (contador >= 1 && contador <= 10000){
			formula = in.readLine();
			resultados.add(getValidacao(formula));	
			contador++;
		}
		else
			break;

	}


	if (resultados.size() > 0) {

		//	IMPRIMI RESULTADO
		for (String resultado: resultados)
			System.out.println(resultado);

	}

  }


  // METODO QUE OBTEM A RESPOSTA
  private static String getValidacao(String formula){

	int qtdParentesesAbertos, qtdParentesesFechados, contador;
	qtdParentesesAbertos = qtdParentesesFechados = contador = 0;


	//	FAZ LOOP PARA PERCORRER TODOS OS CARACTERES DA STRING
	while (qtdParentesesAbertos >= qtdParentesesFechados && contador < formula.length()){
		  
		// AO ENCONTRAR PARENTESES, COMEÇA A CONTAR
		if (formula.charAt(contador) == '(' )
			qtdParentesesAbertos++;
		
		if (formula.charAt(contador) == ')' )
			qtdParentesesFechados++;		

		contador++;

	}

	

	// VALIDA SE SÃO IGUAIS E RETORNA
	if (qtdParentesesAbertos == qtdParentesesFechados)
		return "correct";
	else
		return "incorrect";

  }


}