package Estoque.compras;
import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {
    Scanner input = new Scanner(System.in);
    class Produto {
        String nome;
        int quantidade;
        public Produto(String nome, int quantidade) {
            this.nome = nome;
            this.quantidade = quantidade;
        }
        public String toString() {
            return "Lista de produto "+nome+" | Quantidade: "+quantidade;
        }
    }
    public void Estoque(boolean autenticarAdm){
        if (autenticarAdm) {
            ArrayList<Produto> ListaCompras = new ArrayList<>();
            String continuar= "Sim";
            System.out.println("Cadastramento de produto e as suas unidades: ");
            while(continuar.equalsIgnoreCase("Sim")){
                int cont= 0;
                while(cont<5){
                    System.out.println("Digite um produto: ");
                    String nomeProduto = input.nextLine();
                    System.out.println("Digite a quantidade de produtos: ");
                    int quantidadeProduto = input.nextInt();
                    input.nextLine();
                    ListaCompras.add(new Produto(nomeProduto, quantidadeProduto));
                    cont++;
                }
                System.out.println("Desejar cadadrastar mais algum item? (Sim ou Não)");
                continuar= input.nextLine();
            }
            System.out.println(ListaCompras);
            System.out.println("Fim do cadastro de produtos...");
        }
        input.close();
    }
}
