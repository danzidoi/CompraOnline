/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Estoque;
import entity.Filial;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/filial")
public class FilialBeanImpl implements FilialBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public Filial buscar(long id) {
        return em.find(Filial.class, id);
    }

    @Override
    public List<Filial> buscar() {
        return em.createQuery("select x from Filial x").getResultList();
    }

    @Override
    public Estoque buscarEstoque(Filial filial) {
        Query query = em.createQuery("SELECT x FROM Estoque x WHERE x.filial = :filial");

        try {
            return (Estoque) query.setParameter("filial", filial).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public Filial criar(Filial filial) {
        em.persist(filial);
        return filial;
    }

    @Override
    public Filial editar(Filial filial) {
        return em.merge(filial);
    }
}
