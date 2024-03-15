package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

    private String titulo;
    private List<Produto> produtos = new ArrayList<>();


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
