/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ander
 */
public class Pedido {
    private final int codigo;
    private final List<ItemPedido> itens;
    private static int contadorPedido = 0;

    public Pedido() {
        itens = new ArrayList<>();
        codigo = ++contadorPedido;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
    
    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }
    
    public float totalPedido() {
        return (float) getItens().stream().mapToDouble(ItemPedido::subTotal).sum();
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String resumoPedido() {
        return String.format("Pedido #%d; Total: %.2f", getCodigo(), totalPedido());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Pedido #%d:\n", getCodigo()))
          .append(getItens().stream().map(ItemPedido::toString).collect(Collectors.joining("\n")))
          .append(String.format("\nTotal: R$ %.2f", totalPedido()));
        return sb.toString();
    }
}