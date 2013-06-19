/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Departamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "ejb/departamento")
public class DepartamentoBeanImpl implements DepartamentoBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public Departamento buscar(long id) {
        return em.find(Departamento.class, id);
    }

    @Override
    public Departamento criar(Departamento departamento) {
        em.persist(departamento);
        return departamento;
    }

    @Override
    public List<Departamento> buscar() {
        return em.createQuery("select x from Departamento x").getResultList();
    }
}
