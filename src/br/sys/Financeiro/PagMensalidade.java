package br.sys.Financeiro;

/**
 *
 * @author Alberto
 */
import br.sys.Bean.Mensalidade;
import br.sys.DAO.ConexaoBD;
import br.sys.DAO.MensalidadeDAO;
import br.sys.View.ConsultarSeries;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.sys.function.GerarPdfMesalidade;
import br.sys.function.PegarHora;
import java.text.ParseException;

//import javax.swing.text.html.parser.Element;
import net.proteanit.sql.DbUtils;

public class PagMensalidade extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public PagMensalidade() throws ClassNotFoundException {
        initComponents();
        conecta = ConexaoBD.conexao();

    }

    public void habilitaCampos(boolean habilita, JTextField valor, JTextField matricula_Aluno, JTextField cpf_aluno) {
        matricula_Aluno.setEnabled(habilita);
        matricula_Aluno.setEnabled(habilita);
        cpf_aluno.setEditable(habilita);
    }

    public void pesquisaAlunos() {
        String sql = "Select id_usuario, nome, cpf, endereco from usuario where cpf like ?";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, cpf_aluno.getText() + "%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            TabelaMensalidadeAluno.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    
    public void abirPdf() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("E:\\Recibo_Mensalidade.pdf"));
    }

    public void mostrarTurma() {
        int seleciona = TabelaMensalidadeAluno.getSelectedRow();
        matricula_Aluno.setText(TabelaMensalidadeAluno.getModel().getValueAt(seleciona, 0).toString());
        nomeAluno.setText(TabelaMensalidadeAluno.getModel().getValueAt(seleciona, 1).toString());
    }

    public void limpar() {
        matricula_Aluno.setText("");
        cpf_aluno.setText("");
        valor.setText("");
        dataVenc.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nomeProfessor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        matricula_Aluno = new javax.swing.JTextField();
        dataVenc = new javax.swing.JFormattedTextField();
        cpf_aluno = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaMensalidadeAluno = new javax.swing.JTable();
        Salvar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nomeAluno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        matriculaFuncionario = new javax.swing.JTextField();

        setTitle("Pagamento Mensalidade");

        jLabel4.setText("Matricula do Aluno");

        nomeProfessor.setText("Valor da mensalidade:");

        jLabel2.setText("Data de Vencimento:");

        jLabel1.setText("CPF do Aluno:");

        valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorActionPerformed(evt);
            }
        });

        matricula_Aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matricula_AlunoActionPerformed(evt);
            }
        });

        try {
            dataVenc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataVenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataVencActionPerformed(evt);
            }
        });

        try {
            cpf_aluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf_aluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpf_alunoKeyReleased(evt);
            }
        });

        TabelaMensalidadeAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMensalidadeAlunoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaMensalidadeAluno);

        Salvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\SysFitness1.1\\src\\br\\sys\\Imagens\\disk.png")); // NOI18N
        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\cancel.png")); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        limpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\paintbrush.png")); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome do Aluno");

        nomeAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeAlunoActionPerformed(evt);
            }
        });

        jLabel3.setText("Matricula do funcionario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cpf_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(matricula_Aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(234, 234, 234))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeProfessor))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(dataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matriculaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricula_Aluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf_aluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeProfessor)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matriculaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(limpar)
                    .addComponent(Salvar))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataVencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataVencActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataVencActionPerformed

    private void valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorActionPerformed

    private void matricula_AlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matricula_AlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matricula_AlunoActionPerformed

    private void TabelaMensalidadeAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMensalidadeAlunoMouseClicked
        mostrarTurma();
 
    }//GEN-LAST:event_TabelaMensalidadeAlunoMouseClicked

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        PegarHora hora = new PegarHora();
        try {                                       
            Mensalidade mensalidade = new Mensalidade();
            MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
            
            mensalidade.setNome(nomeAluno.getText());
            mensalidade.setMat_alunos(Integer.parseInt(matricula_Aluno.getText()));
            mensalidade.setCpf(cpf_aluno.getText());
            mensalidade.setValor(Float.parseFloat(valor.getText()));
            mensalidade.setData_vencimento(dataVenc.getText());
            mensalidade.setData_pagamento(hora.Hora());
            mensalidade.setMat_funcionario(Integer.parseInt(matriculaFuncionario.getText()));
            
            mensalidadeDAO.InserirMensalidade(mensalidade);
            GerarPdfMesalidade gerar = new GerarPdfMesalidade();
            
            gerar.GerarPdfMensalidade(mensalidade);
            
            /* try {
            GerarPdf();
            } catch (FileNotFoundException ex) {
            Logger.getLogger(PagMensalidade.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            try {
                abirPdf();
            } catch (IOException ex) {
                Logger.getLogger(PagMensalidade.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            limpar();
        } catch (ParseException ex) {
            Logger.getLogger(PagMensalidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        limpar();
    }//GEN-LAST:event_limparActionPerformed

    private void cpf_alunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpf_alunoKeyReleased
        pesquisaAlunos();
    }//GEN-LAST:event_cpf_alunoKeyReleased

    private void nomeAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeAlunoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salvar;
    private javax.swing.JTable TabelaMensalidadeAluno;
    private javax.swing.JFormattedTextField cpf_aluno;
    private javax.swing.JFormattedTextField dataVenc;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField matriculaFuncionario;
    private javax.swing.JTextField matricula_Aluno;
    private javax.swing.JTextField nomeAluno;
    private javax.swing.JLabel nomeProfessor;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
