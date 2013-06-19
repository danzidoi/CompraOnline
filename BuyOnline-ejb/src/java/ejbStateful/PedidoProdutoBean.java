/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Pedido;
import entity.PedidoProduto;
import entity.Produto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PedidoProdutoBean {

    public PedidoProduto buscar(long id);

    public PedidoProduto criar(PedidoProduto pedidoProduto);

    public PedidoProduto editar(PedidoProduto pedidoProduto);
    
    public List<PedidoProduto> buscar(Pedido pedido);
}
