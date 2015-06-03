package br.sys.Bean;
/**
 *
 * @author Alberto
 */


public class Usuario
{
   private String nome;
   private String cpf;
   private String rg;
   private String dataNasc;
   private String localNasc;
   private String sexo;
   private String mae;
   private String pai;
   private String endereco;
   private int numero;
   private String bairro;
   private String cidade;
   private String cep;
   private String estado;
   private String telCelular;
   private String telFixo;
   private String foto;
   int verificador;

    public Usuario(String nome, String cpf,String telFixo, String rg, String dataNasc, String localNasc, String sexo, String mae, String pai, String endereco, int numero, String bairro, String cidade, String cep, String estado, String telCelular, String foto, int verificador) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.localNasc = localNasc;
        this.sexo = sexo;
        this.mae = mae;
        this.pai = pai;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.telCelular = telCelular;
        this.telFixo = telFixo;
        this.foto = foto;
        this.verificador = verificador;
    }
  
        
   
    

    public Usuario(){
    
    }

    
   public String getNome()
   {
       return nome;
   }
   
   public void setNome(String nome)
   {
      this.nome = nome;
   }
    
   public String getEndereco()
   {
       return endereco;
   }
   
   public void setEndereco(String endereco)
   {
      this.endereco = endereco;
   }
    
   public String getCidade()
   {
       return cidade;
   }
   
   public void setCidade(String cidade)
   {
      this.cidade = cidade;
   }
  
   public String getEstado()
   {
       return estado;
   }
   
   public void setEstado(String estado)
   {
      this.estado = estado;
   }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getLocalNasc() {
        return localNasc;
    }

    public void setLocalNasc(String localNasc) {
        this.localNasc = localNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getVerificador() {
        return verificador;
    }

    public void setVerificador(int verificador) {
        this.verificador = verificador;
    }
}
