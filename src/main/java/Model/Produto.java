/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ander
 */
public class Produto {
    private final int codigo; 
    private String nome;
    private float valor;
    private int qtd;
    
    private static int contadorProduto = 0;

    public Produto(String nome, float valor, int qtd) {
        this.codigo = ++contadorProduto;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    private void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public boolean baixarEstoque(int qtdVendida) {
        if (qtdVendida <= getQtd()) {
            setQtd(getQtd() - qtdVendida);
            return true;
        }
        return false;
    }
    
    public boolean disponibilidadeEstoque(int qtdSolicitada) {
        return qtdSolicitada <= getQtd();
    }

    @Override
    public String toString() {
        return String.format("%s - R$%.2f", getNome(), getValor());
    }
}