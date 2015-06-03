package br.sys.Bean;

import br.sys.DAO.UsuarioDAO;

public class Funcionario extends Usuario{
	
	private int id_funcionario;
        private String Funcao;
        private float salario;

    public Funcionario(int id_funcionario, String Funcao, String nome, String cpf, String telFixo, String rg, String dataNasc, String localNasc, String sexo, String mae, String pai, String endereco, int numero, String bairro, String cidade, String cep, String estado, String telCelular, float salario, String foto, int verificador) {
        super(nome, cpf, telFixo, rg, dataNasc, localNasc, sexo, mae, pai, endereco, numero, bairro, cidade, cep, estado, telCelular, foto, verificador);
        this.id_funcionario = id_funcionario;
        this.Funcao = Funcao;
        this.salario = salario;
    }

    public Funcionario() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       public String getFuncao() {
            return Funcao;
        }

        public void setFuncao(String Funcao) {
            this.Funcao = Funcao;
        }

  
        public int getId_funcionario() {
            return id_funcionario;
        }

        public void setId_Funcionario(int id_funcionario) {
            this.id_funcionario = id_funcionario;
        }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
	
	
}
