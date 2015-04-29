package Bean;

abstract class Usuario  {
        private String nome;
	private String CPF;
	private float mensalidade;
	private String telefone;
        private Endereco endereco;
	
       public Usuario(){
          endereco = new Endereco();
       }
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public float getMensalidade() {
		return mensalidade;
	}


	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}


	public String getTelefone() {
            return telefone;
	}


	public void setTelefone(String telefone) {
            this.telefone = telefone;
	}
        
        public Endereco getEndereco() {
             return endereco;
        }

        public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
        }

        public void setRua(String rua){
            endereco.setRua(rua);
        }

        public void setNumero(String numero){
            endereco.setNum(numero);
        }

        public void setBairro(String bairro){
            endereco.setBairro(bairro);
        }

        public void setCep(String cep){
            endereco.setCep(cep);
        }

        public void setCidade(String cidade){
            endereco.setCidade(cidade);
        }

        public void setEstado(String estado){
            endereco.setEstado(estado);
        }
}