/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Estoque;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/estoque")
public class EstoqueBeanImpl implements EstoqueBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public Estoque buscar(long id) {
        return em.find(Estoque.class, id);
    }

    @Override
    public Estoque criar(Estoque estoque) {
        em.persist(estoque);
        return estoque;
    }

    @Override
    public List<Estoque> buscar() {
        return em.createQuery("select x from Estoque x").getResultList();
    }
}
