package login.geral.area1;

import java.util.ArrayList;

public class Adm implements login.geral.area1.Usuario {
    private String nome;
    private String senha;
    private String email;

    private static ArrayList<Adm> listaAdms = new ArrayList<>();

    public Adm(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public static boolean temAdm() {
        return !listaAdms.isEmpty();
    }

    public static boolean fazerLogin(String nome, String senha) {
        for (Adm adm : listaAdms) {
            if (adm.autenticar(nome, senha)) {
                return true;
            }
        }
        return false;
    }

    public static void listarAdms() {
        System.out.println("\n--- Administradores ---");

        if (listaAdms.isEmpty()) {
            System.out.println("Nenhum administrador cadastrado.");
        } else {
            for (Adm adm : listaAdms) {
                System.out.println("Nome: " + adm.nome + " | E-mail: " + adm.email);
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
        listaAdms.add(this);
        System.out.println("Administrador cadastrado com sucesso!");
    }

    @Override
    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}
