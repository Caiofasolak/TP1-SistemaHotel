/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author Hugo
 */
public class vconsumo {
    private int idconsumo;
    private int idreserva;
    private int idproduto;
    private Double quantidade;
    private Double preco_venda;
    private String estado;

    public vconsumo() {
    }

    public vconsumo(int idconsumo, int idreserva, int idproduto, Double quantidade, Double preco_venda, String estado) {
        this.idconsumo = idconsumo;
        this.idreserva = idreserva;
        this.idproduto = idproduto;
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.estado = estado;
    }

    public int getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(int idconsumo) {
        this.idconsumo = idconsumo;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
