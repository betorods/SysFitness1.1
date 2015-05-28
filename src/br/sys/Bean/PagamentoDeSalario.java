package br.sys.Bean;
/**
 *
 * @author Alberto
 */
public class PagamentoDeSalario {
   private String matriculaFuncionario;
   private float valor;
   private String meses;
   private String dataDoPagamento; 
   
   
    public PagamentoDeSalario(float valor, String meses, String dataDoPagamento, String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
        this.valor = valor;
        this.meses = meses;
        this.dataDoPagamento = dataDoPagamento;
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
}
