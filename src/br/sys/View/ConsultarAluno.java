package br.sys.View;

/**
 *
 * @author Alberto
 */
import br.sys.DAO.ConexaoBD;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class ConsultarAluno extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public ConsultarAluno() throws ClassNotFoundException {
        initComponents();
        conecta = ConexaoBD.conexao();
        foto.setName("C:\\Users\\Alberto\\Pictures\\photos\\user 1(Custom).png");
    }

    public void pesquisaUsuarioCodigo() {
        String sql = "Select id_usuario AS Matrcula, nome, cpf, endereco,foto from usuario where id_usuario like ?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, matriculaAluno.getText() + "%");
            rs = pst.executeQuery();
            TabelaAluno.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaUsuario() {
        String sql = "Select id_usuario AS Matrcula, nome, cpf, endereco,telCelular,telFixo,foto from usuario where cpf like ?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, cpfUsuario.getText() + "%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            TabelaAluno.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void restaurar() {
        String sql = "Update usuario set verificador = ? where cpf = ?";
        int aux = 1;
        try {
            pst = conecta.prepareStatement(sql);
            pst.setInt(1, aux);
            pst.setString(2, cpfUsuario.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Matricula reativada com sucesso.");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }

    public void verificador() {
        String sql = "Select *from usuario where cpf =? and verificador = ?";
        String aux = "0";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, cpfUsuario.getText());
            pst.setString(2, aux);

            rs = pst.executeQuery();

            if (rs.next()) {
                int i = JOptionPane.showConfirmDialog(null, "Aluno esta excluido logicamente."
                        + "\nDeseja Reativar a exclusão?");
                if (i == JOptionPane.YES_OPTION) {
                    restaurar();
                } else if (i == JOptionPane.NO_OPTION) {
                    System.out.println("Clicou em Não");
                } else if (i == JOptionPane.CANCEL_OPTION) {
                    System.out.println("Clicou em Cancel");
                }

            } else {
                pesquisaUsuario();
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void ExcluirLogicamente() {
        String sql = "Update usuario set verificador = ? where cpf = ?";
        String aux = "0";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, aux);
            pst.setString(2, cpfUsuario.getText());
            pst.execute();
            //    JOptionPane.showMessageDialog(null,aux + "Test");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void excluirDefinitivamente() {
        String sql = "DELETE FROM usuario WHERE cpf like ?;";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, cpfUsuario.getText());
            pst.execute();
            //    JOptionPane.showMessageDialog(null,aux + "Test");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void mostrarAluno() {
        int seleciona = TabelaAluno.getSelectedRow();
        matriculaAluno.setText(TabelaAluno.getModel().getValueAt(seleciona, 0).toString());
        nomeUsuario.setText(TabelaAluno.getModel().getValueAt(seleciona, 1).toString());

        // Comando para buscar foto
        File file = new File(TabelaAluno.getModel().getValueAt(seleciona, 6).toString());
        ImageIcon image = new ImageIcon(file.getPath());
        ImageIcon redimensionar = new ImageIcon(image.getImage().getScaledInstance(90, 100, Image.SCALE_DEFAULT));
        foto.setIcon(redimensionar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaAluno = new javax.swing.JTable();
        matriculaAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        cpfUsuario = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        Foto = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();

        setTitle("Buscar Alunos ");

        TabelaAluno.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TabelaAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaAlunoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaAluno);

        matriculaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaAlunoActionPerformed(evt);
            }
        });
        matriculaAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                matriculaAlunoKeyReleased(evt);
            }
        });

        jLabel2.setText("CPF:");

        jLabel1.setText("Nome:");

        jLabel4.setText("Matricula");

        nomeUsuario.setEditable(false);
        nomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeUsuarioActionPerformed(evt);
            }
        });
        nomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeUsuarioKeyReleased(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\cancel.png")); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        salvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\SysFitness1.1\\src\\br\\sys\\Imagens\\zoom.png")); // NOI18N
        salvar.setText("Buscar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        limpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\Projetos\\icones\\icons\\paintbrush.png")); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        try {
            cpfUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfUsuarioActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\SysFitness1.1\\src\\br\\sys\\Imagens\\user_delete.png")); // NOI18N
        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Foto.setBackground(new java.awt.Color(255, 255, 255));
        Foto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/sys/Imagens/user1.png"))); // NOI18N
        foto.setToolTipText("Click aqui");
        foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FotoLayout = new javax.swing.GroupLayout(Foto);
        Foto.setLayout(FotoLayout);
        FotoLayout.setHorizontalGroup(
            FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FotoLayout.createSequentialGroup()
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        FotoLayout.setVerticalGroup(
            FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FotoLayout.createSequentialGroup()
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matriculaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGap(25, 25, 25))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton3, limpar, salvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(matriculaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(limpar)
                    .addComponent(salvar)
                    .addComponent(jButton1))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoMouseClicked

    }//GEN-LAST:event_fotoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //options = { “OK”, “CANCELAR”,”VOLTAR” };
        int i = JOptionPane.showConfirmDialog(null, "Deseja excluir este aluno definitivamente?.");
        if (i == JOptionPane.YES_OPTION) {
            excluirDefinitivamente();
        } else if (i == JOptionPane.NO_OPTION) {
            ExcluirLogicamente();
        } else if (i == JOptionPane.CANCEL_OPTION) {
            System.out.println("Clicou em Cancel");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cpfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfUsuarioActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        nomeUsuario.setText("");
        matriculaAluno.setText("");
        cpfUsuario.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        verificador();
    }//GEN-LAST:event_salvarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nomeUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeUsuarioKeyReleased
        pesquisaUsuario();
        cpfUsuario.setText("");
        matriculaAluno.setText("");
    }//GEN-LAST:event_nomeUsuarioKeyReleased

    private void nomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeUsuarioActionPerformed

    private void matriculaAlunoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matriculaAlunoKeyReleased
        pesquisaUsuarioCodigo();
        nomeUsuario.setText("");
        cpfUsuario.setText("");
    }//GEN-LAST:event_matriculaAlunoKeyReleased

    private void matriculaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaAlunoActionPerformed

    private void TabelaAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaAlunoMouseClicked
        mostrarAluno();
    }//GEN-LAST:event_TabelaAlunoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Foto;
    private javax.swing.JTable TabelaAluno;
    private javax.swing.JFormattedTextField cpfUsuario;
    private javax.swing.JLabel foto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField matriculaAluno;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}
