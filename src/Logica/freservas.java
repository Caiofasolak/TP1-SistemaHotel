/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.vprodutos;
import Dados.vquartos;
import Dados.vreservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * As conexoes das reservas com o banco de dados sao realizadas aqui
 * Consultas sql sao utilizadas para passar e retornar dados do banco de dados
 * Os metodos para criar, editar, salvar, e retornar os dados estao definidos abaixo
 * @author caiof
 */

public class freservas {
    private conexao mysql=new conexao();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
       
    //Tabela padrao para salvar os dados no banco de dados
    DefaultTableModel modelo;
    String[] titulos = {"ID Reserva", "ID quartos", "Número", "ID Clientes", "Nome Cliente", "ID Funcionários", "Funcionário", "Tipo Reserva", "Data Reserva", "Data Entrada", "Data Saída", "Valor quarto", "Estado"};
    String[] registro = new String[13];
    totalregistros = 0;
    
    //Consulta sql necessaria para mostrar as informacoes de reservas no BD
    modelo = new DefaultTableModel(null, titulos);
    sSQL="select r.id_reserva,r.id_quartos,q.numero,r.id_cliente,"+
               "(select nome_pessoa from tb_pessoas where id_pessoa=r.id_cliente)as clienten,"+
               "r.id_funcionario,(select nome_pessoa from tb_pessoas where id_pessoa=r.id_funcionario)as funcionarion,"+
               "r.tipo_reserva,r.data_reserva,r.data_entrada,r.data_saida,"+
               "r.valor_quarto,r.estado from tb_reservas r inner join tb_quartos q on r.id_quartos=q.id_quartos where r.data_reserva like '%"+ buscar + "%' order by id_reserva desc";

    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        while(rs.next()){
               registro [0]=rs.getString("id_reserva");
               registro [1]=rs.getString("id_quartos");
               registro [2]=rs.getString("numero");
               registro [3]=rs.getString("id_cliente");
               registro [4]=rs.getString("clienten");
               registro [5]=rs.getString("id_funcionario");
               registro [6]=rs.getString("funcionarion");
               registro [7]=rs.getString("tipo_reserva");
               registro [8]=rs.getString("data_reserva");
               registro [9]=rs.getString("data_entrada");
               registro [10]=rs.getString("data_saida");
               registro [11]=rs.getString("valor_quarto");
               registro [12]=rs.getString("estado");
               
               totalregistros = totalregistros +1;
               modelo.addRow(registro);
        }
        return modelo;
    }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }
    
    }
    
    public boolean inserir (vreservas dts){
        sSQL = "insert into tb_reservas ( id_quartos, id_cliente, id_funcionario, tipo_reserva, data_reserva, data_entrada, data_saida, valor_quarto, estado)" +
                "values(?,?,?,?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdquartos());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdfuncionario());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, dts.getData_reserva());
            pst.setDate(6, dts.getData_entrada());
            pst.setDate(7, dts.getData_saida());
            pst.setDouble(8, dts.getValor_quarto());
            pst.setString(9, dts.getEstado());
            
            int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
             return false;
        }
    }
    
    public boolean editar (vreservas dts){
        
        sSQL="update tb_reservas set id_cliente=?, id_quartos=?, id_funcionario=?, tipo_reserva=?, data_reserva=?, data_entrada=?, data_saida=?, valor_quarto=?, estado=?" +
                "where id_reserva=?";
        
               
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdquartos());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdfuncionario());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, dts.getData_reserva());
            pst.setDate(6, dts.getData_entrada());
            pst.setDate(7, dts.getData_saida());
            pst.setDouble(8, dts.getValor_quarto());
            pst.setString(9, dts.getEstado());
          
            pst.setInt(10, dts.getIdreserva());
            
             int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
         return false;
        }
    }
    
     public boolean pagar (vreservas dts){
        
        sSQL="update tb_reservas set estado='PAGA'" +
                "where id_reserva=?";
        
               
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
           
       
          
            pst.setInt(1, dts.getIdreserva());
            
             int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
            
        }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
         return false;
        }
    }
    
    
    public boolean deletar (vreservas dts){
        sSQL="delete from tb_reservas where id_reserva=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
             int n=pst.executeUpdate();
            if (n!=0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
             JOptionPane.showConfirmDialog(null, e);
             return false;
        }
    }
    

}
