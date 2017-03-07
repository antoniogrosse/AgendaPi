/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.pi3.agendadecontatos.construtor;

/**
 *
 * @author Antonio Grosse
 */
public class Contato {

    private int id;
    private String nome;
    private String dataNasc;
    private String telefone;
    private String email;
    
    public Contato(){
        
    }

    public Contato(String nome, String telefone, String dataNasc, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.email = email;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int ID_Contato) {
        this.id = ID_Contato;
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
