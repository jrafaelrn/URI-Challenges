import java.util.*;
import java.io.*;

// Resolução do Desafio 2690 - URI (Nova Senha RA / New Password RA)
// Link: https://www.urionlinejudge.com.br/judge/pt/problems/view/2690
// Acesso: 02/07/2021
// Créditos Desafio: Samuel Lucas Santos Gomes, IFSULDEMINAS
// Créditos Código: José Rafael R. Nascimento


class Main {

	static int inseridos = 0;

  	public static void main(String[] args) throws Exception {

		ArrayList<String> senhasCriptografadas = new ArrayList<String>();

		//	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);  

		int testes = Integer.parseInt(in.readLine());

		for(int i = 0; i < testes; i++)
			senhasCriptografadas.add(getSenha(in.readLine()));
		
		for(String senha : senhasCriptografadas)
			System.out.println(senha);		

	}


	static String getSenha(String senhaDigitada) {

		StringBuilder novaSenhaCriptografada = new StringBuilder(12);

		int contador = 0;
		inseridos = 0;


		while (true){

			String caracterAntigo = senhaDigitada.substring(contador, contador+1);
			contador++;

			if (caracterAntigo.equals(" "))
				continue;
			
			if (inseridos == 12)
				break;


			String caracterNovo = getCriptografia(caracterAntigo);
			novaSenhaCriptografada.append(caracterNovo);	

			if(contador == senhaDigitada.length())
				break;

		}


		return novaSenhaCriptografada.toString();

	}




	static String getCriptografia (String chaveOriginal){

		inseridos++;

		String chave0 = "[GQaku]";
		String chave1 = "[ISblv]";
		String chave2 = "[EOYcmw]";
		String chave3 = "[FPZdnx]";
		String chave4 = "[JTeoy]";
		String chave5 = "[DNXfpz]";
		String chave6 = "[AKUgq]";
		String chave7 = "[CMWhr]";
		String chave8 = "[BLVis]";
		String chave9 = "[HRjt]";

		//System.out.println("Chave Original: " + chaveOriginal);

		boolean b0 = Pattern.compile(chave0).matcher(chaveOriginal).matches();
		boolean b1 = Pattern.compile(chave1).matcher(chaveOriginal).matches();
		boolean b2 = Pattern.compile(chave2).matcher(chaveOriginal).matches();
		boolean b3 = Pattern.compile(chave3).matcher(chaveOriginal).matches();
		boolean b4 = Pattern.compile(chave4).matcher(chaveOriginal).matches();
		boolean b5 = Pattern.compile(chave5).matcher(chaveOriginal).matches();
		boolean b6 = Pattern.compile(chave6).matcher(chaveOriginal).matches();
		boolean b7 = Pattern.compile(chave7).matcher(chaveOriginal).matches();
		boolean b8 = Pattern.compile(chave8).matcher(chaveOriginal).matches();
		boolean b9 = Pattern.compile(chave9).matcher(chaveOriginal).matches();

		if (b0)
			return "0";

		if (b1)
			return "1";

		if (b2)
			return "2";

		if (b3)
			return "3";

		if (b4)
			return "4";

		if (b5)
			return "5";

		if (b6)
			return "6";

		if (b7)
			return "7";

		if (b8)
			return "8";

		if (b9)
			return "9";

		return "";

	}



}