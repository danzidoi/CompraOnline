/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Cliente;
import entity.Endereco;
import entity.Filial;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/endereco")
public class EnderecoBeanImpl implements EnderecoBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public List<Endereco> buscar() {
        return em.createQuery("select x from Endereco x").getResultList();
    }

    @Override
    public Endereco buscar(long id) {
        return em.find(Endereco.class, id);
    }

    @Override
    public Filial buscarFilial(Endereco endereco) {
        Query query = em.createQuery("SELECT x FROM Filial x WHERE x.endereco = :endereco");

        try {
            return (Filial) query.setParameter("endereco", endereco).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Cliente buscarCliente(Endereco endereco) {
        Query query = em.createQuery("SELECT x FROM Cliente x WHERE x.endereco = :endereco");

        try {
            return (Cliente) query.setParameter("endereco", endereco).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Endereco criar(Endereco endereco) {
        em.persist(endereco);
        return endereco;
    }

    @Override
    public Endereco editar(Endereco entidade) {
        return em.merge(entidade);
    }
}
