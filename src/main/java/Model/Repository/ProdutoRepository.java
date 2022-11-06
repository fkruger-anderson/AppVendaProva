/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Repository;

import Model.Produto;
import java.util.List;

/**
 *
 * @author ander
 */
public interface ProdutoRepository {
    public boolean cadastrarProduto(Produto produto);
    public List<Produto> recuperarProdutos();
}