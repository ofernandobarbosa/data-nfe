package com.fob.entities;

public class Produto {
    private String numero;
    private String descricao;
    private String unidade;
    private Double quantidade;
    private Double precoUnitario;
    private Double valorTotal;
    private String codigo;
    private String NCM;
    private String eanComercial;

    public Produto(String numero, String codigo, String descricao, String unidade, Double quantidade, Double valorTotal, String NCM, String eanComercial) {
        this.numero = numero;
        this.codigo = codigo;
        this.descricao = descricao;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.precoUnitario = valorTotal / quantidade;
        this.valorTotal = valorTotal;
        this.NCM = NCM;
        this.eanComercial = eanComercial;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getprecoUnitario() {
        return precoUnitario;
    }

    public void setprecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getvalorTotal() {
        return valorTotal;
    }

    public void setvalorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    public String geteanComercial() {
        return eanComercial;
    }

    public void seteanComercial(String eanComercial) {
        this.eanComercial = eanComercial;
    }

    public Produto() {
    }
}
