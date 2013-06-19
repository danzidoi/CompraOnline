/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Cliente;
import entity.Pedido;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PedidoBean {

    public Pedido buscar(long id);

    public List<Pedido> buscar();

    public Pedido criar(Pedido pedido);

    public Pedido editar(Pedido pedido);

    public void fecharPedidoOnline();

    public void fecharPedidoBalcao();

    public List<Pedido> buscar(Cliente cliente);
}
