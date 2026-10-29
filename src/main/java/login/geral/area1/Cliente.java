package login.geral.area1;

import java.util.ArrayList;

public class Cliente implements login.geral.area1.Usuario {
    private String nome;
    private String email;
    private String senha;

    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public Cliente(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public static boolean temCliente() {
        return !listaClientes.isEmpty();
    }

    public static boolean fazerLogin(String nome, String senha) {
        for (Cliente cliente : listaClientes) {
            if (cliente.autenticar(nome, senha)) {
                return true;
            }
        }
        return false;
    }

    public static void listarClientes() {
        System.out.println("\n--- Clientes ---");

        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println("Nome: " + cliente.nome + " | E-mail: " + cliente.email);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void cadastro() {
        listaClientes.add(this);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    @Override
    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}
