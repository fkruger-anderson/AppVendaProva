/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ander
 */
public class ItemPedido {
    private final Produto produto;
    private final int qtd;
    private final float valorUnitario;

    public ItemPedido(Produto produto, int qtd, float valorUnitario) {
        this.produto = produto;
        this.qtd = qtd;
        this.valorUnitario = valorUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }
    
    public float subTotal() {
        return getQtd() * getValorUnitario();
    }

    @Override
    public String toString() {
        return String.format("%dx %s - %.2f", getQtd(), getProduto().getNome(), subTotal());
    }
}