/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;
/**
 * Classe pessoas que se extende a cliente e funcionario, tem os objetos necessarios
 * para a utilizacao durante o programa. Os metodos getters e setters sao definidos aqui.
 * @author caiof
 */

public class vpessoas {
    private int id_pessoa;
    private String nome;
    private String nome_pai;
    private String nome_mae;
    private String tipo_documento;
    private String num_documento;
    private String endereco;
    private String telefone;
    private String email;

    public vpessoas() {
    }

    public vpessoas(int id_pessoa, String nome, String nome_pai, String nome_mae, String tipo_documento, String num_documento, String endereco, String telefone, String email) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.nome_pai = nome_pai;
        this.nome_mae = nome_mae;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
