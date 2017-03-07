/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.agendadecontatos.dao;

import br.senac.sp.agendadecontatos.utils.ConnectionUtils;
import br.senac.sp.pi3.agendadecontatos.construtor.Contato;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio Grosse
 */
public class DaoAgenda {
    
    private static Connection con = null;

    public static void inserir(Contato contato) throws SQLException, Exception {
        
        con = ConnectionUtils.connect();
        
        String sql = "INSERT INTO Contato "
                + "(Nome, Telefone, Nascimento, Email) "
                + "VALUES ( ?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getTelefone());
        stmt.setString(3, contato.getEmail());
        stmt.setString(4, contato.getDataNasc());

        
        stmt.execute();

        
        ConnectionUtils.disconect();
    }
    
    public static void excluir(Integer id) throws SQLException, Exception {
        
        con = ConnectionUtils.connect();
        
        String sql = "DELETE FROM Contato WHERE id = ?";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();

        ConnectionUtils.disconect();
    }

    public ArrayList<Contato> buscarContato(String nome) throws SQLException, IOException {

        con = ConnectionUtils.connect();

        ArrayList<Contato> listaResultado = new ArrayList<>();

        PreparedStatement stmt = null;

        if (nome.equalsIgnoreCase(" ")) {

            String slq = "SELECT * FROM Contato";

            stmt = con.prepareStatement(slq);

        } else {

            String slq = "SELECT * FROM agenda WHERE nome like '%" + nome + "%'";

            stmt = con.prepareStatement(slq);

        }

        ResultSet result = stmt.executeQuery();

        while (result.next()) {

            Contato contato = new Contato(
                    result.getString("Nome"),
                    result.getString("Telefone"),
                    result.getString("Nascimento"),
                    result.getString("Email"));

            contato.setId(result.getInt("id"));

            listaResultado.add(contato);

        }

        ConnectionUtils.disconect();

        return listaResultado;

    }

}
