/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Pedido;
import Model.Repository.PedidoRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ander
 */
public class PedidoDAO implements PedidoRepository {
    public static final List<Pedido> bancoPedidos = new ArrayList<>();

    @Override
    public boolean cadastrarPedido(Pedido pedido) {
        return bancoPedidos.add(pedido);
    }

    @Override
    public List<Pedido> recuperarPedidos() {
        return bancoPedidos;
    }
}