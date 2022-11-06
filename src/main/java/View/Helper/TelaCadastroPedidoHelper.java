/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Helper;

import Exceptions.PedidoException;
import Model.ItemPedido;
import Model.Produto;
import View.TelaCadastroPedido;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class TelaCadastroPedidoHelper {
    public final TelaCadastroPedido view;

    public TelaCadastroPedidoHelper(TelaCadastroPedido view) {
        this.view = view;
    }
    
    public void limparTela() {
        view.getCbProduto().setSelectedIndex(0);
        view.getSpQtd().setValue(0);
    }
    
    public ItemPedido obterItem() throws PedidoException {
        Produto produto = (Produto) view.getCbProduto().getSelectedItem();
        int qtd = (int) view.getSpQtd().getValue();
        float valorUnitario = produto.getValor();
        
        if (qtd <= 0) {
            throw new PedidoException("Quantidade inválida");
        }
        
        return new ItemPedido(produto, qtd, valorUnitario);
    } 

    public void atualizarTabelaProdutos(List<ItemPedido> itens) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTbProdutos().getModel();
        tableModel.setNumRows(0);
        
        for (ItemPedido itemPedido : itens) {
            tableModel.addRow(new Object[] {
                itemPedido.getProduto().getNome(),
                itemPedido.getValorUnitario(),
                itemPedido.getQtd(),
                itemPedido.subTotal()
            });
        }
    }
    
    public void atualizarTotal(float total) {
        view.getTfTotal().setText(String.format("R$ %.2f", total));
    }

    public void atualizarCbProdutos(List<Produto> produtos) {
        produtos.forEach(p -> view.getCbProduto().addItem(p));
    }

    public void mostrarMensagem(String msg) {
        view.exibirMsg(msg);
    }
}