/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.agendadecontatos.exceptions;

/**
 *
 * @author Antonio Grosse
 */
public class ContatoException extends Exception {
    
    /**
     * Construtor de exceções que permite informar uma mensagem *
     */
    public ContatoException(String message) {
        super(message);
    }
    
}
