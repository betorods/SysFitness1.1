package br.sys.Bean;

/**
 *
 * @author Alberto
 */
public class Alunos extends Usuario{
        private float altura;
        private float peso;
        private float panturrilha;
        private float braco;
        private float perna;
        private float cintura;
        private float coxa;
        private float peitoral;
        private float costas;
        private int Id_Alunos;

    public Alunos(float altura, float peso, float panturrilha, float braco, float perna, float cintura, float coxa, float peitoral, float costas, int Id_Alunos, String nome, String cpf, String telFixo, String rg, String dataNasc, String localNasc, String sexo, String mae, String pai, String endereco, int numero, String bairro, String cidade, String cep, String estado, String telCelular, String foto) {
        super(nome, cpf, telFixo, rg, dataNasc, localNasc, sexo, mae, pai, endereco, numero, bairro, cidade, cep, estado, telCelular, foto);
        this.altura = altura;
        this.peso = peso;
        this.panturrilha = panturrilha;
        this.braco = braco;
        this.perna = perna;
        this.cintura = cintura;
        this.coxa = coxa;
        this.peitoral = peitoral;
        this.costas = costas;
        this.Id_Alunos = Id_Alunos;
    }

    public Alunos(float altura, float peso, float panturrilha, float braco, float perna, float cintura, float coxa, float peitoral, float costas, int Id_Alunos) {
        this.altura = altura;
        this.peso = peso;
        this.panturrilha = panturrilha;
        this.braco = braco;
        this.perna = perna;
        this.cintura = cintura;
        this.coxa = coxa;
        this.peitoral = peitoral;
        this.costas = costas;
        this.Id_Alunos = Id_Alunos;
    }

    

    

    public Alunos() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    	public float getAltura() {
		return altura;
	}


	public void setAltura(float altura) {
		this.altura = altura;
	}


	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}


	public float getPanturrilha() {
		return panturrilha;
	}


	public void setPanturrilha(float panturrilha) {
		this.panturrilha = panturrilha;
	}


	public float getBraco() {
		return braco;
	}


	public void setBraco(float braco) {
		this.braco = braco;
	}


	public float getPerna() {
		return perna;
	}


	public void setPerna(float perna) {
		this.perna = perna;
	}


	public float getCintura() {
		return cintura;
	}


	public void setCintura(float cintura) {
		this.cintura = cintura;
	}


	public float getCoxa() {
		return coxa;
	}


	public void setCoxa(float coxa) {
		this.coxa = coxa;
	}


	public float getPeitoral() {
		return peitoral;
	}


	public void setPeitoral(float peitoral) {
		this.peitoral = peitoral;
	}


	public float getCostas() {
		return costas;
	}


	public void setCostas(float costas) {
		this.costas = costas;
	}

    public int getId_Alunos() {
        return Id_Alunos;
    }

    public void setId_Alunos(int Id_Alunos) {
        this.Id_Alunos = Id_Alunos;
    }
}
