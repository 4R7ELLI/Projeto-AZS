public class Login {
    private String opcao;
    private String nomeCadastrado;
    private String senhaCadastrada;
    String login= "falso";
    public void cadastrarAdm(String nome, String senha){
        this.nomeCadastrado = nome;
        this.senhaCadastrada = senha;
        System.out.println("Cadastro de adm com sucesso!");
    }
    public boolean autenticarAdmin(String nomeDigitado, String senhaDigitada) {
        if (nomeDigitado.equals(this.nomeCadastrado) && senhaDigitada.equals(this.senhaCadastrada)) {
            System.out.println("Login efetuado com sucesso!");
            login = nomeDigitado;
            return true;
        } else {
            System.out.println("Usuário ou senha incorretos!");
            return false;
        }
    }
}
