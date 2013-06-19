/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "ejb/cliente")
public class ClienteBeanImpl implements ClienteBean {

    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public Cliente buscar(long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscar() {
        return em.createQuery("select x from Cliente x").getResultList();
    }

    @Override
    public Cliente buscar(String email) {
        Query query = em.createQuery("SELECT x FROM Cliente x WHERE x.email = :email");

        try {
            return (Cliente) query.setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Cliente buscar(String email, String senha) {
        Cliente cliente = buscar(email);

        if (cliente != null && cliente.getSenha().equals(senha)) {
            return cliente;
        }
        return null;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        em.persist(cliente);
        return cliente;
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return em.merge(cliente);
    }
}
