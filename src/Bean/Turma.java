package Bean;
/**
 *
 * @author Alberto
 */
public class Turma {
    private int CodTurma;
    private int matriculaProfessor;
    private int capacidade;
    private char horario;
    private String turno;
    
    public Turma(){
    }

    public int getCodTurma() {
        return CodTurma;
    }

    public void setCodTurma(int CodTurma) {
        this.CodTurma = CodTurma;
    }

    public int getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(int matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public char getHorario() {
        return horario;
    }

    public void setHorario(char horario) {
        this.horario = horario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
