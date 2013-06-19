/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/produto")
public class ProdutoBeanImpl implements ProdutoBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public Produto buscar(long id) {
        return em.find(Produto.class, id);
    }

    @Override
    public List<Produto> buscar() {
        return em.createQuery("select x from Produto x").getResultList();
    }

    @Override
    public Produto criar(Produto produto) {
        em.persist(produto);
        return produto;
    }

    @Override
    public Produto editar(Produto produto) {
        return em.merge(produto);
    }
}
