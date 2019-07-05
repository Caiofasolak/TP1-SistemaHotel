/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.vconsumo;
import Dados.vprodutos;
import Dados.vquartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * Classe consumo, se liga ao banco de dados hospedado em phpMyAdmin
 * Aqui e realizada a conexao necessaria com o bando de dados
 * Pesquisas sql sao definidas aqui para serem passadas ao banco de dados
 * Os metodos para criar,salvar,editar,e retornar do banco de dados tambem sao
 * definidos aqui
 * @author caiof
 */

public class fconsumo {
    private conexao mysql=new conexao();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    public Double totalconsumo;
    
    public DefaultTableModel mostrar(String buscar){
    
    //Modelo padrao de tabela que sera salvo no banco de dados
    DefaultTableModel modelo;
    String[] titulos = {"ID consumo", "ID reserva", "ID produto", "Produto", "Quantidade", "Preco Venda", "Estado"};
    String[] registro = new String[7];
    totalregistros = 0;
    totalconsumo = 0.0;
    
    modelo = new DefaultTableModel(null, titulos);
    //Define uma pessquisa sql para os campos defindos acima
    sSQL="select c.id_consumo,c.id_reserva,c.id_produto,p.nome,c.quantidade,c.preco_venda "
               + ",c.estado from tb_consumo c inner join tb_produtos p on c.id_produto=p.id_produto"
               + " where c.id_reserva ="+ buscar + " order by c.id_consumo desc";
    
    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        while(rs.next()){
               registro [0]=rs.getString("id_consumo");
               registro [1]=rs.getString("id_reserva");
               registro [2]=rs.getString("id_produto");
               registro [3]=rs.getString("nome");
               registro [4]=rs.getString("quantidade");
               registro [5]=rs.getString("preco_venda");
               registro [6]=rs.getString("estado");
                
               
               totalregistros = totalregistros +1;
               totalconsumo = totalconsumo + (rs.getDouble("quantidade") * rs.getDouble("preco_venda"));
               
               modelo.addRow(registro);
        }
        return modelo;
    }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }
    
    }
    
    public boolean inserir (vconsumo dts){
        sSQL = "insert into tb_consumo (id_reserva, id_produto, quantidade, preco_venda, estado)" +
                "values(?,?,?,?,?)";
        
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproduto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());
            
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
    
    public boolean editar (vconsumo dts){
        
        sSQL="update tb_consumo set id_reserva=?, id_produto=?, quantidade=?, preco_venda=?, estado=?" +
                "where id_consumo=?";
        
               
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproduto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());
            pst.setInt(6, dts.getIdconsumo());
            
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
    
    public boolean deletar (vconsumo dts){
        sSQL="delete from tb_consumo where id_consumo=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdconsumo());
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
