package br.sys.Bean;

/**
 *
 * @author Alberto
 */
public class Saida {
    private String descricao;
    private float valor;
    private String dataSaida;
    private int id_funcionario;

    public Saida(String descricao, float valor, String dataSaida, int id_funcionario) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataSaida = dataSaida;
        this.id_funcionario = id_funcionario;
    }
    
    
    public Saida(){
        
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

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
  
}
