/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Exceptions.PedidoException;
import Model.DAO.PedidoDAO;
import Model.DAO.ProdutoDAO;
import Model.ItemPedido;
import Model.Pedido;
import Model.Repository.PedidoRepository;
import Model.Repository.ProdutoRepository;
import View.Helper.TelaCadastroPedidoHelper;
import View.TelaCadastroPedido;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ander
 */
public class TelaCadastroPedidoController {
    private final TelaCadastroPedidoHelper helper;
    private Pedido pedido;

    public TelaCadastroPedidoController(TelaCadastroPedido view) {
        helper = new TelaCadastroPedidoHelper(view);
        pedido = new Pedido();
    }
    
    public void cadastrarItem() throws PedidoException {
        ItemPedido item = helper.obterItem();
        disponibilidadeEstoque(item);
        pedido.adicionarItem(item);
        
        helper.limparTela();
        atualizarItens();
        totalizador();
    }
    
    public void gravarPedido() {
        PedidoRepository pedidoRepository = new PedidoDAO();
        pedidoRepository.cadastrarPedido(pedido);
        helper.mostrarMensagem(pedido.resumoPedido());
        baixaEstoque();
        
        pedido = new Pedido();
        
        helper.limparTela();
        atualizarItens();
        totalizador();
        relatorio();
    }
    
    public void atualizarProdutos() {
        ProdutoRepository produtoRepository = new ProdutoDAO();
        helper.atualizarCbProdutos(produtoRepository.recuperarProdutos());
    }
    
    public void atualizarItens() {
        helper.atualizarTabelaProdutos(pedido.getItens());
    }
    
    public void totalizador() {
        helper.atualizarTotal(pedido.totalPedido());
    }
        
    public void relatorio() {
        PedidoRepository pedidoRepository = new PedidoDAO();
        List<Pedido> pedidos = pedidoRepository.recuperarPedidos();
        
        System.out.println(pedidos.stream()
                                  .map(Pedido::toString)
                                  .collect(Collectors.joining("\n")));
    }
    
    public void disponibilidadeEstoque(ItemPedido item) throws PedidoException {
        int acumulado = pedido.getItens()
                              .stream()
                              .filter(i -> i.getProduto().equals(item.getProduto()))
                              .mapToInt(ItemPedido::getQtd)
                              .sum();
        
        boolean disponivel = item.getProduto()
                                 .disponibilidadeEstoque(acumulado + item.getQtd());
        
        if (!disponivel) {
            throw new PedidoException("Quantidade insuficiente.");
        }
    }
    
    public void baixaEstoque() {
        pedido.getItens().forEach(i -> i.getProduto().baixarEstoque(i.getQtd()));
    }
}