package br.sys.Bean;
/**
 *
 * @author Alberto
 */
public class PagamentoDeSalario {
   private String matriculaFuncionario;
   private int mat_funcionario_Pag;
   private float valor;
   private String meses;
   private String dataDoPagamento; 
   
   
    public PagamentoDeSalario(float valor, int mat_funcionario_Pag ,String meses, String dataDoPagamento, String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
        this.valor = valor;
        this.meses = meses;
        this.dataDoPagamento = dataDoPagamento;
        this.mat_funcionario_Pag = mat_funcionario_Pag;
    }
    
    public PagamentoDeSalario(){
        
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getMeses() {
        return meses;
    }

    public void setMeses(String meses) {
        this.meses = meses;
    }

    public String getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(String dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }

    public String getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public int getMat_funcionario_Pag() {
        return mat_funcionario_Pag;
    }

    public void setMat_funcionario_Pag(int mat_funcionario_Pag) {
        this.mat_funcionario_Pag = mat_funcionario_Pag;
    }
}
