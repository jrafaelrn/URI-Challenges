import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// Resolução do Desafio 3060 - URI (Parcelamento Sem Juros)
// Link: https://www.urionlinejudge.com.br/judge/pt/problems/view/3060
// Acesso: 02/07/2021
// Créditos Desafio: !!Não informado no URI!! :/
// Créditos Código: José Rafael R. Nascimento


public class Main {
 
    public static void main(String[] args) throws IOException {
 
    	//	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
    	InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);        
    
    	//	DECLARAÇÃO E ATRIBUIÇÃO DAS VARIAVEIS PRINCIPAIS
        int valorCompra, numeroParcelas;
           
        valorCompra = Integer.parseInt(in.readLine());
        numeroParcelas = Integer.parseInt(in.readLine());
    
    
    	//	VALIDA AS RESTRIÇÕES    
    	if (valorCompra <= 1000 && valorCompra >= 10 && numeroParcelas <= 18 && numeroParcelas >= 2){
    
    		//	OBTEM A LISTA DE PARCELAMENTO 
    		ArrayList<Integer> parcelamento = getParcelas(valorCompra, numeroParcelas);
    
    		//	IMPRESSÃO
    		for (int parcela : parcelamento){
    			System.out.println(parcela);
    		}
    
    	}	
	
    }
    
    
    public static ArrayList<Integer> getParcelas(int valor, int numParcelas){

	//	ATRIBUIÇÃO DEA VARIAVEL PARA ARMAZENAR O VALOR DAS PARCELAS
	ArrayList<Integer> parcelas = new ArrayList<>();


	//	VALIDA SE A DIVISÃO PODE SER FEITA IGUALMENTE
	if (valor%numParcelas == 0){
		
		int valorParcelas = valor/numParcelas;

		//	CARREGA O ARRAYLIST COM AS PARCELAS IGUAIS
		for(int i = 0; i < numParcelas; i++){
			parcelas.add(valorParcelas);
		}

	}
	//	CALCULA DIVISAO "DESIGUAL"
	else{
		
		int valorBaseParcelas = (int) valor/numParcelas;
		int incrementoParcelas = valor - (valorBaseParcelas * numParcelas);

		//	CARREGA O ARRAYLIST COM AS PARCELAS DESIGUAIS
		for (int i = 1; i <= numParcelas; i++){

			//	VALIDA O INCREMENTO DAS PRIMEIRAS PARCELAS
			if (i <= incrementoParcelas)
				parcelas.add(valorBaseParcelas + 1);
			else
				parcelas.add(valorBaseParcelas);

		}

	}

	return parcelas;

  }
    
 
}