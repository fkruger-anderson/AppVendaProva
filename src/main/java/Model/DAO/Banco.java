/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Produto;
import Model.Repository.ProdutoRepository;

/**
 *
 * @author ander
 */
public class Banco {
    public static void inicia() {
        ProdutoRepository produtoRepository = new ProdutoDAO();

        Produto p1 = new Produto("Pão", 10.50f, 30);
        Produto p2 = new Produto("Bolo", 20.50f, 20);
        Produto p3 = new Produto("Café", 5.50f, 50);
        Produto p4 = new Produto("Água", 2.50f, 20);
        Produto p5 = new Produto("Cuca", 15.50f, 30);
        Produto p6 = new Produto("Torta", 1.50f, 60);

        produtoRepository.cadastrarProduto(p1);
        produtoRepository.cadastrarProduto(p2);
        produtoRepository.cadastrarProduto(p3);
        produtoRepository.cadastrarProduto(p4);
        produtoRepository.cadastrarProduto(p5);
        produtoRepository.cadastrarProduto(p6);
    }
}