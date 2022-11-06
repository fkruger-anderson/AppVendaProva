/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ProdutoDAO;
import Model.Produto;
import Model.Repository.ProdutoRepository;
import View.Helper.TelaCadastroProdutoHelper;
import View.TelaCadastroProduto;

/**
 *
 * @author ander
 */
public class TelaCadastroProdutoController {
    private final TelaCadastroProdutoHelper helper; 

    public TelaCadastroProdutoController(TelaCadastroProduto view) {
        helper = new TelaCadastroProdutoHelper(view);
    }
    
    public void cadastrarProduto() {
        Produto produto = helper.obterProduto();
        ProdutoRepository produtoRepository = new ProdutoDAO();
        produtoRepository.cadastrarProduto(produto);
        
        helper.limparTela();
        atualizarTbEstoque();
    }
    
    public void atualizarTbEstoque() {
        ProdutoRepository produtoRepository = new ProdutoDAO();
        helper.preencherTabela(produtoRepository.recuperarProdutos());
    } 
}