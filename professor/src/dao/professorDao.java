/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.professor;
/**
 *
 * @author Administrador
 */
public class professorDao {
     public static boolean inserir(professor objeto) {
        String sql = "INSERT INTO professor (sobrenome, nome, endereco) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSobrenome());
            ps.setString(2, objeto.getNome());
            ps.setString(3, objeto.getEndereco());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
      public static void main(String[] args) {
        professor objeto = new professor();
        objeto.setSobrenome("beLini");
        objeto.setNome("Rachel");
        objeto.setEndereco("XVI");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
