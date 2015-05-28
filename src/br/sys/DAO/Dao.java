/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.sys.DAO;

import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import br.sys.Bean.Alunos;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Juan
 */
public class Dao {
    
  /*  //ConexaoBD conecta;
    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;
    
    public Dao() throws ClassNotFoundException{
      //  initComponents();
        conecta = ConexaoBD.conexao();
    }
    
    public void inserirAluno(Alunos aluno){
       String sql = "Insert into usuario(id_usuario, id_aluno, capacidade, horario, turno) values(?,?,?,?,?)";
        try{
            pst = conecta.prepareStatement(sql);
            
            pst.setString(1, aluno.nome.getText());
            pst.setString(2, matricula_Professor.getText());
            pst.setString(3, capacidade.getText());
            pst.setString(4, horario.getText());
            pst.setString(5, turno.getSelectedItem().toString());
            
            pst.execute();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!","Cadastro com sucesso", JOptionPane.INFORMATION_MESSAGE);
 //           listarUsuario();
        }
        catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }
         
    }
    
    public void preencherTabela(JTable jTableSocio, String filtro){
        int count = 0;
        boolean existeSocio = true;
                
        ArrayList dados = new ArrayList();
                                                                                                      
        String[] Colunas = new String[]{"Id", "Nome", "Apelido", "Número de Inscrição", "RG", "CPF", "Profissão", "Pai", "Mãe", "Caminho da Foto", "Categoria", "Setor", "Rua", "Bairro", "Número Casa", "Cidade", "Estado", "Cep", "Data de Nascimento", "Data de Inscrição"};
        
        conecta.executaSQL("select * from associados order by nome_socio");
        
        try {
            conecta.resultSet.first();
            do{
                if(filtro.equals("") || conecta.resultSet.getString("nome_aluno").toLowerCase().startsWith(filtro.toLowerCase())){
                    dados.add(new Object[]{conecta.resultSet.getInt("id_socio"),
                                           conecta.resultSet.getString("nome_socio"),
                                           conecta.resultSet.getString("apelido_socio"),
                                           conecta.resultSet.getString("inscricao_socio"),
                                           conecta.resultSet.getString("rg_socio"),
                                           conecta.resultSet.getString("cpf_socio"),
                                           conecta.resultSet.getString("profissao_socio"),
                                           conecta.resultSet.getString("nome_pai_socio"),
                                           conecta.resultSet.getString("nome_mae_socio"),
                                           conecta.resultSet.getString("foto_socio"),
                                           conecta.resultSet.getString("categoria_socio"),
                                           conecta.resultSet.getString("setor_socio"),
                                           conecta.resultSet.getString("rua_socio"),
                                           conecta.resultSet.getString("bairro_socio"),
                                           conecta.resultSet.getString("numero_end_socio"),
                                           conecta.resultSet.getString("cidade_socio"),
                                           conecta.resultSet.getString("estado_socio"),
                                           conecta.resultSet.getString("cep_socio"),
                                           conecta.resultSet.getString("nascimento_socio"),
                                           conecta.resultSet.getString("data_inscricao_socio")});                                        
                                           count++;
                }
            } while(conecta.resultSet.next());
        } catch (SQLException ex){
            //JOptionPane.showMessageDialog(null, "Erro ao Preencher o ArrayList! \n ERRO: "+ex);
            existeSocio = false;
        }
        if (count == 0 && existeSocio){
             JOptionPane.showMessageDialog(null, "Nenhum sócio cadastrado com essas iniciais!", "AssoSis", JOptionPane.WARNING_MESSAGE);
        }
        else if(count == 0 && !existeSocio){
             JOptionPane.showMessageDialog(null, "Nenhum sócio cadastrado!", "AssoSis", JOptionPane.WARNING_MESSAGE);        
        }
        else{
      //      ModelTabela tabela = new ModelTabela(dados, Colunas);
      //      jTableSocio.setModel(tabela);
            jTableSocio.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(0).setResizable(true);
            jTableSocio.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(1).setResizable(true);
            jTableSocio.getColumnModel().getColumn(2).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(2).setResizable(true);
            jTableSocio.getColumnModel().getColumn(3).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(3).setResizable(true);
            jTableSocio.getColumnModel().getColumn(4).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(4).setResizable(true);
            jTableSocio.getColumnModel().getColumn(5).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(5).setResizable(true);
            jTableSocio.getColumnModel().getColumn(6).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(6).setResizable(true);
            jTableSocio.getColumnModel().getColumn(7).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(7).setResizable(true);
            jTableSocio.getColumnModel().getColumn(8).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(8).setResizable(true);
            jTableSocio.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(9).setResizable(true);
            jTableSocio.getColumnModel().getColumn(10).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(10).setResizable(true);
            jTableSocio.getColumnModel().getColumn(11).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(11).setResizable(true);
            jTableSocio.getColumnModel().getColumn(12).setPreferredWidth(150);
            jTableSocio.getColumnModel().getColumn(12).setResizable(true);
            jTableSocio.getColumnModel().getColumn(13).setPreferredWidth(80);
            jTableSocio.getColumnModel().getColumn(13).setResizable(true);
            jTableSocio.getColumnModel().getColumn(14).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(14).setResizable(true);
            jTableSocio.getColumnModel().getColumn(15).setPreferredWidth(180);
            jTableSocio.getColumnModel().getColumn(15).setResizable(true);
            jTableSocio.getColumnModel().getColumn(16).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(16).setResizable(true);
            jTableSocio.getColumnModel().getColumn(17).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(17).setResizable(true);
            jTableSocio.getColumnModel().getColumn(18).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(18).setResizable(true);
            jTableSocio.getColumnModel().getColumn(19).setPreferredWidth(50);
            jTableSocio.getColumnModel().getColumn(19).setResizable(true);
            jTableSocio.getTableHeader().setReorderingAllowed(true);
            jTableSocio.setAutoResizeMode(jTableSocio.AUTO_RESIZE_OFF);
            jTableSocio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }
    
    
    public boolean pesquisar(int idPesquisa, JTextField nome,
                                                            JTextField apelido,
                                                            JTextField inscricao,
                                                            JTextField rg,
                                                            JTextField cpf,
                                                            JTextField profissao,
                                                            JTextField pai,
                                                            JTextField mae,
                                                            JLabel foto,
                                                            JComboBox categoria,
                                                            JTextField setor,
                                                            JTextField rua,
                                                            JTextField bairro,
                                                            JTextField numCasa,
                                                            JTextField cidade,
                                                            JComboBox estado,
                                                            JTextField cep,
                                                            JTextField nascimento,
                                                            JTextField dataInscricao){
        
        File file;
        conecta.executaSQL("select * from associados");
        try {
            conecta.resultSet.first();
            do{
                if(idPesquisa == conecta.resultSet.getInt("id_socio")){
                    nome.setText(conecta.resultSet.getString("nome_socio"));
                    apelido.setText(conecta.resultSet.getString("apelido_socio"));
                    inscricao.setText(conecta.resultSet.getString("inscricao_socio"));
                    rg.setText(conecta.resultSet.getString("rg_socio"));
                    cpf.setText(conecta.resultSet.getString("cpf_socio"));
                    profissao.setText(conecta.resultSet.getString("profissao_socio"));
                    pai.setText(conecta.resultSet.getString("nome_pai_socio"));
                    mae.setText(conecta.resultSet.getString("nome_mae_socio"));
                    
                    file = new File(conecta.resultSet.getString("foto_socio"));
                    ImageIcon image = new ImageIcon(file.getPath());
                    ImageIcon redimensionar = new ImageIcon(image.getImage().getScaledInstance(75, 100, Image.SCALE_DEFAULT));
                    foto.setIcon(redimensionar);
                    
                    
                
                        
                    foto.setName(conecta.resultSet.getString("foto_socio"));
                    categoria.setSelectedItem("categoria_socio");
                    setor.setText(conecta.resultSet.getString("setor_socio"));
                    rua.setText(conecta.resultSet.getString("rua_socio"));
                    bairro.setText(conecta.resultSet.getString("bairro_socio"));
                    numCasa.setText(conecta.resultSet.getString("numero_end_socio"));
                    cidade.setText(conecta.resultSet.getString("cidade_socio"));
                    estado.setSelectedItem("estado_socio");
                    cep.setText(conecta.resultSet.getString("cep_socio"));
                    nascimento.setText(conecta.resultSet.getString("nascimento_socio"));
                    dataInscricao.setText(conecta.resultSet.getString("data_inscricao_socio"));
                    return true;
                }
            } while(conecta.resultSet.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Dados do Banco! \n ERRO: "+ex);
        }    
        JOptionPane.showMessageDialog(null, "Socio não Cadastrado!", "AssoSis", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
    public boolean excluir(JTextField inscricao){
        try {
            PreparedStatement prepStat;
            prepStat = conecta.connection.prepareStatement("delete from associados where inscricao_socio = ?");
            prepStat.setString(1, ( inscricao.getText()));
            prepStat.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Dados! \n ERRO: "+ex, "AssoSis", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean alterar(Alunos aluno){
         try {
            PreparedStatement preStat;
            
            preStat = conecta.connection.prepareStatement("update associados set nome_socio= ?, apelido_socio = ?, rg_socio = ?, cpf_socio = ?, profissao_socio = ?, nome_pai_socio = ?, nome_mae_socio = ?, foto_socio = ?, inscricao_socio = ?, categoria_socio = ?, setor_socio = ?, rua_socio = ?, bairro_socio = ?, numero_end_socio = ?, cidade_socio = ?, estado_socio = ?, cep_socio = ?, nascimento_socio = ?, data_inscricao_socio = ? where id_socio = ?");
            preStat.setString(1, aluno.getNome());
            preStat.setString(2, aluno.getCPF());
            preStat.execute();// executa a inserção

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Dados! \n ERRO: "+ex, "SiGRPMon", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
}
