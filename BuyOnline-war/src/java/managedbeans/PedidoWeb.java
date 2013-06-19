// This file is a part of dcstore project,
// licensed under GPLv2
//
// Dominik Cebula
// dominikcebula@gmail.com
package managedbeans;

import ejbStateful.PedidoBean;
import ejbStateful.PedidoProdutoBean;
import ejbStateless.ClienteBean;
import ejbStateless.ProdutoBean;
import entity.Cliente;
import entity.Pedido;
import entity.PedidoProduto;
import entity.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PedidoWeb {

    private List<PedidoProduto> pedidos = new ArrayList<PedidoProduto>();
    @EJB
    private PedidoBean pedidoBean;
    @EJB
    private PedidoProdutoBean pedidoProdutoBean;
    @EJB
    private ClienteBean clienteBean;

    public PedidoWeb() {
    }

    public List<PedidoProduto> getPedidos() {
        return pedidos;
    }

    public void buscarPedidos(Long idCliente) {
        Cliente cliente = clienteBean.buscar(idCliente);

        for (Pedido pedido : pedidoBean.buscar(cliente)) {
            for(PedidoProduto pedidoProduto : pedidoProdutoBean.buscar(pedido))
            {
                pedidos.add(pedidoProduto);
            }
        }
    }
}
