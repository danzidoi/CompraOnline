/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.EstoqueProduto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/estoqueProduto")
public class EstoqueProdutoBeanImpl implements EstoqueProdutoBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public EstoqueProduto buscar(long id) {
        return em.find(EstoqueProduto.class, id);
    }

    @Override
    public EstoqueProduto criar(EstoqueProduto estoqueProduto) {
        em.persist(estoqueProduto);
        return estoqueProduto;
    }

    @Override
    public EstoqueProduto editar(EstoqueProduto estoqueProduto) {
        return em.merge(estoqueProduto);
    }
}
