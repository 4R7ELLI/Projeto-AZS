import java.util.Scanner;

public class MenuDeLogin {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean rodando = true;
        Login login = new Login();
        int cont=0;
        while(rodando) {
            System.out.println("--------Seja bem-vindo!--------");
            System.out.println("Faça o seu login para acessar o menu principal.");
            System.out.println("e escolha o que deseja fazer hoje.");
            System.out.println("Qual das opções de login desejar fazer?");
            System.out.println("1. Login Adm (para você cadastrar os seus produtos).");
            System.out.println("2. Login Cliente (Realizar a sua comprar).");
            System.out.println("3. Sair do sistema.");
            String opcao = input.nextLine();
            switch (opcao) {
                case "1" ->{
                    System.out.println("Redirecionando para Login Administrativo...");
                    if(cont==0){
                        System.out.println("Menu de inscricao login Adm.");
                        System.out.print(("Digite o seu Nome de usuario: "));
                        String nomeusuario = input.nextLine();
                        System.out.print("Digite o seu Senha(minimo de digito 4, maximo de 8): ");
                        String senha = input.nextLine();
                        while (senha.length() < 4 || senha.length() > 8) {
                            System.out.print("Sua senha não estar nas regras, digite outra: ");
                            senha = input.nextLine();
                        }
                        login.cadastrarAdm(nomeusuario, senha);
                        cont++;
                    } else{
                        System.out.print("Digite o usuário para entrar: ");
                        String nomeLogin = input.nextLine();
                        System.out.print("Digite a senha para entrar: ");
                        String senhaLogin = input.nextLine();
                        login.autenticarAdmin(nomeLogin, senhaLogin);
                    }
                }
                case "2"->{
                    System.out.println("Redirecionando para Login Cliente...");

                }
                case "3"->{
                    System.out.println("Saindo do sistema. Até logo!");
                    rodando = false;
                }
                default -> System.out.println("Opção inválida! Por favor, digite 1, 2 ou 3.");
            }
        }
    input.close();
    }
}
