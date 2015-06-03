package br.sys.SysFitness;

import br.sys.Bean.PagamentoDeSalario;
import br.sys.Financeiro.*;
import br.sys.Cadastro.CadFuncionario;
import br.sys.Financeiro.PagMensalidade;
import br.sys.Cadastro.CadSerie;
import br.sys.Cadastro.CadTurma;
import br.sys.Cadastro.CadAlunos;
import br.sys.Cadastro.CadExames;
import br.sys.Financeiro.PagSalario;
import br.sys.View.ConsultarExames;
import br.sys.View.ConsultarAluno;
import br.sys.View.ConsultarMedidas;
import br.sys.View.ConsultarSeries;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.sys.SysFitness.login;
import br.sys.View.ConsultarFuncionario;

/**
 *
 * @author Alberto
 */
public class TelaTecnicoAdmin extends javax.swing.JFrame {

    /**
     * Creates new form TelaTecnicoAdmin
     */
    public TelaTecnicoAdmin() {
        initComponents();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelCentral = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        botaoBusca = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(280, 50, 0, 0));

        PainelCentral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alberto\\Documents\\NetBeansProjects\\SysFitness1.1\\src\\br\\sys\\Imagens\\pano_de_fundo.jpg")); // NOI18N

        javax.swing.GroupLayout PainelCentralLayout = new javax.swing.GroupLayout(PainelCentral);
        PainelCentral.setLayout(PainelCentralLayout);
        PainelCentralLayout.setHorizontalGroup(
            PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCentralLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        PainelCentralLayout.setVerticalGroup(
            PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCentralLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        PainelCentral.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("Alunos");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Cadastro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        botaoBusca.setText("Buscar");
        botaoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscaActionPerformed(evt);
            }
        });
        jMenu1.add(botaoBusca);

        jMenuItem13.setText("Atualização dos exames");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuItem15.setText("Exames");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Funcionarios");

        jMenuItem6.setText("Cadastro de Funcionario");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem11.setText("Cadastro de Turma");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem7.setText("Buscar Funcionarios");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenu5.setText("Turmas");

        jMenuItem2.setText("Montar Turma");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem2);

        jMenuItem8.setText("Verificar Turma");
        jMenu5.add(jMenuItem8);

        jMenu4.add(jMenu5);

        jMenu7.setText("Relatórios");

        jMenuItem14.setText("Series do Aluno");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem12.setText("Cargos dos Funcionarios");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem12);

        jMenu4.add(jMenu7);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Finaceiro");

        jMenuItem3.setText("Pagamento de Mensalidade");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenu8.setText("Relatorios");

        jMenuItem4.setText("Mensalidades de Alunos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenuItem5.setText("Relatorio de Entrada");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem5);

        jMenuItem16.setText("Relatorio de Pagamentos");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem16);

        jMenu2.add(jMenu8);

        jMenuBar1.add(jMenu2);

        jMenu9.setText("Logoff");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu9);

        jMenu3.setText("Sair");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelCentral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CadAlunos obj = null;
        try {
            obj = new CadAlunos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void botaoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscaActionPerformed
        br.sys.View.ConsultarAluno obj = null;
        try {
            obj = new ConsultarAluno();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_botaoBuscaActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        br.sys.View.ConsultarExames obj = null;
        try {
            obj = new ConsultarExames();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        br.sys.Cadastro.CadExames obj = null;
        try {
            obj = new CadExames();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        br.sys.Cadastro.CadFuncionario obj = null;
        try {
            obj = new CadFuncionario();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        br.sys.Cadastro.CadTurma obj = null;
        obj = new CadTurma();
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        br.sys.Cadastro.CadTurma obj = null;
        obj = new CadTurma();
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        br.sys.View.ConsultarSeries obj = null;
        try {
            obj = new ConsultarSeries();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        br.sys.Financeiro.PagMensalidade obj = null;
        try {
            obj = new PagMensalidade();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        br.sys.Financeiro.RelatorioDePagamentoMensalidade obj = null;
        try {
            obj = new RelatorioDePagamentoMensalidade();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        br.sys.Financeiro.RelatorioDeEntrada obj = null;
        try {
            obj = new RelatorioDeEntrada();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        br.sys.Financeiro.RelatorioDeSaida obj = null;
        try {
            obj = new RelatorioDeSaida();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        int i = JOptionPane.showConfirmDialog(null, "Você deseja trocar de Usuário.");
        if (i == JOptionPane.YES_OPTION) {
            login frm = null;
            try {
                frm = new login();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            frm.setVisible(true);
            dispose();
        } else if (i == JOptionPane.NO_OPTION) {
            System.out.println("Clicou em Não");
        }else if (i == JOptionPane.CANCEL_OPTION) {
            System.out.println("Clicou em Cancel");
        }

        //------------------------
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        br.sys.View.ConsultarFuncionario obj = null;
        try {
            obj = new ConsultarFuncionario();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaTecnicoAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        PainelCentral.add(obj);
        obj.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaTecnicoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTecnicoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTecnicoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTecnicoAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTecnicoAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane PainelCentral;
    private javax.swing.JMenuItem botaoBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}
