/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.agendadecontatos.servicos;

import br.senac.sp.agendadecontatos.dao.DaoAgenda;
import br.senac.sp.agendadecontatos.exceptions.ContatoException;
import br.senac.sp.agendadecontatos.exceptions.DataSourceException;
import br.senac.sp.pi3.agendadecontatos.contrutor.Contato;
import java.util.List;

/**
 *
 * @author Antonio Grosse
 */
public class ServicosAgenda {
    
     //Insere um contato na fonte de dados
    public static void cadastrar(Contato contato)
            throws ContatoException, DataSourceException {
        //Realização de validações 
        if (contato == null) {
            throw new ContatoException("Não foi informado um contato");
        }
        if (contato.getNome() == null || "".equals(contato.getNome())) {
            throw new ContatoException("É necessário informar"
                    + "um nome de contato");
        }
        if (contato.getTelefone()== null
                || "".equals(contato.getTelefone())) {
            throw new ContatoException("É necessário informar um"
                    + "telefone de contato");
        }
           if (contato.getEmail()== null
                || "".equals(contato.getEmail())) {
            throw new ContatoException("É necessário informar um"
                    + "e-mail de contato");
        }

        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoAgenda.inserir(contato);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    //Atualiza um cliente na fonte de dados
    public static void atualizar(Contato contato)
            throws ContatoException, DataSourceException {
        
//Realização de validações 
        if (contato == null) {
            throw new ContatoException("Não foi informado um contato");
        }
        if (contato.getNome() == null || "".equals(contato.getNome())) {
            throw new ContatoException("É necessário informar"
                    + "um nome de contato");
        }
        if (contato.getTelefone()== null
                || "".equals(contato.getTelefone())) {
            throw new ContatoException("É necessário informar um"
                    + "telefone de contato");
        }
           if (contato.getEmail()== null
                || "".equals(contato.getEmail())) {
            throw new ContatoException("É necessário informar um"
                    + "e-mail de contato");
        }

        try {
            //Realiza a chamada de atualização na fonte de dados
            DaoAgenda.atualizar(contato);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um contato por nome na fonte de dados
    public static List<Contato> procurarCliente(String nome)
            throws ContatoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do banco.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            if (nome == null || "".equals(nome)) {
                return DaoAgenda.listar();
            } else {
                return DaoAgenda.procurar(nome);
            }
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o contato com ID informado do banco de dados
    public static Contato obterCliente(Integer id)
            throws ContatoException, DataSourceException {
        try {
            //Retorna o contato obtido com o DAO
            return DaoAgenda.obter(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o contato com ID informado do banco de dados
    public static void excluirCliente(Integer id)
            throws ContatoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do cliente informado
            DaoAgenda.excluir(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
}
