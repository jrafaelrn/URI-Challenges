import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;

// Resolução do Desafio 2065 - URI (Fila do Supermercado / Supermarket Line)
// Link: https://www.urionlinejudge.com.br/judge/en/problems/view/2065
// Acesso: 02/07/2021
// Créditos Desafio: Cristhian Bonilha, UTFPR
// Créditos Código: José Rafael R. Nascimento


class Main {  

    public static void main(String[] args) throws IOException {

        //	DECLARAÇÃO CONFORME ORIENTAÇÃO DO URI
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);      
        
        in.readLine();
        
        // Captura os funcionarios
        Caixas filaCaixas = new Caixas(in.readLine().split(" "));

        // Captura os clientes
        Clientes filaClientes = new Clientes(in.readLine().split(" "));

        
        //Calcula e imprime o resultado
        int resultado = calcula(filaClientes,filaCaixas);
        System.out.println(resultado);

        //EOF
        in.close();

    }



    // METODO QUE OBTEM A RESPOSTA
    public static int calcula(Clientes clientes, Caixas caixas){

        int tempoTotal = 0;

        while(clientes.nClientesFila > 0){

            int caixaDisponivel = caixas.getCaixaDisponivel();
            
            //  Se tiver um caixa disponivel...
            if (caixaDisponivel != -1){
                int qtdItens = Integer.parseInt(clientes.getProximoClienteFila());
                caixas.irParaCaixa(qtdItens, caixaDisponivel);
            }
            else{
                tempoTotal += caixas.atender();  
                caixas.tempoMinimoAtual = caixas.novoTempoMinino;        
            }

        }
        
        tempoTotal += caixas.atender();  
        tempoTotal += caixas.fecharCaixas();

        return tempoTotal;
    }



}

class Clientes{

    String[] clientes;
    int nClientesFila, primeiroFila;

    public Clientes(String[] clientes){
        this.clientes = clientes;
        nClientesFila = this.clientes.length;
        primeiroFila = 0;
    }


    public String getProximoClienteFila(){

        if (nClientesFila == 0) return "";

        String primeiro = clientes[primeiroFila];
        nClientesFila--;

        if (nClientesFila >= 1) primeiroFila++;
        
        return primeiro;
    }

}





class Caixas{

    String[] funcionarios;
    boolean[] caixasDisponiveis;
    int[] temposAtendimento;
    int tempoMinimoAtual, novoTempoMinino;


    public Caixas(String[] func){
        funcionarios = func;
        caixasDisponiveis = new boolean[func.length];
        temposAtendimento = new int[func.length];
        habilitaCaixas();
    }

    
    public int getCaixaDisponivel(){

        for(int i = 0; i < caixasDisponiveis.length; i++){
            if (caixasDisponiveis[i])
                return i;
        }

        return -1;

    }


    public void habilitaCaixas(){
        for(int i = 0; i < caixasDisponiveis.length; i++)
            caixasDisponiveis[i] = true;
    }


    public boolean isCaixaDisponivel(int caixa){
        return caixasDisponiveis[caixa];
    }


    public void irParaCaixa(int qtdItens, int numCaixa){


        caixasDisponiveis[numCaixa] = false;
        int tempoAtendimento = Integer.parseInt(funcionarios[numCaixa]);

        temposAtendimento[numCaixa] = tempoAtendimento * qtdItens;

       if (temposAtendimento[numCaixa] <= tempoMinimoAtual || tempoMinimoAtual == 0)
            tempoMinimoAtual = temposAtendimento[numCaixa];

    }


    public int atender(){

        novoTempoMinino = temposAtendimento[0];

        //System.out.println("\n\n... Iniciando atendimento...");

        for(int i = 0; i < caixasDisponiveis.length; i++){

            //System.out.print("\nCaixa ( " + i + " ) \tAntes: " + temposAtendimento[i]);
            temposAtendimento[i] -= tempoMinimoAtual;
            //System.out.print(" >> Depois: " + temposAtendimento[i]);
            
            if (temposAtendimento[i] < novoTempoMinino && temposAtendimento[i] > 0){
                novoTempoMinino = temposAtendimento[i];
                //System.out.println("\n... novo tempo minino para o proximo atendimento: " + novoTempoMinino);
            }

            if (temposAtendimento[i] == 0)
                caixasDisponiveis[i] = true;

        }

        //System.out.print("\nTempo Minimo gasto para liberar ao menos 1 caixa: " + tempoMinimoAtual);
        return tempoMinimoAtual;
    }


    public int fecharCaixas(){

        int maior = 0;

        for(int i = 0; i < temposAtendimento.length; i++)
            if (temposAtendimento[i] > maior)
                maior = temposAtendimento[i];

        
        return maior;

    }

}