package br.sys.Bean;

/**
 *
 * @author Alberto
 */
public class Login {
    private String login;
    private String senha;
    private String verificador;
    private int id_usuario_login;
    
    public Login(){
        
    }
    
    public Login(String login, String senha, String verificador, int id_usuario_login) {
        this.login = login;
        this.senha = senha;
        this.verificador = verificador;
        this.id_usuario_login = id_usuario_login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }

    public int getId_usuario_login() {
        return id_usuario_login;
    }

    public void setId_usuario_login(int id_usuario_login) {
        this.id_usuario_login = id_usuario_login;
    }
}
