package br.sys.Bean;

/**
 *
 * @author Alberto
 */
public class DadosGrafico {

    public DadosGrafico(double saldo, double saida, double entrada) {
        this.saldo = saldo;
        this.saida = saida;
        this.entrada = entrada;
    }
    private double saldo;
    private double saida;
    private double entrada;

    public DadosGrafico() {

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

}
