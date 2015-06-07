package br.sys.Financeiro;

/**
 *
 * @author Alberto
 */
import br.sys.Bean.DadosGrafico;
import javax.swing.JOptionPane;
import br.sys.DAO.ConexaoBD;
import br.sys.function.GerarGrafico;
import br.sys.function.PieChart;
//import br.sys.function.GerarGrafico;
import java.awt.Color;
import static java.awt.Color.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class RelatorioDeEntradaSaida extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
    private static final long serialVersionUID = 1L;

    public RelatorioDeEntradaSaida() throws ClassNotFoundException {
        initComponents();
        conecta = ConexaoBD.conexao();
        Saldo();
    }

    public void Saldo() throws ClassNotFoundException {
        double total = 0;
        try {
            String sql = "SELECT sum(valor) - (SELECT sum(valor) "
                    + "FROM caixa WHERE verificador = 'saida') AS SALDO"
                    + " FROM caixa WHERE verificador = 'entrada';";

            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                total = rs.getDouble("SALDO");
            }
            if (total <= 0) {
                SaldoFinal.setText(Double.toString(total));
                SaldoFinal.setForeground(red);
            } else {
                SaldoFinal.setText(Double.toString(total));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void SaldoPorPeriodo() {
        double aux1 = 0;
        double aux2 = 0;
        double aux3 = 0;
        aux1 = Double.parseDouble(gastoPorPerido.getText());
        aux2 = Double.parseDouble(entradaPorPerido.getText());
        aux3 = aux2 - aux1;
        saldoDoPeriodo.setText(Double.toString(aux3));       
       
    }

    public void GastoPorPeriodo() {
        double total = 0;
        try {
            String sql = "SELECT sum(valor)AS total "
                    + "FROM caixa "
                    + "WHERE data_pagamento >= ? AND data_pagamento <= ? "
                    + "AND verificador = 'saida';";

            pst = conecta.prepareStatement(sql);
            pst.setString(1, PrimeiraData.getText());
            pst.setString(2, SegundaData.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                total = rs.getDouble("total");
            }
            gastoPorPerido.setText(Double.toString(total));
        } catch (SQLException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }

    }

    public void EntradaPorPeriodo() {
        double total = 0;
        try {
            String sql = "SELECT sum(valor)AS total"
                    + " FROM caixa "
                    + " WHERE data_pagamento >= ? AND data_pagamento <= ? AND verificador = 'entrada';";

            pst = conecta.prepareStatement(sql);
            pst.setString(1, PrimeiraData.getText());
            pst.setString(2, SegundaData.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                total = rs.getDouble("total");
            }
            entradaPorPerido.setText(Double.toString(total));
        } catch (SQLException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }

    public void testBox() throws ClassNotFoundException {
        if (matriculaFuncioanrio.isSelected() && entrada.isSelected() && Saida.isSelected()) {
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor,verificador "
                    + "FROM caixa "
                    + "WHERE id_funcionario_caixa = ? AND data_pagamento >= ? "
                    + "AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, matriculaFuncionarioText.getText());
                pst.setString(2, PrimeiraData.getText());
                pst.setString(3, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));
                EntradaPorPeriodo();
                GastoPorPeriodo();
                SaldoPorPeriodo();
                //---Grafico----
                //------------
                
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        } else if (matriculaFuncioanrio.isSelected() && entrada.isSelected()) {
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor,verificador "
                    + "FROM caixa "
                    + "WHERE id_funcionario_caixa = ? AND verificador = ? AND data_pagamento >= ? AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, matriculaFuncionarioText.getText());
                pst.setString(2, entrada.getText());
                pst.setString(3, PrimeiraData.getText());
                pst.setString(4, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));
                gastoPorPerido.setText("");
                saldoDoPeriodo.setText("");
                EntradaPorPeriodo();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        } else if (matriculaFuncioanrio.isSelected() && Saida.isSelected()) {
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor,verificador "
                    + "FROM caixa "
                    + "WHERE id_funcionario_caixa = ? AND verificador = ? AND data_pagamento >= ? AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, matriculaFuncionarioText.getText());
                pst.setString(2, Saida.getText());
                pst.setString(3, PrimeiraData.getText());
                pst.setString(4, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));
                entradaPorPerido.setText("");
                saldoDoPeriodo.setText("");
                GastoPorPeriodo();

            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        } else if (matriculaFuncioanrio.isSelected()) {
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor,verificador "
                    + "FROM caixa "
                    + "WHERE id_funcionario_caixa = ? AND data_pagamento >= ? AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, matriculaFuncionarioText.getText());
                pst.setString(2, PrimeiraData.getText());
                pst.setString(3, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));

                saldoDoPeriodo.setText("");
                gastoPorPerido.setText("");

            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }

        } else if (entrada.isSelected() && Saida.isSelected()) {
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor,verificador "
                    + "FROM caixa "
                    + "WHERE data_pagamento >= ? AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, PrimeiraData.getText());
                pst.setString(2, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));
                EntradaPorPeriodo();
                GastoPorPeriodo();
                SaldoPorPeriodo();

            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        } else if (entrada.isSelected()) {
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor,verificador "
                    + "FROM caixa "
                    + "WHERE verificador = ? AND data_pagamento >= ? AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, entrada.getText());
                pst.setString(2, PrimeiraData.getText());
                pst.setString(3, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));

                gastoPorPerido.setText("");
                saldoDoPeriodo.setText("");
                EntradaPorPeriodo();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        } else if (Saida.isSelected()) {
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor,verificador "
                    + "FROM caixa "
                    + "WHERE verificador = ? AND data_pagamento >= ? AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, Saida.getText());
                pst.setString(2, PrimeiraData.getText());
                pst.setString(3, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));
                entradaPorPerido.setText("");
                saldoDoPeriodo.setText("");
                GastoPorPeriodo();
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Só data OK ");
            String sql = "SELECT id_caixa As Codigo,id_funcionario_caixa As Matricula_Funcionario, data_pagamento,descricao,valor "
                    + "FROM caixa "
                    + "WHERE data_pagamento >= ? AND data_pagamento <= ?;";
            try {
                pst = conecta.prepareStatement(sql);
                pst.setString(1, PrimeiraData.getText());
                pst.setString(2, SegundaData.getText());
                rs = pst.executeQuery();

                TabelaFinanceiro.setModel(DbUtils.resultSetToTableModel(rs));
                entradaPorPerido.setText("");
                gastoPorPerido.setText("");
                saldoDoPeriodo.setText("");
                

            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, error);
            }

        }

    }

    public void limpar() {
        matriculaFuncionarioText.setText("");
        PrimeiraData.setText("");
        SegundaData.setText("");
        saldoDoPeriodo.setText("");
        gastoPorPerido.setText("");
        entradaPorPerido.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Salvar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaFinanceiro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PrimeiraData = new javax.swing.JFormattedTextField();
        SegundaData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        gastoPorPerido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SaldoFinal = new javax.swing.JTextField();
        saldoDoPeriodo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        entradaPorPerido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        PanelGrafico = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        entrada = new javax.swing.JCheckBox();
        Saida = new javax.swing.JCheckBox();
        matriculaFuncioanrio = new javax.swing.JCheckBox();
        matriculaFuncionarioText = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setTitle("Relatorio de Despesas");

        Salvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\SysFitness1.1\\src\\br\\sys\\Imagens\\zoom.png")); // NOI18N
        Salvar.setText("Pesquisa");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        limpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\paintbrush.png")); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        TabelaFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaFinanceiroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaFinanceiro);

        jLabel1.setText("até");

        jLabel2.setText("Digite as Datas");

        try {
            PrimeiraData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        PrimeiraData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimeiraDataActionPerformed(evt);
            }
        });

        try {
            SegundaData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        SegundaData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegundaDataActionPerformed(evt);
            }
        });

        jLabel3.setText("Pesquisa por:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("Ex: 2012-01-01");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(153, 153, 153));
        jLabel34.setText("Ex: 2012-12-31");

        jLabel4.setText("Saldo atual do Caixa:");

        gastoPorPerido.setEditable(false);
        gastoPorPerido.setBackground(new java.awt.Color(232, 232, 232));

        jLabel5.setText("R$");

        jLabel6.setText("Gasto por perido");

        jLabel7.setText("R$");

        jLabel8.setText("R$");

        SaldoFinal.setEditable(false);
        SaldoFinal.setBackground(new java.awt.Color(232, 232, 232));

        saldoDoPeriodo.setEditable(false);
        saldoDoPeriodo.setBackground(new java.awt.Color(232, 232, 232));

        jLabel9.setText("Entrada por perido");

        entradaPorPerido.setEditable(false);
        entradaPorPerido.setBackground(new java.awt.Color(232, 232, 232));

        jLabel10.setText("R$");

        jLabel11.setText("Saldo por periodo");

        PanelGrafico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\SysFitness1.1\\src\\br\\sys\\Imagens\\tabelafinanceira.png")); // NOI18N

        javax.swing.GroupLayout PanelGraficoLayout = new javax.swing.GroupLayout(PanelGrafico);
        PanelGrafico.setLayout(PanelGraficoLayout);
        PanelGraficoLayout.setHorizontalGroup(
            PanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelGraficoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        PanelGraficoLayout.setVerticalGroup(
            PanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGraficoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        entrada.setText("Entrada");

        Saida.setText("Saida");
        Saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaidaActionPerformed(evt);
            }
        });

        matriculaFuncioanrio.setText("Matricula do Funcionario");
        matriculaFuncioanrio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                matriculaFuncioanrioMouseClicked(evt);
            }
        });
        matriculaFuncioanrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaFuncioanrioActionPerformed(evt);
            }
        });

        matriculaFuncionarioText.setEditable(false);
        matriculaFuncionarioText.setBackground(new java.awt.Color(234, 234, 234));
        matriculaFuncionarioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaFuncionarioTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entrada)
                    .addComponent(Saida)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(matriculaFuncioanrio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(matriculaFuncionarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matriculaFuncioanrio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(matriculaFuncionarioText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                .addComponent(Saida)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(PrimeiraData, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel35))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel34)
                                            .addComponent(SegundaData, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gastoPorPerido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(entradaPorPerido, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoDoPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SaldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))))
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(gastoPorPerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(entradaPorPerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(saldoDoPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(PrimeiraData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SegundaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel35))
                            .addComponent(jLabel34))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\cancel.png")); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salvar)
                .addGap(18, 18, 18)
                .addComponent(limpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Salvar, jButton3, limpar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salvar)
                    .addComponent(limpar)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        try {
            testBox();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioDeEntradaSaida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        limpar();

    }//GEN-LAST:event_limparActionPerformed

    private void TabelaFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaFinanceiroMouseClicked
        //        mostrarTurma();
    }//GEN-LAST:event_TabelaFinanceiroMouseClicked

    private void PrimeiraDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimeiraDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrimeiraDataActionPerformed

    private void SegundaDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SegundaDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SegundaDataActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void matriculaFuncionarioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaFuncionarioTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaFuncionarioTextActionPerformed

    private void SaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaidaActionPerformed

    private void matriculaFuncioanrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaFuncioanrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaFuncioanrioActionPerformed

    private void matriculaFuncioanrioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_matriculaFuncioanrioMouseClicked
        if (matriculaFuncioanrio.isSelected()) {
            matriculaFuncionarioText.setEditable(true);
            matriculaFuncionarioText.setBackground(Color.WHITE);
        } else {
            matriculaFuncionarioText.setEditable(false);
            matriculaFuncionarioText.setBackground(new Color(220, 220, 220));
            matriculaFuncionarioText.setText("");
        }
    }//GEN-LAST:event_matriculaFuncioanrioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGrafico;
    private javax.swing.JFormattedTextField PrimeiraData;
    private javax.swing.JCheckBox Saida;
    private javax.swing.JTextField SaldoFinal;
    private javax.swing.JButton Salvar;
    private javax.swing.JFormattedTextField SegundaData;
    private javax.swing.JTable TabelaFinanceiro;
    private javax.swing.JCheckBox entrada;
    private javax.swing.JTextField entradaPorPerido;
    private javax.swing.JTextField gastoPorPerido;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar;
    private javax.swing.JCheckBox matriculaFuncioanrio;
    private javax.swing.JTextField matriculaFuncionarioText;
    private javax.swing.JTextField saldoDoPeriodo;
    // End of variables declaration//GEN-END:variables

    

  
}
