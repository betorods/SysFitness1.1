package View;
/**
 *
 * @author Alberto
 */
import DAO.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class BuscarUsuario extends javax.swing.JInternalFrame {
    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public BuscarUsuario() throws ClassNotFoundException {
       initComponents();
       conecta = ConexaoBD.conexao();
   }
   public void pesquisaUsuarioCpf(){
        String sql ="Select id_usuario, nome, cpf, endereco from usuario where cpf like ?" ;
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, cpfUsuario.getText()+"%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error){
          JOptionPane.showMessageDialog(null, error);
      }
    }  
   
       public void pesquisaUsuarioCodigo(){
        String sql ="Select id_usuario, nome, cpf, endereco from usuario where id_usuario like ?" ;
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, codigoUsuario.getText()+"%");
            rs = pst.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }
       
        public void pesquisaUsuario(){
        String sql ="Select id_usuario, nome, cpf, endereco from usuario where nome like ?" ;
        
        try{
            pst = conecta.prepareStatement(sql);
            pst.setString(1, nomeUsuario.getText()+"%");// %para quando apagar trazer de volta as informações do BD.
            rs = pst.executeQuery();
            TabelaUsuario.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaUsuario = new javax.swing.JTable();
        codigoUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        cpfUsuario = new javax.swing.JFormattedTextField();

        setTitle("Buscar Alunos ");

        TabelaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaUsuario);

        codigoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoUsuarioActionPerformed(evt);
            }
        });
        codigoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoUsuarioKeyReleased(evt);
            }
        });

        jLabel2.setText("CPF:");

        jLabel1.setText("Nome:");

        jLabel4.setText("Matricula");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(limpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nomeUsuario)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(codigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(limpar)
                    .addComponent(salvar))
                .addGap(5, 5, 5))
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

    private void TabelaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaUsuarioMouseClicked

    }//GEN-LAST:event_TabelaUsuarioMouseClicked

    private void codigoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoUsuarioActionPerformed

    private void codigoUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoUsuarioKeyReleased
        pesquisaUsuarioCodigo();
        nomeUsuario.setText("");
        cpfUsuario.setText("");

    }//GEN-LAST:event_codigoUsuarioKeyReleased

    private void nomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeUsuarioActionPerformed

    private void nomeUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeUsuarioKeyReleased
        pesquisaUsuario();
        cpfUsuario.setText("");
        codigoUsuario.setText("");
    }//GEN-LAST:event_nomeUsuarioKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        pesquisaUsuarioCpf();
    }//GEN-LAST:event_salvarActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        nomeUsuario.setText("");
        codigoUsuario.setText("");
        cpfUsuario.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void cpfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaUsuario;
    private javax.swing.JTextField codigoUsuario;
    private javax.swing.JFormattedTextField cpfUsuario;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}
