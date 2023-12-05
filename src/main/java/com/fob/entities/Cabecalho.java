package com.fob.entities;

import java.util.Date;

public class Cabecalho {
    private String modelo;
    private String serie;
    private String numero;
    private Date dataEmissao;
    private Date dataEntradaSaida;
    private Double total;
    private String cpfCliente;
    private String meioDePagamento;

    public Cabecalho(String modelo, String serie, String numero, Date dataEmissao, Date dataEntradaSaida, Double total, String cpfCliente, String meioDePagamento) {
        this.modelo = modelo;
        this.serie = serie;
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        this.dataEntradaSaida = dataEntradaSaida;
        this.total = total;
        this.cpfCliente = cpfCliente;
        this.meioDePagamento = meioDePagamento;
    }

    public Cabecalho() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataEntradaSaida() {
        return dataEntradaSaida;
    }

    public void setDataEntradaSaida(Date dataEntradaSaida) {
        this.dataEntradaSaida = dataEntradaSaida;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getMeioDePagamento() {
        return meioDePagamento;
    }

    public void setMeioDePagamento(String meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }
}
