/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dados.vprodutos;
import Dados.vquartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * Conexoes da classe de produtos com o banco de dados sao realizadas aqui
 * As consultas sql necessarias sao realizadas abaixo 
 * Os metodos para criar, salvar, editar, e retornar os dados dos produtos sao 
 * definidos abaixo.
 * @author caiof
 */

public class fprodutos {
    private conexao mysql=new conexao();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        
    //Tabela padrao para os produtos serem salvos no banco de dados
    DefaultTableModel modelo;
    String[] titulos = {"ID", "Produto", "Descrição", "Unidade Medida", "Preço Venda"};
    String[] registro = new String[5];
    totalregistros = 0;
    
    //Consulta em sql para retornar os dados do banco de dados
    modelo = new DefaultTableModel(null, titulos);
    sSQL = "select * from tb_produtos where nome like '%" + buscar + "%' order by id_produto";
    
    try{
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSQL);
        while(rs.next()){
           registro [0]=rs.getString("id_produto");
               registro [1]=rs.getString("nome");
               registro [2]=rs.getString("descricao");
               registro [3]=rs.getString("unidade_medida");
               registro [4]=rs.getString("preco_venda");
                
               
               totalregistros = totalregistros +1;
               modelo.addRow(registro);
        }
        return modelo;
    }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        return null;
    }
    
    }
    
    public boolean inserir (vprodutos dts){
        sSQL = "insert into tb_produtos (nome, descricao, unidade_medida, preco_venda)" +
                "values(?,?,?,?)";
        
        try {
            
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getDescricao());
            pst.setString(3, dts.getUnidade_medida());
            pst.setDouble(4, dts.getValor_produto());
           
            
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
    
    public boolean editar (vprodutos dts){
        
        sSQL="update tb_produtos set nome=?, descricao=?, unidade_medida=?, preco_venda=?" +
                "where id_produto=?";
        
               
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getDescricao());
            pst.setString(3, dts.getUnidade_medida());
            pst.setDouble(4, dts.getValor_produto());
          
            pst.setInt(5, dts.getIdproduto());
            
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
    
    public boolean deletar (vprodutos dts){
        sSQL="delete from tb_produtos where id_produto=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproduto());
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
