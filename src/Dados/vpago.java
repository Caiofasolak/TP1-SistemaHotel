/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;
/**
 * Classe do pagamento, define os objetos necessários para os pagamentos realizados
 * no programa. Os metodos getters e setters tambem sao definidos aqui.
 * @author caiof
 */

import java.sql.Date;

public class vpago {
    private int idpagamento;
    private int idreserva;
    private String tipo_comprovante;
    private String num_comprovante;
    private Double taxa;
    private Double total_pagamento;
    private Date data_emissao;
    private Date data_pagamento;

    public vpago() {
    }

    public vpago(int idpagamento, int idreserva, String tipo_comprovante, String num_comprovante, Double taxa, Double total_pagamento, Date data_emissao, Date data_pagamento) {
        this.idpagamento = idpagamento;
        this.idreserva = idreserva;
        this.tipo_comprovante = tipo_comprovante;
        this.num_comprovante = num_comprovante;
        this.taxa = taxa;
        this.total_pagamento = total_pagamento;
        this.data_emissao = data_emissao;
        this.data_pagamento = data_pagamento;
    }

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipo_comprovante() {
        return tipo_comprovante;
    }

    public void setTipo_comprovante(String tipo_comprovante) {
        this.tipo_comprovante = tipo_comprovante;
    }

    public String getNum_comprovante() {
        return num_comprovante;
    }

    public void setNum_comprovante(String num_comprovante) {
        this.num_comprovante = num_comprovante;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Double getTotal_pagamento() {
        return total_pagamento;
    }

    public void setTotal_pagamento(Double total_pagamento) {
        this.total_pagamento = total_pagamento;
    }

    public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
    
}
