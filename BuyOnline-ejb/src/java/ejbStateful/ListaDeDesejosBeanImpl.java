/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.ListaDeDesejos;
import entity.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

class ListaDeDesejosBeanImpl implements ListaDeDesejosBean {

    private List<Produto> listaProduto = new ArrayList<Produto>();
    @PersistenceContext(unitName = "BuyOnline-ejbPU")
    private EntityManager em;

    @Override
    public ListaDeDesejos buscar(long id) {
        return em.find(ListaDeDesejos.class, id);
    }

    @Override
    public void adicionarProduto(Produto produto) {
        listaProduto.add(produto);
    }

    @Override
    public void removerProduto(Produto produto) {
        listaProduto.remove(produto);
    }

    @Override
    public List<Produto> getProduto() {
        return listaProduto;
    }
}
