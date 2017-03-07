/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.agendadecontatos.servicos;

import br.senac.sp.agendadecontatos.dao.DaoAgenda;
import br.senac.sp.agendadecontatos.exceptions.ContatoException;
import br.senac.sp.agendadecontatos.exceptions.DataSourceException;
import br.senac.sp.pi3.agendadecontatos.construtor.Contato;
import java.util.List;

/**
 *
 * @author Antonio Grosse
 */
public class ServicosAgenda {
    
    
    public static void cadastrar(Contato contato) throws ContatoException, DataSourceException {
        
        try {
            
            DaoAgenda.inserir(contato);
        } catch (Exception e) {
            
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    

    
    public static void excluirCliente(Integer id)
            throws ContatoException, DataSourceException {
        try {
            
            DaoAgenda.excluir(id);
        } catch (Exception e) {
            
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
}
