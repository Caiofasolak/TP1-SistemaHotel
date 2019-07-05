/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;
/**
 * A classe reservas tem seus objetos definidos aqui.
 * Os metodos getters e setters tambem sao definidos aqui.
 * @author caiof
 */

import java.sql.Date;

public class vreservas {
    private int idreserva;
    private int idquartos;
    private int idcliente;
    private int idfuncionario;
    private String tipo_reserva;
    private Date data_reserva;
    private Date data_entrada;
    private Date data_saida;
    private Double valor_quarto;
    private String estado;

    public vreservas() {
    }

    public vreservas(int idreserva, int idquartos, int idcliente, int idfuncionario, String tipo_reserva, Date data_reserva, Date data_entrada, Date data_saida, Double valor_quarto, String estado) {
        this.idreserva = idreserva;
        this.idquartos = idquartos;
        this.idcliente = idcliente;
        this.idfuncionario = idfuncionario;
        this.tipo_reserva = tipo_reserva;
        this.data_reserva = data_reserva;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.valor_quarto = valor_quarto;
        this.estado = estado;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdquartos() {
        return idquartos;
    }

    public void setIdquartos(int idquartos) {
        this.idquartos = idquartos;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Double getValor_quarto() {
        return valor_quarto;
    }

    public void setValor_quarto(Double valor_quarto) {
        this.valor_quarto = valor_quarto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

