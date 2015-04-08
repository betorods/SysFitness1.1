/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
/**
 *
 * @author Alberto
 */
public class Equipamento {
     private String Id_Equipamento;
     private String Nome;
     private String Quantidade;

    public String getId_Equipamento() {
        return Id_Equipamento;
    }

    public void setId_Equipamento(String Id_Equipamento) {
        this.Id_Equipamento = Id_Equipamento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String Quantidade) {
        this.Quantidade = Quantidade;
    }
     
}
