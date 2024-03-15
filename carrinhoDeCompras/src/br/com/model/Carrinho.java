package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private Cliente cliente;
    private List<ItemDeCompra> itens = new ArrayList<>();


    public void adicionar(Produto prod, int qtd){

        boolean itemEncontrado = false;
        for (ItemDeCompra itemNoCarrinho : itens) {
            if (itemNoCarrinho.getProduto() == prod){
                itemNoCarrinho.setQuantidade(itemNoCarrinho.getQuantidade() + qtd);
                itemEncontrado = true;
            }
        }
        if (!itemEncontrado){
            ItemDeCompra item = new ItemDeCompra();
            item.setProduto(prod);
            item.setQuantidade(qtd);
            itens.add(item);
        }
        System.out.println();
        System.out.println("Itens adicionados ao carrinho!");
        System.out.println("Total: R$" + calcularTotal());
        System.out.println();
    }

    public void remover(Produto prod, int qtd){

        boolean itemEncontrado = false;
        ItemDeCompra item = new ItemDeCompra();

        for (ItemDeCompra itemNoCarrinho : itens) {
            if (itemNoCarrinho.getProduto() == prod){
                item = itemNoCarrinho;
                itemEncontrado = true;
            }
        }
        if (itemEncontrado){
            if (item.getQuantidade() > qtd){
                item.setQuantidade(item.getQuantidade() - qtd);
                System.out.println();
                System.out.println("Itens removidos!");
            }else if (item.getQuantidade() < qtd){
                System.out.println();
                System.out.println("A quantidade a remover é maior que a quantidade de itens");
                itens.remove(item);
                System.out.println("Todos os itens foram removidos!");
            }else {
                itens.remove(item);
                System.out.println();
                System.out.println("Todos os itens foram removidos!");
            }
        }else {
            System.out.println();
            System.out.println("Item não encontrado no carrinho");
        }
        System.out.println("Total: R$" + calcularTotal());
        System.out.println();
    }

    public void eliminar(Produto prod){

        boolean itemEncontrado = false;
        ItemDeCompra item = new ItemDeCompra();
        for (ItemDeCompra itemNoCarrinho : itens) {
            if (itemNoCarrinho.getProduto() == prod) {
                item = itemNoCarrinho;
                itemEncontrado = true;
            }
        }
        if (itemEncontrado){
            itens.remove(item);
            System.out.println("Item eliminado do carrinho!");
        } else {
            System.out.println("Item não encontrado no carrinho");
        }

        System.out.println("Total: R$" + calcularTotal());
        System.out.println();
    }

    public double calcularTotal(){

        double total = 0;
        for (ItemDeCompra itemNoCarrinho : itens) {
            double preco = itemNoCarrinho.getProduto().getPreco();
            int qtd = itemNoCarrinho.getQuantidade();
            total += preco * qtd;
        }
        return total;
    }

    public ItemDeCompra buscaItem(Produto prod){

        for (ItemDeCompra itemNoCarrinho : itens) {
            if (itemNoCarrinho.getProduto() == prod) {
                return itemNoCarrinho;
            }
        }
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemDeCompra> getItens() {
        return itens;
    }

    public void setIntens(List<ItemDeCompra> itens) {
        this.itens = itens;
    }
}
