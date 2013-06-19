/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Cliente;
import entity.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/pedido")
public class PedidoBeanImpl implements PedidoBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public Pedido buscar(long id) {
        return em.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> buscar() {
        return em.createQuery("select x from Pedido x").getResultList();
    }
    
    @Override
    public List<Pedido> buscar(Cliente cliente) {
        Query query = em.createQuery("SELECT x FROM Pedido x WHERE x.cliente = :cliente");

        try {
            return (List<Pedido>) query.setParameter("cliente", cliente).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Pedido criar(Pedido pedido) {
        em.persist(pedido);
        return pedido;
    }

    @Override
    public Pedido editar(Pedido pedido) {
        return em.merge(pedido);
    }

    @Override
    public void fecharPedidoOnline() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fecharPedidoBalcao() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
