import login.geral.area1.Adm;
import login.geral.area1.Cliente;
import login.geral.area1.Usuario;
import Estoque.compras.Estoque;

import java.util.Scanner;

class SenhaInvalidaException extends Exception {
    public SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }
}

public class MenuDeLogin {

    private static void validarSenha(String senha) throws SenhaInvalidaException {
        if (senha.length() < 4 || senha.length() > 8) {
            throw new SenhaInvalidaException("A senha deve ter entre 4 e 8 caracteres.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n-------- Seja bem-vindo! --------");
            System.out.println("1. Cadastrar administrador");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Fazer login");
            System.out.println("4. Listar administradores e clientes");
            System.out.println("5. Sair do sistema");
            System.out.print("Escolha uma opcao: ");

            String opcao = input.nextLine();

            switch (opcao) {
                case "1" -> {
                    System.out.println("\n--- Cadastro de administrador ---");
                    System.out.print("Digite seu nome de usuario: ");
                    String nome = input.nextLine();
                    System.out.print("Digite seu e-mail: ");
                    String email = input.nextLine();

                    String senha = "";
                    boolean senhaValida = false;

                    while (!senhaValida) {
                        System.out.print("Digite sua senha (minimo 4, maximo 8): ");
                        senha = input.nextLine();

                        try {
                            validarSenha(senha);
                            senhaValida = true;
                        } catch (SenhaInvalidaException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Adm adm = new Adm(nome, senha, email);
                    adm.cadastro();
                }

                case "2" -> {
                    System.out.println("\n--- Cadastro de cliente ---");
                    System.out.print("Digite seu nome de usuario: ");
                    String nome = input.nextLine();
                    System.out.print("Digite seu e-mail: ");
                    String email = input.nextLine();

                    String senha = "";
                    boolean senhaValida = false;

                    while (!senhaValida) {
                        System.out.print("Digite sua senha (minimo 4, maximo 8): ");
                        senha = input.nextLine();

                        try {
                            validarSenha(senha);
                            senhaValida = true;
                        } catch (SenhaInvalidaException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    Cliente cliente = new Cliente(nome, senha, email);
                    cliente.cadastro();
                }

                case "3" -> {
                    if (!Adm.temAdm() && !Cliente.temCliente()) {
                        System.out.println("Nao ha usuarios cadastrados.");
                    } else {
                        System.out.println("\n--- Login ---");
                        System.out.print("Nome de usuario: ");
                        String nome = input.nextLine();
                        System.out.print("Senha: ");
                        String senha = input.nextLine();

                        if (Adm.temAdm() && Adm.fazerLogin(nome, senha)) {
                            System.out.println("Login de administrador efetuado com sucesso!");
                            Estoque estoque= new  Estoque(input);
                            estoque.gerenciarEstoque(true);
                        } else if (Cliente.temCliente() && Cliente.fazerLogin(nome, senha)) {
                            System.out.println("Login de cliente efetuado com sucesso!");
                        } else {
                            System.out.println("Usuario ou senha incorretos.");
                        }
                    }
                }

                case "4" -> Usuario.listarUsuarios();

                case "5" -> {
                    System.out.println("Saindo do sistema. Ate logo!");
                    rodando = false;
                }

                default -> System.out.println("Opcao invalida. Digite um numero de 1 a 5.");
            }
        }

        input.close();
    }
}
