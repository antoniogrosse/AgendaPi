/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.pi3.agendadecontatos.contrutor;

/**
 *
 * @author Antonio Grosse
 */
public class Contato {

    private int ID_Contato;
    private String nome;
    private String dataNasc;
    private String DD_Telefone;
    private String telefone;
    private String email;
    
    public int getID_Contato() {
        return ID_Contato;
    }

    public void setID_Contato(int ID_Contato) {
        this.ID_Contato = ID_Contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String DataNasc) {
        this.dataNasc = DataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String Telefone) {
        this.telefone = Telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

}
