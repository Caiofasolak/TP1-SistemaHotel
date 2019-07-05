/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;
/**
 * Classe cliente que herda caracteristicas de pessoas
 * Aqui sao criados os metodos getters e setters para clientes
 * @author caiof
 */

public class vclientes extends vpessoas {
    private String codigo_cliente;

    public vclientes() {
    }

    public vclientes(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    
}
