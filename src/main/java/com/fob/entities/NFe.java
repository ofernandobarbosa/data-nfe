package com.fob.entities;

import java.util.ArrayList;

public class NFe {

    private Cabecalho cabecalho;
    private Emitente emitente;
    private ArrayList<Produto> produtos;


    public NFe() {
    }

    public NFe(Cabecalho cabecalho, Emitente emitente, ArrayList<Produto> produtos) {
        this.cabecalho = cabecalho;
        this.emitente = emitente;
        this.produtos = produtos;
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cabecalho getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(Cabecalho cabecalho) {
        this.cabecalho = cabecalho;
    }
}
