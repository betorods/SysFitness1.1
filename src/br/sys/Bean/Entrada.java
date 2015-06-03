package br.sys.Bean;

/**
 *
 * @author Alberto
 */
public class Entrada{
    private String descricao;
    private float valor;
    private String dataEntrada;
    private int id_funcionario;
     
    public Entrada(String descricao, float valor, String dataEntrada, int id_funcionario) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataEntrada = dataEntrada;
        this.id_funcionario = id_funcionario;
               
        
    }

    public Entrada() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
    
}
