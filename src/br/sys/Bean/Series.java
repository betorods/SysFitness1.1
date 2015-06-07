package br.sys.Bean;
/**
 *
 * @author Alberto
 */
public class Series extends Alunos{

        private int idSerie;
	private String tipo;
	private String exercicio;
	private String data_inicio;
	private String data_termino;

    public Series(int idSerie, String tipo, String exercicio, String data_inicio, String data_termino, int cod_turma, float altura, float peso, float panturrilha, float braco, float perna, float cintura, float coxa, float peitoral, float costas, int Id_Alunos, String nome, String cpf, String telFixo, String rg, String dataNasc, String localNasc, String sexo, String mae, String pai, String endereco, int numero, String bairro, String cidade, String cep, String estado, String telCelular, String foto, int verificador) {
        super(cod_turma, altura, peso, panturrilha, braco, perna, cintura, coxa, peitoral, costas, Id_Alunos, nome, cpf, telFixo, rg, dataNasc, localNasc, sexo, mae, pai, endereco, numero, bairro, cidade, cep, estado, telCelular, foto, verificador);
        this.idSerie = idSerie;
        this.tipo = tipo;
        this.exercicio = exercicio;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
    }

    
    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_termino() {
        return data_termino;
    }

    public void setData_termino(String data_termino) {
        this.data_termino = data_termino;
    }

    
 
}
