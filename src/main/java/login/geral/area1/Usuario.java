package login.geral.area1;

public interface Usuario {
    void cadastro();

    boolean autenticar(String nome, String senha);

    static void listarUsuarios() {
        Adm.listarAdms();
        Cliente.listarClientes();
    }
}
