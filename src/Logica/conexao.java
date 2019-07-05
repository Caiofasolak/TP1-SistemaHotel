/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
/**
 * Classe conexao tem o trabalho de conectar o programa java com o banco de dados
 * MySql administrado pelo phpMyAdmin.
 * @author caiof
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//Classe conexao se liga ao bando DB, hospedado em URL, ja passando o usuari e senha
public class conexao {
    public String db="bancoreserva";//alterar para nome do DB
    public String url="jdbc:mysql://127.0.0.1/" +db;
    public String user="root";
    public String pass="";


public conexao() {

}

//Utiliza try e catch para se conectar ao banco de dados utilizando as funcoes
//contidas em java.sql.
public Connection conectar(){
    Connection link=null;
    try {
        Class.forName("org.gjt.mm.mysql.Driver");
        link=DriverManager.getConnection(this.url, this.user, this.pass);
    }
    catch (ClassNotFoundException | SQLException e){
        JOptionPane.showConfirmDialog(null, e);
    }
    return link;
    }
}