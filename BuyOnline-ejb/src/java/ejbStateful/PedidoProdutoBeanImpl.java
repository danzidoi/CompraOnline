/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Pedido;
import entity.PedidoProduto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/pedidoProduto")
public class PedidoProdutoBeanImpl implements PedidoProdutoBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public PedidoProduto buscar(long id) {
        return em.find(PedidoProduto.class, id);
    }

    @Override
    public List<PedidoProduto> buscar(Pedido pedido) {
        Query query = em.createQuery("SELECT x FROM PedidoProduto x WHERE x.pedido = :pedido");

        try {
            return (List<PedidoProduto>) query.setParameter("pedido", pedido).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public PedidoProduto criar(PedidoProduto pedidoProduto) {
        em.persist(pedidoProduto);
        return pedidoProduto;
    }

    @Override
    public PedidoProduto editar(PedidoProduto pedidoProduto) {
        return em.merge(pedidoProduto);
    }
}
