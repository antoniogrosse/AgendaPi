/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.agendadecontatos.testeconexao;

import java.sql.Connection;
import br.senac.sp.agendadecontatos.utils.ConnectionUtils;
/**
 *
 * @author Antonio Grosse
 */
public class SqlTeste {
    
     private static Connection con = null;
     
     public static void main(String[] args) { 
        
         try {
             
            con = ConnectionUtils.connect();
            System.out.println("Conectado");
            
         }
         catch (Exception e){
             System.out.println("ERRO" + e);
         }
         
    }
    
}
