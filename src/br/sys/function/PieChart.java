/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sys.function;

import br.sys.Bean.DadosGrafico;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;
    private double saldo;
    private double entrada;
    private double saida;
    DadosGrafico dados = new DadosGrafico();

    public PieChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // Isso irá criar o conjunto de dados
        PieDataset dataset = createDataset();

        // com base no conjunto de dados que criamos o gráfico
        JFreeChart chart = createChart(dataset, chartTitle);

        // vamos colocar o gráfico em um painel
        ChartPanel chartPanel = new ChartPanel(chart);

        // default tamanho
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        // adiciona a nossa aplicação
        setContentPane(chartPanel);

    }

    /**
     * Cria um conjunto de dados de amostra
     */
    public void carregar(DadosGrafico dados){
        
    }
    
    private PieDataset createDataset() {
      //  DadosGrafico dados = new DadosGrafico();
        JOptionPane.showMessageDialog(null, "teste"+dados.getEntrada());
        
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Entrada", dados.getEntrada());
        result.setValue("Saida", dados.getSaida());
        result.setValue("Saldo do Periodo", dados.getSaldo());
        return result;

    }

    /**
     * Cria um gráfico
     */
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(title, // título / gráfico 
                dataset, // dados 
                true, // include lenda
                true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }

  
}
