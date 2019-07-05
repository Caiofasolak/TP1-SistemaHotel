/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.vpago;
import Dados.vprodutos;
import Dados.vquartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * Classe que informa os pagamentos para serem gravados no banco de dados
 * As conexoes necessarias da classe pagamentos com o banco de dados sao realizadas
 * aqui. Os metodos para criar, editar, salvar, e retornar os dados de pagamentos
 * do banco de dados sao definidos aqui
 * Sao utilizadas consultas sql para realizar a comunicacao com o banco de dados.
 * @author caiof
 */

public class fpago {
        private conexao mysql=new conexao();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        
    //Tabela modelo de pagamentos para ser salva no banco de dados
    DefaultTableModel modelo;
    String[] titulos = {"ID PGTO", "ID reservas", "Tipo Comprovante", "Num Comprovante", "Taxa", "Total Pagamento", "Data Emissão", "Data Pagamento"};
    String[] registro = new String[8];
    totalregistros = 0;
    
    //Consulta padrao sql para os pagamentos realizados
    modelo = new DefaultTableModel(null, titulos);
    sSQL = "select * from tb_pagamentos where id_reserva=" + buscar + " order by id_pagamento";
    
    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        while(rs.next()){
               registro [0]=rs.getString("id_pagamento");
               registro [1]=rs.getString("id_reserva");
               registro [2]=rs.getString("tipo_comprovante");
               registro [3]=rs.getString("num_comprovante");
               registro [4]=rs.getString("taxa");
               registro [5]=rs.getString("total_pagamento");
               registro [6]=rs.getString("data_emissao");
               registro [7]=rs.getString("data_pagamento");
               
               totalregistros = totalregistros +1;
               modelo.addRow(registro);
        }
        return modelo;
    }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }
    
    }
    
    public boolean inserir (vpago dts){
        sSQL = "insert into tb_pagamentos (id_reserva, tipo_comprovante, num_comprovante, taxa, total_pagamento, data_emissao, data_pagamento)" +
                "values(?,?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprovante());
            pst.setString(3, dts.getNum_comprovante());
            pst.setDouble(4, dts.getTaxa());
            pst.setDouble(5, dts.getTotal_pagamento());
            pst.setDate(6, dts.getData_emissao());
            pst.setDate(7, dts.getData_pagamento());
              
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
    
    public boolean editar (vpago dts){
        
        sSQL="update tb_pagamentos set id_reserva=?, tipo_comprovante=?, num_comprovante=?, taxa=?, total_pagamento=?, data_emissao=?, data_pagamento=?" +
                "where id_pagamento=?";
        
               
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipo_comprovante());
            pst.setString(3, dts.getNum_comprovante());
            pst.setDouble(4, dts.getTaxa());
            pst.setDouble(5, dts.getTotal_pagamento());
            pst.setDate(6, dts.getData_emissao());
            pst.setDate(7, dts.getData_pagamento());
          
            pst.setInt(8, dts.getIdpagamento());
            
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
    
    public boolean deletar (vpago dts){
        sSQL="delete from tb_pagamentos where id_pagamento=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdpagamento());
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
