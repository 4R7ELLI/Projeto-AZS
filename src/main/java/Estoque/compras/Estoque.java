package Estoque.compras;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    private ArrayList<Produto> ListaCompras = new ArrayList<>();
    private final Scanner input;
    public Estoque(Scanner input) { this.input = input; }
    class Produto {
        String nome;
        int quantidade;
        public Produto(String nome, int quantidade) {
            this.nome = nome;
            this.quantidade = quantidade;
        }
        @Override
        public String toString() {
            return nome+ " "+quantidade;
        }
    }
    public void gerenciarEstoque(boolean autenticarAdm){
        if (autenticarAdm) {
            String continuar= "Sim";
            System.out.println("Cadastramento de produto e as suas unidades: ");
            while(continuar.equalsIgnoreCase("Sim")){
                for(int i=0; i<5; i++){
                    System.out.println("Digite um produto: ");
                    String nomeProduto = input.nextLine();
                    System.out.println("Digite a quantidade de produtos: ");
                    int quantidadeProduto;
                    try {
                        quantidadeProduto = Integer.parseInt(input.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade invalida. Tente novamente.");
                        i--;
                        continue;
                    }
                    ListaCompras.add(new Produto(nomeProduto, quantidadeProduto));
                }
                System.out.println("Desejar cadadrastar mais algum item? (Sim ou Não)");
                continuar= input.nextLine();
            }
            System.out.println("\n--- Lista de Produtos Cadastrados ---");
            for (Produto item : ListaCompras) {
                System.out.println(item);
            }
            System.out.println("-------------------------------------");
            System.out.println("Fim do cadastro de produtos... Voltando ao menu inicial.\n");
        }
    }
}
