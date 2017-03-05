/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.agendadecontatos.dao;

import br.senac.sp.agendadecontatos.utils.ConnectionUtils;
import br.senac.sp.pi3.agendadecontatos.contrutor.Contato;
import java.sql.Connection;
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

    public static void inserir(Contato contato)
            throws SQLException, Exception {
        //Monta a string de inserção de um contato no BD,
        //utilizando os dados do contato passados como parâmetro
        String sql = "INSERT INTO contato (nome, data_nacimento, "
                + "telefone, email) VALUES ("
                + "'" + contato.getNome() + "', "
                + "'" + contato.getDataNasc() + "', "
                + contato.getTelefone() + ", "
                + "'" + contato.getEmail() + "')";

        //Executa o comando SQL montado
        executarSQL(sql);
    }

    public static void excluir(Integer id) throws SQLException, Exception {
        String sql = "UPDATE contato SET "
                + "enabled=false"
                + " WHERE ( ID=" + id + ")";

        //Executa o comando SQL montado
        executarSQL(sql);
    }

    //Lista todos os contatos da tabela contatos
    public static List<Contato> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de contatos no banco, considerando
        //apenas a coluna de ativação de contatos ("enabled")
        String sql = "SELECT * FROM contato WHERE enabled=true";

        //Retorna o resultado da execução da consulta SQL montada
        return executarConsulta(sql);
    }

    private static void executarSQL(String sql) throws SQLException, Exception {

        Connection connection = null;

        Statement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute(sql);
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Executa um comando SQL de consulta no banco de dados,
    //tratando da abertura, execução e fechamento de elementos
    //do JDBC necessários e a iteração de elementos de resultado
    //para composição de uma lista de quartos para retorno.
    public static List<Contato> executarConsulta(String sql) throws SQLException, Exception {
        //Lista de contatos de resultado
        List<Contato> listaContato = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando CONSULTA SQL: " + sql);
            //Executa a consulta SQL no banco de dados
            result = statement.executeQuery(sql);
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaContato == null) {
                    listaContato = new ArrayList<Contato>();
                }
                //Cria uma instância de Quarto e popula com os valores do BD
                Contato contato = new Contato();
                contato.setID_Contato(result.getInt("id"));
                contato.setNome(result.getString("nome"));
                contato.setDataNasc(result.getString("dataNasc"));
                contato.setTelefone(result.getString("telefone"));
                contato.setEmail(result.getString("email"));
                //Adiciona a instância na lista
                listaContato.add(contato);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de quartos do banco de dados
        return listaContato;
    }

}
