/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Helper;

import Model.Produto;
import View.TelaCadastroProduto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ander
 */
public class TelaCadastroProdutoHelper {
    public final TelaCadastroProduto view;
    
    public TelaCadastroProdutoHelper(TelaCadastroProduto view) {
        this.view = view;
    }
    
    public void limparTela() {
        view.getTfProduto().setText("");
        view.getTfQtd().setText("");
        view.getTfValor().setText("");
    }
    
    public Produto obterProduto() {
        try {
            String nome = view.getTfProduto().getText();
            float valor = Float.parseFloat(view.getTfValor().getText());
            int qtd = Integer.parseInt(view.getTfQtd().getText());
            return new Produto(nome, valor, qtd);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Dados inválidos.");
        }
    }
    
    public void preencherTabela(List<Produto> produtos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTbEstoque().getModel();
        tableModel.setNumRows(0);
        
        for (Produto produto : produtos) {
            tableModel.addRow(new Object[]{
                String.format("%d", produto.getCodigo()),
                produto.getNome(),
                produto.getValor(),
                produto.getQtd()
            });
        }
    }

    public void mostrarMensagem(String message) {
        view.exibirMensagem(message);
    }
}