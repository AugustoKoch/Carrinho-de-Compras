package br.com.model;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //produtos
        Produto leiteIntegral = new Produto();
        leiteIntegral.setNome("Leite Integral");
        leiteIntegral.setDescricao("Leite integral, fonte de cálcio");
        leiteIntegral.setPreco(3.50);
        leiteIntegral.setCodigo(246810);

        Produto paoDeForma = new Produto();
        paoDeForma.setNome("Pão de Forma");
        paoDeForma.setDescricao("Pão de Forma, rico em fibras");
        paoDeForma.setPreco(6.00);
        paoDeForma.setCodigo(135792);

        Produto detergenteLiquido = new Produto();
        detergenteLiquido.setNome("Detergente Líquido");
        detergenteLiquido.setDescricao("Detergente líquido para limpeza de louças.");
        detergenteLiquido.setPreco(2.00);
        detergenteLiquido.setCodigo(112233);

        Produto cafeEmGraos = new Produto();
        cafeEmGraos.setNome("Café em Grãos");
        cafeEmGraos.setDescricao("Café premium em grãos, torra média.");
        cafeEmGraos.setPreco(13.00);
        cafeEmGraos.setCodigo(445566);

        //catálogo
        Catalogo catalogo = new Catalogo();
        catalogo.setTitulo("Catálogo");
        catalogo.getProdutos().add(leiteIntegral);
        catalogo.getProdutos().add(paoDeForma);
        catalogo.getProdutos().add(detergenteLiquido);
        catalogo.getProdutos().add(cafeEmGraos);

        //carrinho
        Carrinho carrinho = new Carrinho();

        //cliente
        PessoaFisica pessoaFisica = new PessoaFisica();
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        //scanner
        Scanner sc = new Scanner(System.in);

        //controladores
        boolean cadastro = true;
        boolean sistema = true;


        //inicio
        while (cadastro){
            System.out.println();
            System.out.println("Bem-vindo ao supermercado Koch!");
            System.out.println("Vamos fazer seu cadastro. Digite '1' para pessoa física ou '2' para pessoa Jurídica");
            String TipoCliente = sc.nextLine();
            System.out.println();

            if (Objects.equals(TipoCliente, "1")){
                System.out.println("Selecionado: pessoa física");
                System.out.println("Insira seu nome: ");
                pessoaFisica.setNome(sc.nextLine());
                System.out.println();
                System.out.println("Insira seu CPF: ");
                pessoaFisica.setCpf(sc.nextLine());
                carrinho.setCliente(pessoaFisica);
                System.out.println("Cadastrado com sucesso!");
                System.out.println();
                System.out.println("Seja bem-vindo, " + pessoaFisica.getNome() + "!");

                cadastro = false;

            }else if (Objects.equals(TipoCliente, "2")){
                System.out.println("Selecionado: pessoa jurídica");
                System.out.println("Insira o nome da empresa: ");
                pessoaJuridica.setNome(sc.nextLine());
                System.out.println();
                System.out.println("Insira o CNPJ da empresa: ");
                pessoaJuridica.setCnpj(sc.nextLine());
                carrinho.setCliente(pessoaJuridica);
                System.out.println("Cadastrado com sucesso!");
                System.out.println();
                System.out.println("Seja bem-vindo, " + pessoaJuridica.getNome() + "!");

                cadastro = false;

            }else {
                System.out.println("Opção inválida. Tente novamente");
            }
        }

        while (sistema){
            System.out.println("Digite a opção que deseja: ");
            System.out.println("1 VER CATÁLOGO");
            System.out.println("2 ADICIONAR");
            System.out.println("3 REMOVER");
            System.out.println("4 ELIMINAR");
            System.out.println("5 BUSCAR ITEM");
            System.out.println("6 ENCERRAR");
            String opt = sc.nextLine();
            System.out.println();

            if (Objects.equals(opt, "1")){
                int contador = 0;
                for (Produto produto : catalogo.getProdutos()) {
                    contador += 1;
                    System.out.println(contador + " - " +produto.getNome());
                    System.out.println("R$" + produto.getPreco());
                    System.out.println(produto.getDescricao());
                    System.out.println("cod: " + produto.getCodigo());
                    System.out.println();
                }

            } else if (Objects.equals(opt, "2")) {
                try {
                    System.out.println("Digite o número do item que deseja adicionar de acordo com o catálogo: ");
                    int select = sc.nextInt() - 1;
                    Produto prod = catalogo.getProdutos().get(select);

                    System.out.println();
                    System.out.println("Produto selecionado: " + prod.getNome());
                    System.out.println("Digite a quantidade que deseja: ");
                    int qtd = sc.nextInt();

                    carrinho.adicionar(prod, qtd);

                }catch (IndexOutOfBoundsException | InputMismatchException e){
                    System.out.println("\nOpção inválida, tente novamente\n");
                }
                sc.nextLine();

            } else if (Objects.equals(opt, "3")) {
                try {
                    System.out.println("Digite o número do item que deseja remover de acordo com o catálogo: ");
                    int select = sc.nextInt() - 1;
                    Produto prod = catalogo.getProdutos().get(select);

                    System.out.println();
                    System.out.println("Produto selecionado: " + prod.getNome());
                    System.out.println("Digite a quantidade que deseja remover:");
                    int qtd = sc.nextInt();

                    carrinho.remover(prod, qtd);

                }catch (IndexOutOfBoundsException | InputMismatchException e){
                    System.out.println("\nOpção inválida, tente novamente\n");
                }
                sc.nextLine();

            } else if (Objects.equals(opt, "4")) {
                try {
                    System.out.println("Digite o número do item que deseja eliminar de acordo com o catálogo: ");
                    int select = sc.nextInt() - 1;
                    Produto prod = catalogo.getProdutos().get(select);

                    System.out.println();
                    System.out.println("Produto selecionado: " + prod.getNome());

                    carrinho.eliminar(prod);

                }catch (IndexOutOfBoundsException | InputMismatchException e){
                    System.out.println("\nOpção inválida, tente novamente\n");
                }
                sc.nextLine();

            } else if (Objects.equals(opt, "5")) {
                try {
                    System.out.println("Digite o número do item que deseja buscar de acordo com o catálogo: ");
                    int select = sc.nextInt() - 1;
                    Produto prod = catalogo.getProdutos().get(select);

                    if (carrinho.buscaItem(prod) == null){
                        System.out.println();
                        System.out.println("Item não encontrado no carrinho");
                        System.out.println();
                    } else {
                        String nomeProd = carrinho.buscaItem(prod).getProduto().getNome();
                        int qtd = carrinho.buscaItem(prod).getQuantidade();

                        System.out.println();
                        System.out.println(nomeProd);
                        System.out.println("Quantidade: " + qtd);
                        System.out.println();
                    }

                }catch (IndexOutOfBoundsException | InputMismatchException e){
                    System.out.println("\nOpção inválida, tente novamente\n");
                }
                sc.nextLine();

            } else if (Objects.equals(opt, "6")) {
                System.out.println();
                System.out.println("Sistema encerrado");
                sistema = false;

            } else {
                System.out.println("Opção inválida, tente novamente");
                System.out.println();
            }
        }
    }
}