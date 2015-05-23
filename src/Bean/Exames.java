package Bean;
/**
 *
 * @author Alberto
 */
public class Exames {
     private String nomeMedico;
     private int crm;
     private String dataRealizacaoExame;
     private String dataValidadeExame;
     private String recomendacoes;
     private String objetivo;
     private String cpf;

    public Exames(String nomeMedico, int crm, String dataRealizacaoExame, String dataValidadeExame, String recomendacoes, String objetivo, String cpf) {
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.dataRealizacaoExame = dataRealizacaoExame;
        this.dataValidadeExame = dataValidadeExame;
        this.recomendacoes = recomendacoes;
        this.objetivo = objetivo;
        this.cpf = cpf;
    }
    
    public Exames(){
        
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String NomeMedico) {
        this.nomeMedico = NomeMedico;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getDataRealizacaoExame() {
        return dataRealizacaoExame;
    }

    public void setDataRealizacaoExame(String dataRealizacaoExame) {
        this.dataRealizacaoExame = dataRealizacaoExame;
    }

    public String getDataValidadeExame() {
        return dataValidadeExame;
    }

    public void setDataValidadeExame(String dataValidadeExame) {
        this.dataValidadeExame = dataValidadeExame;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
        
}