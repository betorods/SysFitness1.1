package br.sys.Bean;
/**
 *
 * @author Alberto
 */
public class Mensalidade {
    private int mat_alunos;
    private int mat_funcionario;
    private String cpf;
    private String Nome;
    private float valor;
    private String data_vencimento;
    private String data_pagamento;

    public Mensalidade(int mat_alunos, int mat_funcionario,String cpf, float valor, String data_vencimento, String data_pagamento,String Nome) {
        this.mat_alunos = mat_alunos;
        this.cpf = cpf;
        this.valor = valor;
        this.data_vencimento = data_vencimento;
        this.data_pagamento = data_pagamento;
        this.Nome = Nome;
        this.mat_funcionario = mat_funcionario;
    }
    
    
    public Mensalidade(){
        
    }

    public int getMat_alunos() {
        return mat_alunos;
    }

    public void setMat_alunos(int mat_alunos) {
        this.mat_alunos = mat_alunos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getMat_funcionario() {
        return mat_funcionario;
    }

    public void setMat_funcionario(int mat_funcionario) {
        this.mat_funcionario = mat_funcionario;
    }
   
}
