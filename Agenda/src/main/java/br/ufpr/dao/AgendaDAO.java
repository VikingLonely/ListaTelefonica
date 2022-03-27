/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufpr.dao;

import br.com.connection.ConnectionFactory;
import br.ufpr.modelo.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * mascara para o telefone
 * evitar salvar dois registros
 * @author Adrya
 */
public class AgendaDAO {
    public void criar(Agenda ag){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO agenda(nome, sobrenome, telefone) VALUES (?,?,?)");
            stmt.setString(1, ag.getNome());
            stmt.setString(2, ag.getSobrenome());
            stmt.setString(3, ag.getTelefone());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro efetuado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar! Mensagem de erro: "+e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
                
    }
   
    public void alterar(Agenda ag){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE agenda SET nome = ?, sobrenome = ?, telefone = ? WHERE id = ? ");
            stmt.setString(1, ag.getNome());
            stmt.setString(2, ag.getSobrenome());
            stmt.setString(3, ag.getTelefone());
            stmt.setInt(4, ag.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! Mensagem de erro: "+e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        } 
    }
    
    public void excluir(Agenda ag){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM agenda WHERE id = ?");
            stmt.setInt(1, ag.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir! Mensagem de erro: "+e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Agenda> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agenda> agendas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM agenda");
            rs = stmt.executeQuery();
            while(rs.next()){
                Agenda ag = new Agenda();
                ag.setId(rs.getInt("id"));
                ag.setNome(rs.getString("nome"));
                ag.setSobrenome(rs.getString("sobrenome"));
                ag.setTelefone(rs.getString("telefone"));
                agendas.add(ag);
            }
        } catch (SQLException e) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return agendas;
    }
}
