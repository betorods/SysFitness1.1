package br.sys.Bean;

/**
 *
 * @author Alberto
 */
public class Cargo {

    private String funcao;
    private String descricao;
    private int id_funcionario_cargo;
    private float salario;

    public Cargo() {

    }

    public Cargo(String funcao, String descricao, float salario, int id_funcionario_cargo) {
        this.funcao = funcao;
        this.descricao = descricao;
        this.salario = salario;
        this.id_funcionario_cargo = id_funcionario_cargo;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getId_funcionario_cargo() {
        return id_funcionario_cargo;
    }

    public void setId_funcionario_cargo(int id_funcionario_cargo) {
        this.id_funcionario_cargo = id_funcionario_cargo;
    }

}
