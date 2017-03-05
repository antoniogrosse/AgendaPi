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
    private String Nome;
    private String DataNasc;
    private String DD_Telefone;
    private String Telefone;
    private String Email;

    public int getID_Contato() {
        return ID_Contato;
    }

    public void setID_Contato(int ID_Contato) {
        this.ID_Contato = ID_Contato;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(String DataNasc) {
        this.DataNasc = DataNasc;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
