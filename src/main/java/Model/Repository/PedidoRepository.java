/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Repository;

import Model.Pedido;
import java.util.List;

/**
 *
 * @author ander
 */
public interface PedidoRepository {
    public boolean cadastrarPedido(Pedido pedido);
    public List<Pedido> recuperarPedidos();
}