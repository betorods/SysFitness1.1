package br.sys.Cadastro;

import br.sys.Bean.Alunos;
import br.sys.Bean.Cargo;
import br.sys.Bean.Turma;
import br.sys.DAO.AlunoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.sys.DAO.ConexaoBD;
import br.sys.DAO.ExamesDAO;
import java.awt.Button;
import java.awt.Image;
import java.io.File;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Alberto
 */
public class CadAlunos extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public CadAlunos() throws ClassNotFoundException {
        initComponents();
        conecta = ConexaoBD.conexao();
        buscarMatricula();
        foto.setName("C:\\Users\\Alberto\\Pictures\\photos\\user 1(Custom).png");

    }
    
    public void buscarMatricula() throws ClassNotFoundException {
        int id = 0;
        try {
            Connection con = ConexaoBD.conexao();
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("select max(id_usuario)AS id from usuario;");
            while (rs.next()) {
                id = rs.getInt("id");
                id += 1;
            }
            matriculaFuncionario.setText(Integer.toString(id));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   
    public void mostrarTurma() {
        int seleciona = TabelaTurma.getSelectedRow();
        cod_turma.setText(TabelaTurma.getModel().getValueAt(seleciona, 0).toString());
        alunos_cadastrado.setText(TabelaTurma.getModel().getValueAt(seleciona, 5).toString());
        //   verificarTurno.setText(TabelaTurma.getModel().getValueAt(seleciona,1).toString());
    }

    public void VerificarTurma() {
        String sql = "Select *FROM turma WHERE cod_turma =? AND alunos_cadastrado = ?";
        String aux = "10";
        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, cod_turma.getText());
            pst.setString(2, aux);

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Turma lotada. ");
                cod_turma.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Disponivel. ");
                mostrarTurma();
                //  verificarTurno.setText("");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisaTurma() {
        String sql = "Select cod_turma, mat_Professor, turno, capacidade, horario, alunos_cadastrado FROM turma WHERE turno LIKE ?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, verificarTurno.getSelectedItem().toString() + "%");

            rs = pst.executeQuery();
            TabelaTurma.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void updateTurma() {

        String sql1 = "Update turma set alunos_cadastrado = ? where cod_turma = ?";
        int aux = 1;
        int aux2 = Integer.parseInt(alunos_cadastrado.getText());
        aux += aux2;
        try {
            pst = conecta.prepareStatement(sql1);
            pst.setInt(1, aux);
            pst.setInt(2, Integer.parseInt(cod_turma.getText()));
            pst.execute();
            //    JOptionPane.showMessageDialog(null, cod_turma + "Cadastrado Turma com sucesso!","Cadastro com sucesso", JOptionPane.INFORMATION_MESSAGE);
            cod_turma.setText("");
            alunos_cadastrado.setText("");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void editarBotoes(JButton salvar, boolean salva) {
        salvar.setEnabled(salva);

    }

    public void limparCampos() {
        nome.setText("");
        dataNasc.setText("");
        localNasc.setText("");
        cpf.setText("");
        rg.setText("");
        telCelular.setText("");
        telFixo.setText("");
        mae.setText("");
        pai.setText("");
        endereco.setText("");
        numero.setText("");
        bairro.setText("");
        cep.setText("");
        cidade.setText("");
       // foto.setText("");
    }

    public void habilitaCampos(boolean habilita, JTextField nome, JTextField cidade,
            JTextField telcelular,
            JTextField telFixo,
            JTextField cpf,
            JTextField endereco,
            JTextField dataNasc,
            JTextField localNasc,
            JTextField rg,
            JTextField mae,
            JTextField pai,
            JTextField numero,
            JTextField bairro,
            JTextField cep,
            JRadioButton sexoMasculino,
            JRadioButton sexoFeminino,
            ButtonGroup sexo,
            JComboBox estado) {
        nome.setEnabled(habilita);
        dataNasc.setEnabled(habilita);
        localNasc.setEnabled(habilita);
        cpf.setEnabled(habilita);
        rg.setEnabled(habilita);
        telcelular.setEnabled(habilita);
        telFixo.setEnabled(habilita);
        mae.setEnabled(habilita);
        pai.setEditable(habilita);
        endereco.setEnabled(habilita);
        numero.setEnabled(habilita);
        bairro.setEnabled(habilita);
        cep.setEnabled(habilita);
        cidade.setEnabled(habilita);
        estado.setEnabled(habilita);
        sexoFeminino.setEnabled(habilita);
        sexoMasculino.setEnabled(habilita);
        sexo.setSelected(null, habilita);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo = new javax.swing.ButtonGroup();
        jLabel32 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        mae = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        pai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rg = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sexoFeminino = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sexoMasculino = new javax.swing.JRadioButton();
        nome = new javax.swing.JTextField();
        nomeProfessor = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        dataNasc = new javax.swing.JFormattedTextField();
        localNasc = new javax.swing.JTextField();
        telFixo = new javax.swing.JFormattedTextField();
        telCelular = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        enderecoProfessor = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cep = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        estados = new javax.swing.JComboBox();
        Foto = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        matriculaFuncionario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaTurma = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        verificarTurno = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        cod_turma = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        alunos_cadastrado = new javax.swing.JTextField();
        voltar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        salvar = new javax.swing.JButton();

        jLabel32.setText("jLabel32");

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Alunos");

        jLabel17.setText("Nome do Pai:");

        jLabel18.setText("Local de Nascimento:");

        jLabel10.setText("RG:");

        jLabel16.setText("Nome da Mãe:");

        jLabel9.setText("CPF:");

        jLabel7.setText("Telefone Fixo:");

        jLabel8.setText("Telefone Celular:");

        sexo.add(sexoFeminino);
        sexoFeminino.setText("Feminino");
        sexoFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoFemininoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de Nascimento");

        jLabel2.setText("Sexo");

        sexo.add(sexoMasculino);
        sexoMasculino.setText("Masculino");
        sexoMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexoMasculinoActionPerformed(evt);
            }
        });

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        nomeProfessor.setText("Nome:");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            dataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataNascActionPerformed(evt);
            }
        });

        localNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localNascActionPerformed(evt);
            }
        });

        try {
            telFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telFixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telFixoActionPerformed(evt);
            }
        });

        try {
            telCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        enderecoProfessor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        enderecoProfessor.setText("Endereço");

        jLabel13.setText("Logradouro");

        endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoActionPerformed(evt);
            }
        });

        jLabel14.setText("Numero");

        jLabel4.setText("Bairro");

        bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairroActionPerformed(evt);
            }
        });

        jLabel6.setText("CEP");

        try {
            cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Cidade:");

        jLabel1.setText("Estado");

        estados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(44, 44, 44))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(35, 35, 35)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(estados, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(enderecoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bairro, cidade, endereco});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(enderecoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(estados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bairro, cep, cidade, endereco, numero});

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(35, 35, 35))
        );
        FotoLayout.setVerticalGroup(
            FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FotoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(31, 31, 31))
        );

        matriculaFuncionario.setBackground(new java.awt.Color(230, 228, 228));
        matriculaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaFuncionarioActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Matricula");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(mae, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(pai, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(117, 117, 117)
                                                        .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(telCelular))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(telFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(nomeProfessor)
                                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(sexoMasculino))
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(183, 183, 183)
                                                .addComponent(jLabel7))
                                            .addComponent(sexoFeminino)
                                            .addComponent(localNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matriculaFuncionario)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel5)))
                                .addGap(11, 11, 11)))
                        .addGap(0, 35, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nomeProfessor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(localNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sexoMasculino)
                            .addComponent(sexoFeminino)))
                    .addComponent(Foto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matriculaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Cadastrais", jPanel2);

        TabelaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaTurmaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaTurma);

        jLabel15.setText("Turno:");

        verificarTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manhã", "Tarde", "Noite" }));
        verificarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarTurnoActionPerformed(evt);
            }
        });
        verificarTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                verificarTurnoKeyReleased(evt);
            }
        });

        jLabel19.setText("Turma:");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        alunos_cadastrado.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(verificarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(Buscar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cod_turma, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(alunos_cadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(verificarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cod_turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alunos_cadastrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Turma", jPanel3);

        voltar.setText("Cancelar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(voltar)
                    .addComponent(limpar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        //     cadastrarUsuario();
        verificador = 1;
        Alunos alunos = new Alunos();
        AlunoDAO alunodao = new AlunoDAO();

        alunos.setNome(nome.getText());
        alunos.setDataNasc(dataNasc.getText());
        alunos.setLocalNasc(localNasc.getText());
        alunos.setCpf(cpf.getText());
        alunos.setRg(rg.getText());
        alunos.setTelFixo(telFixo.getText());
        alunos.setTelCelular(telCelular.getText());
        alunos.setMae(mae.getText());
        alunos.setPai(pai.getText());
        alunos.setEndereco(endereco.getText());
        alunos.setBairro(bairro.getText());
        alunos.setCep(cep.getText());
        alunos.setCidade(cidade.getText());
        alunos.setSexo(Sex);
        alunos.setEstado(estados.getSelectedItem().toString());
        alunos.setFoto(foto.getName());
        alunos.setVerificador(verificador);

        alunodao.inserirAlunos(alunos);

        //  updateTurma();
    }//GEN-LAST:event_salvarActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        //     new sistemabibliotecario.TelaPrincipal().show();
        this.setVisible(false);
    }//GEN-LAST:event_voltarActionPerformed

    private void estadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadosActionPerformed
        //     Est = ;
    }//GEN-LAST:event_estadosActionPerformed

    private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bairroActionPerformed

    private void enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoActionPerformed

    private void telFixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telFixoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telFixoActionPerformed

    private void localNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localNascActionPerformed

    private void dataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataNascActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void sexoMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoMasculinoActionPerformed
        // TODO add your handling code here:
        Sex = "M";
    }//GEN-LAST:event_sexoMasculinoActionPerformed

    private void sexoFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexoFemininoActionPerformed
        Sex = "F";
    }//GEN-LAST:event_sexoFemininoActionPerformed

    private void fotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fotoMouseClicked
        if (evt.getClickCount() == 2) {
            JFileChooser jfilechooser = new JFileChooser();
            File file = new File("");

            int option = jfilechooser.showOpenDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                file = jfilechooser.getSelectedFile();
                String caminho = file.getAbsolutePath();

                ImageIcon image = new ImageIcon(file.getPath());

                ImageIcon redimensionar = new ImageIcon(image.getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT));

                foto.setIcon(redimensionar);
                foto.setName(caminho);
            } else {
                JOptionPane.showMessageDialog(null, "Voce não selecionou nenhuma foto.");
            }
        }

    }//GEN-LAST:event_fotoMouseClicked

    private void TabelaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaTurmaMouseClicked
        // TurmaDisponivel();
        mostrarTurma();
        VerificarTurma();
    }//GEN-LAST:event_TabelaTurmaMouseClicked

    private void verificarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verificarTurnoActionPerformed

    private void verificarTurnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verificarTurnoKeyReleased
        pesquisaTurma();
    }//GEN-LAST:event_verificarTurnoKeyReleased

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        pesquisaTurma();
    }//GEN-LAST:event_BuscarActionPerformed

    private void matriculaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaFuncionarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JPanel Foto;
    private javax.swing.JTable TabelaTurma;
    private javax.swing.JTextField alunos_cadastrado;
    private javax.swing.JTextField bairro;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField cod_turma;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField dataNasc;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel enderecoProfessor;
    private javax.swing.JComboBox estados;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField localNasc;
    private javax.swing.JTextField mae;
    private javax.swing.JTextField matriculaFuncionario;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel nomeProfessor;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField pai;
    private javax.swing.JTextField rg;
    private javax.swing.JButton salvar;
    private javax.swing.ButtonGroup sexo;
    private javax.swing.JRadioButton sexoFeminino;
    private javax.swing.JRadioButton sexoMasculino;
    private javax.swing.JFormattedTextField telCelular;
    private javax.swing.JFormattedTextField telFixo;
    private javax.swing.JComboBox verificarTurno;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
    private String Sex;
    private int verificador;
}
