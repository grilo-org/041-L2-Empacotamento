package br.com.empacotamento.Empacotamento.dto;

import java.util.List;


public class PedidoWrapper {
    private List<PedidoRequest> pedidos;

    public List<PedidoRequest> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoRequest> pedidos) {
        this.pedidos = pedidos;
    }
}
