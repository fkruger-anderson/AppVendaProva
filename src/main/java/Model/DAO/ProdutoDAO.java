/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Produto;
import Model.Repository.ProdutoRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ander
 */
public class ProdutoDAO implements ProdutoRepository {
    private static final List<Produto> bancoProdutos = new ArrayList<>();

    @Override
    public boolean cadastrarProduto(Produto produto) {
        return bancoProdutos.add(produto);
    }

    @Override
    public List<Produto> recuperarProdutos() {
        return bancoProdutos;
    }   
}